package everything;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Collections;
import java.util.Vector;

public class Classification {
    private static Vector<Classification> types;
    private String name;
    
    private Classification(String name) {
        this.name = name;
    }
    
    public void update(String name) {
        
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
            
            latest = new Classification(rs.getString("classification"));
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
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
