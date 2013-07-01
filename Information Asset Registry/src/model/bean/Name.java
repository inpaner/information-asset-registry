package model.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import everything.DBUtil;

public class Name extends StringAttribute {
    private static final String attribute = "Name"; 
    
    protected Name() {
    }
    
    @Override
    protected String attribute() {
        return attribute;
    }
    
    protected static Name latest(int assetFk) {
        ResultSet rs = null;
        Name latest = null;
        try {
            rs = latestRS(assetFk, attribute);
            rs.next();
            
            latest = new Name();
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