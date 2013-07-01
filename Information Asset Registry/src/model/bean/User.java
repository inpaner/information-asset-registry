package model.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import everything.DBUtil;

public class User {
    private int pk;
    private String username;
    private static User currentUser;
    
    public static User currentUser() {
        return currentUser;
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
