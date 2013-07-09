package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import everything.DBUtil;

public class DateAcquired extends DateAttribute {
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
            latest.value = rs.getDate("value");
            latest.isNew = false;
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
