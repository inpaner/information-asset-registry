package model.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import everything.DBUtil;

public class Classification extends StringAttribute {
    private static Vector<Classification> types;
    
    static {
        attribute = "Classification";
    }
    
    private Classification() {
    }

    public static void main(String[] args) {
        Classification a = Classification.latest(1);
        a.update("Confidential");
        System.out.println(a.value);
    }
    
    protected static Classification latest(int assetFk) {
        ResultSet rs = null;
        Classification latest = null;
        try {
            rs = latestRS(assetFk);
            rs.next();
            
            latest = new Classification();
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
