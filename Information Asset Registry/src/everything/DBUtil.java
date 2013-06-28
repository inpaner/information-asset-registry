package everything;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;


public class DBUtil {
    private static String dbUrl;
    private static String dbName;
    private static String dbDriver;
    private static String username;
    private static String password;
    private static Connection conn;
    
    static {
        setup();
    }
    

    private static void setup() {
        ResourceBundle rb = ResourceBundle.getBundle("everything.db");
        dbUrl = rb.getString("dbUrl");
        dbName = rb.getString("dbName");
        dbDriver = rb.getString("dbDriver");
        username = rb.getString("username");
        password = rb.getString("password ");
    }
    
    
    protected static Connection getConnection() {            
        try {
            Class.forName(dbDriver).newInstance();
            conn = DriverManager.getConnection(dbUrl+dbName,username,password);
            //conn.setSavepoint();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return conn;
    }

    protected void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void close(Statement st) {
        try {
            if (st != null)
                st.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void close(PreparedStatement st) {
        try {
            if (st != null)
                st.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    protected void close(ResultSet rs) {
        try {
            if (rs != null)
                rs.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void commit(Connection connection) {
        try {
            if (connection != null) 
                connection.commit();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    protected void rollback(Connection connection) {
        try {
            if (connection != null)   
                connection.rollback();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}