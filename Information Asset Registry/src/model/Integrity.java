package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import everything.DBUtil;

public class Integrity extends IntegerAttribute {
    private static final String attribute = "Integrity"; 
    
    protected Integrity() {
    }

    @Override
    protected String getValue() {
        return attribute;
    }

    protected static Integrity latest(int assetFk) {
        ResultSet rs = null;
        Integrity latest = null;
        try {
            rs = latestRS(assetFk, attribute);
            rs.next();
            
            latest = new Integrity();
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
