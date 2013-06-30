package model.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import everything.DBUtil;

public class Availability extends IntAttribute {

    static {
        attribute = "Availability";
    }
    
    private Availability() {
    }
    
    @Override
    public void update(int replacement) {
        update(replacement);
    }

    protected static Availability latest(int assetFk) {
        ResultSet rs = null;
        Availability latest = null;
        try {
            rs = latestRS(assetFk);
            rs.next();
            
            latest = new Availability();
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
