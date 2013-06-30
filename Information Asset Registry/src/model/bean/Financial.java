package model.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import everything.DBUtil;

public class Financial extends IntAttribute {

    private Financial() {
    }
    
    @Override
    public void update(int replacement) {
        update(replacement);
    }

    protected static Financial latest(int assetFk) {
        ResultSet rs = null;
        Financial latest = null;
        try {
            rs = latestRS(assetFk);
            rs.next();
            
            latest = new Financial();
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
