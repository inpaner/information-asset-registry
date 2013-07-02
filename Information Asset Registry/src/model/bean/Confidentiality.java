package model.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import everything.DBUtil;

public class Confidentiality extends RateableAttribute {
    private static final String attribute = "Confidentiality"; 
    
    protected Confidentiality() {
    }
    
    @Override
    protected String attribute() {
        return attribute;
    }

    protected static Confidentiality latest(int assetFk) {
        ResultSet rs = null;
        Confidentiality latest = null;
        try {
            rs = latestRS(assetFk, attribute);
            rs.next();
            
            latest = new Confidentiality();
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
