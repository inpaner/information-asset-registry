package model.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import everything.DBUtil;

public class Integrity extends IntAttribute {

    static {
        attribute = "Integrity";
    }
    
    private Integrity() {
    }
    
    @Override
    public void update(int replacement) {
        update(replacement);
    }

    protected static Integrity latest(int assetFk) {
        ResultSet rs = null;
        Integrity latest = null;
        try {
            rs = latestRS(assetFk);
            rs.next();
            
            latest = new Integrity();
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
