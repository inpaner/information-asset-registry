package model.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import everything.DBUtil;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public abstract class StringAttribute extends Attribute {
    protected String value;
    protected String replacement;
    
    // protected static Classification latest(int assetFk);
        // Java doesn't do abstract static, but latest() 
        // is required by all attributes
    
    
    public String value() {
        return value;
    }
    
    public void setValue(String value) {
        replacement = value;
        if (isNew) {
            this.value = value;
        }
    }

    private void insert(int assetFk) throws RegException {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String update = 
                "INSERT INTO " + attribute() + " (assetFk, value) " +
                "VALUES (?, ?)";
            ps = conn.prepareStatement(update);                
            ps.setInt(1, assetFk);
            ps.setString(2, value);
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
            DBUtil.close(conn);
        }   
    }

    protected void add(int assetFk) throws RegException {
        if (!isNew) {
            String message = "Value for " + attribute() + " already exists.";
            throw new RegException(message);            
        }
        if (value == null) {
            String message = "Value for " + attribute() + " not set.";
            throw new RegException(message);            
        }
        insert(assetFk);
    }
    
    protected void update() throws RegException {
        if (isNew) {
            String message = "Value for " + attribute() + " does not yet exist.";
            throw new RegException(message);   
        }
        
        if (value.equals(replacement)) 
            return;
        // early return
        
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            insert(assetFk);

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
            DBUtil.close(conn);
        }   
    }

    public String toString() {
        return value;
    }
}
