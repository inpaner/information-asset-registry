package model.attribute;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Vector;

import model.Log;
import model.RegException;
import model.db.DBUtil;

import schemacrawler.schema.Column;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;


public class IntegerAttribute extends PrimaryAttribute {
    protected int value = 0;
    protected int previousValue = 0;
    
    private IntegerAttribute() {
    }
    
    IntegerAttribute(Column column) {
        super(column);
    }
    
    public int value() {
        return value;
    }
    
    public String toString() {
        return String.valueOf(value);
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    private void insert(int assetFk) throws RegException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection conn = DBUtil.getConnection();
            System.out.println("here");
            String update = 
                "INSERT INTO " + getSQLValue() + " (assetFk, value) " +
                "VALUES (?, ?)";
            ps = conn.prepareStatement(update);                
            ps.setInt(1, assetFk);
            ps.setInt(2, previousValue);
            ps.executeUpdate();
            
            isNew = false;
            this.assetFk = assetFk;
        }
        catch (MySQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
            String message = "Invalid value for " + getSQLValue() + ".";
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
            String message = getSQLValue() + " already exists.";
            throw new RegException(message);            
        }
        if (value == 0) {
            String message = getSQLValue() + " not set.";
            throw new RegException(message);            
        }
        insert(assetFk);
    }
    
    public void update() throws RegException {
        if (isNew) {
            String message = getSQLValue() + " does not yet exist.";
            throw new RegException(message);   
        }
        
        if (value == previousValue) 
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
            Log.updateAttribute(assetFk, getSQLValue(), attributeFk);
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
    public String getSQLValue() {
        return String.valueOf(value);
    }

    @Override
    public Attribute clone() {
        IntegerAttribute clone = new IntegerAttribute();
        clone.name = name;
        clone.value = value;
        clone.previousValue = previousValue;
        return clone;
    }

    @Override
    public void setValue(ResultSet rs) throws SQLException {
        value = rs.getInt(name);
    }

    @Override
    public boolean isUpdated() {
        return value != previousValue;
    }

    @Override
    public void commitValue() {
        previousValue = value;
    }

    @Override
    public void resetValue() {
        value = previousValue;
    }

    @Override
    protected void forceValue(String value) {
        this.value = Integer.valueOf(value);
    }

    @Override
    public String getStringValue() {        
        return String.valueOf(value);
    }

    @Override
    public String getStringPreviousValue() {
        return String.valueOf(previousValue);
    }
}
