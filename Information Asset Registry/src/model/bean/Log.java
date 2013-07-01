package model.bean;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Collections;
import java.util.Vector;
import java.sql.Timestamp;


import everything.DBUtil;

public class Log implements Comparable<Log> {
    private User user;
    private Timestamp timestamp;
    private String action;
    private Asset asset; 
    private String attribute;
    private int attributeFk;
    
    public static void main(String[] args) {
        Log.updateAttribute(1, "Classification", 4);
    }
    
    public Log() {
    }

    public static Vector<Log> getAll(int user) {
        Connection conn = DBUtil.newConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        Vector<Log> allLogs = new Vector<>();
        try {
            // Get from Logs
            ps = conn.prepareStatement(
                "SELECT userFk, dateTime, action, " +
                "   assetFk, attribute, attributeFk " +
                "FROM Log "
            );
            ps.setInt(1, user);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Log currentLog = new Log();
                Time time = rs.getTime("time");
                Date date = rs.getDate("date");
                
                currentLog.user = User.get(rs.getInt("userFk"));
                currentLog.timestamp = rs.getTimestamp("dateTime");
                currentLog.action = rs.getString("action");
                currentLog.asset = Asset.get(rs.getInt("assetFk"));
                currentLog.attribute = rs.getString("attribute");
                currentLog.attributeFk = rs.getInt("attributeFk");
                
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
    
    public static void updateAttribute(int assetFk, String attribute, int attributeFk) {       
        PreparedStatement ps = null;
        try {
            Connection conn = DBUtil.getConnection();
            ps = conn.prepareStatement(
                "INSERT INTO Log (userFk, action, dateTime, " +
                "                 assetFk, attribute, attributeFk) " +
                "VALUES (?, ?, ?, ?, ?, ?)"                
            );
            ps.setInt(1, User.currentUser().pk());
            ps.setString(2, "Edit");
            ps.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            ps.setInt(4, assetFk);
            ps.setString(5, attribute);
            ps.setInt(6, attributeFk);
            ps.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            DBUtil.close(ps);
        }
    }

    public static void addAsset(int assetFk) {       
        PreparedStatement ps = null;
        try {
            Connection conn = DBUtil.getConnection();
            ps = conn.prepareStatement(
                "INSERT INTO Log (userFk, action, dateTime, assetFk) " +
                "VALUES (?, ?, ?, ?)"                
            );
            ps.setInt(1, User.currentUser().pk());
            ps.setString(2, "Add");
            ps.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            ps.setInt(4, assetFk);
            ps.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            DBUtil.close(ps);
        }
    }
    
    private static void userLogged(String action) {
        Connection conn = DBUtil.newConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(
                "INSERT INTO Log (userFk, action, dateTime) " +
                "VALUES (?, ?, ?)"                
            );
            ps.setInt(1, User.currentUser().pk());
            ps.setString(2, action);
            ps.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            ps.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            DBUtil.close(ps);
            DBUtil.close(conn);
        }
    }
    
    public static void loggedIn() {
        userLogged("Login");
    }
    
    public static void loggedOut() {
        userLogged("Logout");
    }
    
    @Override
    public int compareTo(Log other) {
        int comparison = this.timestamp.compareTo(other.timestamp);
        return comparison;
    }
}
