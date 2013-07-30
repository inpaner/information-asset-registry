package model.attribute;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Log;
import model.RegException;

import schemacrawler.schema.Column;

import everything.DBUtil;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class StringAttribute extends PrimaryAttribute {
    protected String value;
    protected String previousValue;
    
    StringAttribute() {
    }
    
    StringAttribute(Column column) {
        super(column);
    }
    
    public String getValueString() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
    
    public StringAttribute(int assetFk, String value) {
        this.assetFk = assetFk;
        setValue(value);
    }
    
    public void setValue(String value) {
        previousValue = value;
        if (isNew)
            this.value = value;
    }

    private void insert(int assetFk) throws RegException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection conn = DBUtil.getConnection();
            String update = 
                "INSERT INTO `" + getValue() + "` (assetFk, value) " +
                "VALUES (?, ?)";
            ps = conn.prepareStatement(update);                
            ps.setInt(1, assetFk);
            ps.setString(2, previousValue);
            ps.executeUpdate();
            
            isNew = false;
            this.assetFk = assetFk;
        }
        catch (MySQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
            String message = "Invalid value for " + getValue() + ".";
            throw new RegException(message);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.close(rs);
            DBUtil.close(ps);
        }   
    }

    protected void add(int assetFk) throws RegException {
        if (!isNew) {
            String message = getValue() + " already exists.";
            throw new RegException(message);            
        }
        if (value == null) {
            String message = getValue() + " not set.";
            throw new RegException(message);            
        }
        insert(assetFk);
    }
    
    public void update() throws RegException {
        if (isNew) {
            String message = getValue() + " does not yet exist.";
            throw new RegException(message);   
        }
        
        if (value.equals(previousValue)) 
            return;
        // early return
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            insert(assetFk);
            Connection conn = DBUtil.getConnection();
            ps = conn.prepareStatement("SELECT LAST_INSERT_ID() AS fk");
            rs = ps.executeQuery();
            rs.next();
            
            int attributeFk = rs.getInt("fk");
            Log.updateAttribute(assetFk, getValue(), attributeFk);
            value = previousValue;
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            DBUtil.close(rs);
            DBUtil.close(ps);
        }   
    }

    @Override
    public String getValue() {
        return null;
    }

    @Override
    public Attribute clone() {
        StringAttribute clone = new StringAttribute();
        clone.name = name;
        clone.value = value;
        clone.previousValue = previousValue;
        
        return clone;
    }

    @Override
    protected void forceValue(String value) {
        this.value = value;
    }

    @Override
    public void setValue(ResultSet rs) throws SQLException {
        value = rs.getString(name);
    }

    @Override
    public boolean isUpdated() {
        return !value.equals(previousValue);
    }

    @Override
    public void commitValue() {
        previousValue = value;
    }
    
    public void resetValue() {
        value = previousValue;
    }
}
