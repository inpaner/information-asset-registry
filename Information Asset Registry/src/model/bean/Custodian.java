package model.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import everything.DBUtil;

public class Custodian extends StringAttribute {
    
    static {
        attribute = "Custodian";
    }
    
    private Custodian() {
    }
    
    protected static Custodian latest(int assetFk) {
        ResultSet rs = null;
        Custodian latest = null;
        try {
            rs = latestRS(assetFk);
            rs.next();
            
            latest = new Custodian();
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
