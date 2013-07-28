package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Vector;

import schemacrawler.schema.Column;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import everything.DBUtil;

public class IntegerAttribute extends Attribute {
    // TODO change to 
    protected int value = 0;
    protected int replacement = 0;
    
    private IntegerAttribute() {
        
    }
    
    IntegerAttribute(Column column) {
        name = column.getName();
    }
    
    public int value() {
        return value;
    }
    
    public String toString() {
        return String.valueOf(value);
    }

    public void setValue(int value) {
        replacement = value;
        if (isNew)
            this.value = value;
    }
    
    private void insert(int assetFk) throws RegException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection conn = DBUtil.getConnection();
            System.out.println("here");
            String update = 
                "INSERT INTO " + getValue() + " (assetFk, value) " +
                "VALUES (?, ?)";
            ps = conn.prepareStatement(update);                
            ps.setInt(1, assetFk);
            ps.setInt(2, replacement);
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
        if (value == 0) {
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
        
        if (value == replacement) 
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
        return String.valueOf(value);
    }

    @Override
    protected Attribute clone() {
        IntegerAttribute clone = new IntegerAttribute();
        clone.value = value;
        clone.replacement = replacement;
        return clone;
    }
}
