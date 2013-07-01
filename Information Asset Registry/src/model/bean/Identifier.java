package model.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import everything.DBUtil;

public class Identifier extends StringAttribute {
    private static final String attribute = "Identifier"; 
    
    protected Identifier() {
    }
    
    @Override
    protected String attribute() {
        return attribute;
    }
    
    // Force setting unique. Maybe a cache.
    
    protected static Identifier latest(int assetFk) {
        ResultSet rs = null;
        Identifier latest = null;
        try {
            rs = latestRS(assetFk, attribute);
            rs.next();
            
            latest = new Identifier();
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
