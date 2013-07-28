package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import schemacrawler.schema.Column;

import everything.DBUtil;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class StringAttribute extends PrimaryAttribute {
    protected String value;
    protected String replacement;
    
    private StringAttribute(StringAttribute toClone) {
        value = toClone.value;
        replacement = toClone.replacement;
    }
    
    StringAttribute(Column column) {
        name = column.getName();
    }
    
    public String value() {
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
        replacement = value;
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
            ps.setString(2, replacement);
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
    
    protected void update() throws RegException {
        if (isNew) {
            String message = getValue() + " does not yet exist.";
            throw new RegException(message);   
        }
        
        if (value.equals(replacement)) 
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
            value = replacement;
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
    protected String getValue() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected Attribute clone() {
        return new StringAttribute(this);
    }
}