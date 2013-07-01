package model.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import everything.DBUtil;

public abstract class IntAttribute extends Attribute {
    protected int value = 0;
    protected int replacement;
    
    // protected static <Attribute> latest(int assetFk);
        // Java doesn't do abstract static, but latest() 
        // is required by all attributes
 
    public int value() {
        return value;
    }
    
    public String toString() {
        return String.valueOf(value);
    }

    public void setValue(int value) {
        replacement = value;
        if (isNew) {
            this.value = value;
        }
    }
    
    private void insert(int assetFk) throws RegException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection conn = DBUtil.getConnection();
            System.out.println("here");
            String update = 
                "INSERT INTO " + attribute() + " (assetFk, value) " +
                "VALUES (?, ?)";
            ps = conn.prepareStatement(update);                
            ps.setInt(1, assetFk);
            ps.setInt(2, value);
            ps.executeUpdate();
            
            isNew = false;
            this.assetFk = assetFk;
        }
        catch (MySQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
            String message = "Invalid value for " + attribute() + ".";
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
            String message = attribute() + " already exists.";
            throw new RegException(message);            
        }
        if (value == 0) {
            String message = attribute() + " not set.";
            throw new RegException(message);            
        }
        insert(assetFk);
    }
    
    protected void update() throws RegException {
        if (isNew) {
            String message = attribute() + " does not yet exist.";
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
            Log.updateAttribute(assetFk, attribute(), attributeFk);
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            DBUtil.close(rs);
            DBUtil.close(ps);
        }   
    }
}