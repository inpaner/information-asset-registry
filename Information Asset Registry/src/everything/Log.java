package everything;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Collections;
import java.util.Vector;

public class Log implements Comparable<Log> {
    private User user;
    private Date date;
    private Time time;
    private String asset; // questionable
    private String action;
    private String attribute;
    
    public static void main(String[] args) {
        Log.allLogs(1);
    }
    
    public Log() {
    }
    
    public Time time() {
        return time;
    }
    
    public void setTime(Time time) {
        this.time = time;
    }
    
    public Date date() {
        return date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    public void setAction(String action) {
        this.action = action;
    }
    
    public static Vector<Log> allLogs(int user) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        Vector<Log> allLogs = new Vector<>();
        try {
            // Get from Logs
            ps = conn.prepareStatement(
                "SELECT date(dateTime) AS date, time(dateTime) AS time, " + 
                "    action, attribute, identifier, attributeFk " +
                "FROM Log " +
                "    LEFT JOIN Asset ON assetFk = Asset.pk " +
                "WHERE userFk = (?) " 
            );
            ps.setInt(1, user);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Log currentLog = new Log();
                Time time = rs.getTime("time");
                Date date = rs.getDate("date");
                
                currentLog.setTime(time);
                currentLog.setDate(date);
                currentLog.setAction(rs.getString("action"));
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
        for (Log log : allLogs) {
            System.out.println(log.action);
        }
        return allLogs;
    }

    @Override
    public int compareTo(Log other) {
        int comparison = this.date.compareTo(other.date);
        if (comparison == 0)
            comparison = this.time.compareTo(other.time);
        return comparison;
    }
}
