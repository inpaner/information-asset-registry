package model.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import everything.DBUtil;

public class Storage extends StringAttribute {
    private static final String attribute = "Storage"; 
    
    protected Storage() {
    }

    @Override
    protected String attribute() {
        return attribute;
    }
    
    protected static Storage latest(int assetFk) {
        ResultSet rs = null;
        Storage latest = null;
        try {
            rs = latestRS(assetFk, attribute);
            rs.next();
            
            latest = new Storage();
            latest.assetFk = assetFk;
            latest.value = rs.getString("value");
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
