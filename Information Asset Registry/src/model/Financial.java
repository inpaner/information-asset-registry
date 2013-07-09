package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import everything.DBUtil;

public class Financial extends RateableAttribute {
    private static final String attribute = "Financial"; 
    
    protected Financial() {
    }

    @Override
    protected String attribute() {
        return attribute;
    }
   
    protected static Financial latest(int assetFk) {
        ResultSet rs = null;
        Financial latest = null;
        try {
            rs = latestRS(assetFk, attribute);
            rs.next();
            
            latest = new Financial();
            latest.assetFk = assetFk;
            latest.value = rs.getInt("value");
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
