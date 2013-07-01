package model.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import everything.DBUtil;

public class DateAcquired extends DateTimeAttribute {
    private static final String attribute = "DateAcquired"; 
    
    protected DateAcquired() {
    }
    
    @Override
    protected String attribute() {
        return attribute;
    }

    protected static DateAcquired latest(int assetFk) {
        ResultSet rs = null;
        DateAcquired latest = null;
        try {
            rs = latestRS(assetFk, attribute);
            rs.next();
            
            latest = new DateAcquired();
            latest.assetFk = assetFk;
            latest.value = rs.getTimestamp("value");
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            DBUtil.close(rs);
        }
            
        return latest;
    }
    

}