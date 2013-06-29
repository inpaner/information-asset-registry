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
        System.out.println(a.classification);
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
        try {
            ps = conn.prepareStatement(
                "INSERT INTO Classification (assetFk, replacement) " +
                "VALUES (?, ?)"                
            );
            ps.setInt(1, assetFk);
            ps.setString(1, replacement);
            
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
    
    // temporary thing. don't copy
    public static Vector<Log> allLogs(User user) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        Vector<Log> allLogs = new Vector<>();
        try {
            ps = conn.prepareStatement(
                "SELECT date(dateTime) AS date, identifier, " +
                "    time(dateTime) AS time, classification " +
                "FROM Log " +
                "    JOIN Asset ON assetFk = Asset.pk " +
                "    JOIN Classification ON attributeFk = Classification.pk " +
                "WHERE userFk = 1 AND attribute = 'Classification' "
            );
            ps.setInt(1, user.pk());
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Log currentLog = new Log();
                Time time = rs.getTime("time");
                currentLog.setTime(time);
                Date date = rs.getDate("date");
                currentLog.setDate(date);
                currentLog.setAction("UPDATED");
                allLogs.add(currentLog);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.close(rs);
            DBUtil.close(ps);
            DBUtil.close(conn);
        }
        
        Collections.sort(allLogs);
        return allLogs;
    }
}
