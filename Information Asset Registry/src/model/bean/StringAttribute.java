package model.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import everything.DBUtil;

public abstract class StringAttribute extends Attribute {
    protected String value;
    
    public abstract void update(String replacement);
    // protected static Classification latest(int assetFk);
        // Java doesn't do abstract static, but latest() 
        // is required by all attributes
    
    public String value() {
        return value;
    }
    
    public String toString() {
        return value;
    }
    
    protected void genericUpdate(String attribute, String replacement) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String update = 
                "INSERT INTO " + attribute + " + (assetFk, value) " +
                "VALUES (?, ?)";
            ps = conn.prepareStatement(update);                
            ps.setInt(1, assetFk);
            ps.setString(2, replacement);
            ps.executeUpdate();
            
            ps = conn.prepareStatement("SELECT LAST_INSERT_ID() AS fk");
            rs = ps.executeQuery();
            rs.next();
            int attributeFk = rs.getInt("fk");
                    
            Log.updateAttribute(assetFk, attribute, attributeFk);
            value = replacement;
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            DBUtil.close(ps);
            DBUtil.close(conn);
        }   
    }
}
