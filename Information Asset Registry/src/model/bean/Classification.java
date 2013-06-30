package model.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import everything.DBUtil;

public class Classification extends StringAttribute {
    private static Vector<Classification> types;
    
    public static void main(String[] args) {
        Classification a = Classification.latest(1);
        System.out.println(a.value);
    }
    

    
    private Classification() {
    }
    
    public void update(String replacement) {
        if (value.equals(replacement)) 
            return;
        // early return
        
        genericUpdate("Classification", replacement);
    }
    
    protected static Classification latest(int assetFk) {
        ResultSet rs = null;
        Classification latest = null;
        try {
            rs = latestRS("Classification", assetFk);
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
