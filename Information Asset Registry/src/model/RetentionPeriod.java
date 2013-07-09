package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import everything.DBUtil;

public class RetentionPeriod extends DateAttribute {
    private static final String attribute = "RetentionPeriod"; 
    
    protected RetentionPeriod() {
    }
    
    @Override
    protected String attribute() {
        return attribute;
    }

    protected static RetentionPeriod latest(int assetFk) {
        ResultSet rs = null;
        RetentionPeriod latest = null;
        try {
            rs = latestRS(assetFk, attribute);
            rs.next();
            
            latest = new RetentionPeriod();
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
