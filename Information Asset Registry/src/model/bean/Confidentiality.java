package model.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import everything.DBUtil;

public class Confidentiality extends IntAttribute {
    
    static {
        attribute = "Confidentiality";
    }
        
    private Confidentiality() {
    }
    

    protected static Confidentiality latest(int assetFk) {
        ResultSet rs = null;
        Confidentiality latest = null;
        try {
            rs = latestRS(assetFk);
            rs.next();
            
            latest = new Confidentiality();
            latest.assetFk = assetFk;
            latest.value = rs.getInt("value");
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
