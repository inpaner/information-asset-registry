package model.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import everything.DBUtil;

public class Owner extends StringAttribute {
    
    static {
        attribute = "Classification";
    }
    
    private Owner() {
    }
    
    protected static Owner latest(int assetFk) {
        ResultSet rs = null;
        Owner latest = null;
        try {
            rs = latestRS(assetFk);
            rs.next();
            
            latest = new Owner();
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
