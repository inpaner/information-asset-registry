package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import model.attribute.Attribute;
import model.attribute.AttributeUtil;
import model.attribute.StringAttribute;
import model.db.DBUtil;
import model.sql.Login;
import model.sql.SQLBuilder;

// wrapper class for user Core
public class User {
    private static HashMap<Integer, User> cache;
    
    static {
        cache = new HashMap<>();
    }
    
    private Core user;
    private StringAttribute username;
    private StringAttribute password;
    private boolean loggedIn;
    
    public User() {
        logOut();
    }
    
    private User(int pk) {
        logOut();
    }
    
    public static User getUser(int pk) {
        User toGet = cache.get(pk);
        if (toGet == null) {
            toGet = new User(pk);
            cache.put(pk, toGet);
        }
        return toGet;
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
        if (username.getValue().isEmpty())
            throw new RegException("Username not filled");
        if (password.getValue().isEmpty())
            throw new RegException("Password not filled");
        SQLBuilder builder = new Login(this);
        ResultSet rs = DBUtil.executeQuery(builder.getResult());
        try {
            if (rs.next()) {
                loggedIn = true;
                user = CoreUtil.getCore("user", rs.getInt("pk"));
                DBUtil.finishQuery();
            }
            
            else {
                String query = 
                    "SELECT COUNT(*) " +
                    "FROM `user` " +
                    "WHERE `username` = '" + username.getStringValue() +"'";
                rs = DBUtil.executeQuery(query);
                if (rs.next()){
                    if (rs.getInt(1) > 0){
                        throw new RegException("Invalid password");
                    }else{
                    	throw new RegException("Unregistered username");
                    }
                }
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

	public void logOut() {
        user = CoreUtil.getAddable("user");
        for (Attribute attribute : user.getAttributes()) {
            if (attribute.getName().equals("username"))
                username = (StringAttribute) attribute;
            else if (attribute.getName().equals("password"))
                password = (StringAttribute) attribute;
        }
        loggedIn = false;
	}    
}

