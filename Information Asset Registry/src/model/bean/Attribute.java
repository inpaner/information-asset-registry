package model.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import everything.DBUtil;

public abstract class Attribute {
    protected int assetFk;
    
    // protected static Classification latest(int assetFk);
        // Java doesn't do abstract static, but latest() 
        // is required by all attributes
        
    protected static ResultSet latestRS(String attribute, int assetFk) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = 
                "SELECT value " +
                "FROM " + attribute + " " + 
                "WHERE assetFK = ? " +
                "ORDER BY pk desc " +
                "LIMIT 1; ";
            
            ps = conn.prepareStatement(query);
            ps.setInt(1, assetFk);
            rs = ps.executeQuery();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
        }
            
        return rs;
    }
}
