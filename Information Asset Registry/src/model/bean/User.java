package model.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import everything.DBUtil;

public class User {
    private static HashMap<Integer, User> cache;
    
    private int pk;
    private String username;
    private static User currentUser;
    
    static {
        cache = new HashMap<>();
    }
    
    public static User currentUser() {
        return currentUser;
    }
    
    public static User get(int pk) {
        User toGet = cache.get(pk);
        if (toGet == null) {
            toGet = new User();
            toGet.getFromDB(pk);
        }
    
        return toGet;
    }
    
    private void getFromDB(int pk) {
        Connection conn = DBUtil.newConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(
                "SELECT username " +
                "FROM User " +
                "WHERE pk = (?) "
            ); 
            ps.setInt(1, pk);
            rs = ps.executeQuery();
            rs.next();
            
            this.pk = pk;
            username = rs.getString("username");
            
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
    
    private User() {
    }
    
    private User(int pk, String username) {
        this.pk = pk;
        this.username = username;
    }

    public int pk() {
        return pk;
    }
    
    public String username() {
        return username;
    }
    
    public static User login(String username, char[] password) throws RegException {
        Connection conn = DBUtil.newConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try {
            StringBuilder query = new StringBuilder(
                "SELECT pk " +
                "FROM user " +
                "WHERE username = ? AND password = '"
            );
            
            // appends password by character then zeroes it out
            for (int i = 0; i < password.length; i++) {
                query.append(password[i]);
                password[i] = 0;
            }
            query.append("';");
            
            ps = conn.prepareStatement(query.toString()); 
            ps.setString(1, username);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                int pk = rs.getInt("pk");
                user = new User(pk, username);
                currentUser = user;
            }
            else {
                throw new RegException("Invalid login.");
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            DBUtil.close(rs);
            DBUtil.close(ps);
            DBUtil.close(conn);
        }
            
        return user;
    }    
    
}
