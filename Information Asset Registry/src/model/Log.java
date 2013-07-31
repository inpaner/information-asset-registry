package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import model.attribute.Attribute;
import model.db.DBUtil;
import model.sql.AddCoreLog;
import model.sql.EditAttributeLog;
import model.sql.GetAllLogs;
import model.sql.SQLBuilder;
import model.sql.UserLogged;

public class Log implements Comparable<Log> {
    
    private User user;
    private Timestamp timestamp;
    private String action;
    private Core core; 
    private String attribute;
    private String previous;
    private String value;
    
    public static void main(String[] args) {
        for (Log l : Log.getAll()) {
            System.out.println(l.plaintext());
        }
    }
    
    private Log() {
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

    public String attribute() {
        return attribute;
    }
    
    public String previous() {
        return previous;
    }
    
    public String value() {
        return value;
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
                            core.getUniqueString() + " " + attribute + 
                            " from " + previous + " to " + value + ".";
                            break;
            default : text = "Unknown action.";
        }
        return text;
    }
    
    public static ArrayList<Log> getAll() {
        //TODO use a log cache
        SQLBuilder builder = new GetAllLogs();
        ResultSet rs = DBUtil.executeQuery(builder.getResult());
        ArrayList<Log> allLogs = new ArrayList<>();
        try {
            while (rs.next()) {
                Log log = new Log();
                log.user = User.getUser(rs.getInt("pk"));
                log.action = rs.getString("action");
                
                try {
                    String coreName = rs.getString("core");
                    int corePk = rs.getInt("coreFk");
                    log.core = CoreUtil.getCore(coreName, corePk);
                    log.attribute = rs.getString("attribute");
                    log.previous = rs.getString("previous");
                    log.value = rs.getString("value");
                    allLogs.add(log);
                }
                catch (NullPointerException ex) {
                    ex.printStackTrace();
                }
                
            }
        }
        catch (SQLException ex) {
            
        }
        finally {
            DBUtil.finishQuery();
        }
        return allLogs;
        
    }
    
    public static void addCore(Core core) {
        SQLBuilder builder = new AddCoreLog(core);
        DBUtil.executeUpdate(builder.getResult());
    }
    
    public static void editCore(Core core) {
        // Uses a single timestamp for all logs
        Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
        String dateTime = timeStamp.toString();
        
        for (Attribute attribute : core.getAttributes()) {
            if (attribute.isUpdated()) {
                SQLBuilder builder = new EditAttributeLog(core, attribute, dateTime);
                DBUtil.executeUpdate(builder.getResult());
            }
        }
    }
    
    private static void userLogged(Action action) {
        SQLBuilder builder = new UserLogged(action);
        DBUtil.executeUpdate(builder.getResult());
    }
    
    public static void loggedIn() {
        userLogged(Action.LOGIN);
    }
    
    public static void loggedOut() {
        userLogged(Action.LOGOUT);
    }
    
    @Override
    public int compareTo(Log other) {
        int comparison = this.timestamp.compareTo(other.timestamp);
        return comparison;
    }
}
