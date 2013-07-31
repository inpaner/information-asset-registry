<<<<<<< HEAD
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.attribute.AttributeUtil;
import model.attribute.StringAttribute;
import model.db.DBUtil;



public class User {
    private int pk;
    private StringAttribute username;
    private StringAttribute password;
    private boolean loggedIn;
    
    public User() {
        pk = -1;
        username = AttributeUtil.genericAttribute();
        password = AttributeUtil.genericAttribute();
        loggedIn = false;
    }
    
    public int pk() {
        return pk;
    }
    
    public StringAttribute getUsername() {
        return username;
    }
    
    public StringAttribute getPassword() {
        return password;
    }
        
    public void login() throws RegException {
        Connection conn = DBUtil.newConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            StringBuilder query = new StringBuilder(
                "SELECT pk " +
                "FROM user " +
                "WHERE username = ? AND password = '"
            );
            ps = conn.prepareStatement(query.toString()); 
            ps.setString(1, username.getSQLValue());
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                pk = rs.getInt("pk");
                loggedIn = true;
            }
            else {
            	PreparedStatement ps2 = conn.prepareStatement(
            	        "SELECT COUNT(*) " +
            	        "FROM user " +
            	        "WHERE username = ?");
            	ps2.setString(1, username.getValue());
            	ResultSet rs2 = ps2.executeQuery();
            	if (rs2.next()){
            		if (rs2.getInt(1) == 0)
            			throw new RegException("Unregistered username.");
            	}
                throw new RegException("Invalid password.");
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
    }    
    
}
=======
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.attribute.Attribute;
import model.attribute.AttributeUtil;
import model.attribute.StringAttribute;
import model.db.DBUtil;

// wrapper class for user Core
public class User {
    private static ArrayList<User> cache;
    
    static {
        cache = new ArrayList<>();
    }
    
    private Core user;
    private StringAttribute username;
    private StringAttribute password;
    private boolean loggedIn;
    
    public User() {
        user = CoreUtil.getAddable("user");
        for (Attribute attribute : user.getAttributes()) {
            if (attribute.getName().equals("username"))
                username = (StringAttribute) attribute;
            else if (attribute.getName().equals("password"))
                password = (StringAttribute) attribute;
        }
        loggedIn = false;
    }
    
    public int getPk() {
        return user.getPk();
    }
    
    public StringAttribute getUsername() {
        return username;
    }
    
    public StringAttribute getPassword() {
        return password;
    }
        
    public void login() throws RegException {
        Connection conn = DBUtil.newConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            StringBuilder query = new StringBuilder(
                "SELECT pk " +
                "FROM user " +
                "WHERE username = ? AND password = ?'"
            );
            ps = conn.prepareStatement(query.toString()); 
            ps.setString(1, username.getSQLValue());
            ps.setString(1, password.getSQLValue());
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                loggedIn = true;
            }
            
            else {
            	PreparedStatement ps2 = conn.prepareStatement(
            	        "SELECT COUNT(*) " +
            	        "FROM user " +
            	        "WHERE username = ?");
            	ps2.setString(1, username.getValue());
            	ResultSet rs2 = ps2.executeQuery();
            	if (rs2.next()){
            		if (rs2.getInt(1) == 0)
            			throw new RegException("Unregistered username.");
            	}
                throw new RegException("Invalid password.");
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
    }    
    
}
>>>>>>> branch 'master' of https://github.com/inpaner/information-asset-registry.git
