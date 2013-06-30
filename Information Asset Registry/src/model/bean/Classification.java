package model.bean;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Collections;
import java.util.Vector;

import everything.DBUtil;

public class Classification {
    private static Vector<Classification> types;
    private String classification;
    private int assetFk;
    
    public static void main(String[] args) {
        Classification a = Classification.latest(1);
        a.update("Sensitive");
    }
    
    public String name() {
        return classification;
    }
    
    public String toString() {
        return name();
    }
    
    private Classification() {
    }
    
    public void update(String replacement) {
        if (classification.equals(replacement)) return;
        // early return
        
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(
                "INSERT INTO Classification (assetFk, classification) " +
                "VALUES (?, ?)"                
            );
            ps.setInt(1, assetFk);
            ps.setString(2, replacement);
            ps.executeUpdate();
            
            ps = conn.prepareStatement("SELECT LAST_INSERT_ID() AS fk");
            rs = ps.executeQuery();
            rs.next();
            int attributeFk = rs.getInt("fk");
                    
            Log.updateAttribute(assetFk, "Classification", attributeFk);
            classification = replacement;
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            DBUtil.close(ps);
            DBUtil.close(conn);
        }
        
    }
    
    protected static Classification latest(int assetFk) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Classification latest = null;
        try {
            ps = conn.prepareStatement(
                "SELECT classification " + 
                "FROM Classification " +
                "WHERE assetFK = (?) " +
                "ORDER BY pk desc " +
                "LIMIT 1; "
            ); 
            ps.setInt(1, assetFk);
            rs = ps.executeQuery();
            rs.next();
            
            latest = new Classification();
            latest.assetFk = assetFk;
            latest.classification = rs.getString("classification");
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            DBUtil.close(rs);
            DBUtil.close(ps);
            DBUtil.close(conn);
        }
            
        return latest;
    }
    

}
