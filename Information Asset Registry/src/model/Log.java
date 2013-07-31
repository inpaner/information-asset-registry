package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Vector;
import java.sql.Timestamp;

import model.attribute.Attribute;
import model.db.DBUtil;
import model.sql.SQLBuilder;
import model.sql.SQLQuery;



public class Log implements Comparable<Log> {
    private User user;
    private Timestamp timestamp;
    private String action;
    private Core core; 
    private Attribute attribute;
    private String previous;
    private String current;
    
    public static void main(String[] args) {
        for (Log l : Log.getAll()) {
            System.out.println(l.plaintext());
        }
    }
    
    public Log() {
    }    
    
    public User user() {
        return user;
    }

    public Timestamp timestamp() {
        return timestamp;
    }

    public String action() {
        return action;
    }

    public Core core() {
        return core;
    }

    public Attribute attribute() {
        return attribute;
    }
    
    public String previous() {
        return previous;
    }
    
    public String current() {
        return current;
    }
    
    public String plaintext() {
        String text = user.getUsername() + " - " + timestamp.toString() + " - ";
        switch (action) {
            case "Login" :  text += " logged in.";
                            break;
            case "Logout" : text += " logged out.";
                            break;
                            
            case "Add" :    text += user + " added " + core.getName() + " " + 
                            core.getUniqueString() + ".";
                            break;
            case "Edit" :   text += user + " edited " + core.getName() + " " + 
                            attribute +" from " + previous + " to " + current +
                            ".";
                            break;
            default : text = "Unknown action.";
        }
        
        return text;
    }
    
    public static Vector<Log> getAll() {
        String statement = SQLBuilder.getAllLogsStatement();
        
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
