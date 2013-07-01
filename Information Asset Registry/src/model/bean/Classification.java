package model.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import everything.DBUtil;

public class Classification extends StringAttribute {
    private static Vector<Classification> types;
    private static final String attribute = "Classification"; 
    
    protected Classification() {
    }
    
    protected String attribute() {
        return attribute;
    }
    
    
    public static void main(String[] args) {
        Classification a = new Classification();
        System.out.println(a.value);
    }
    
    @Override
    public void setValue(String value) {
        //TODO check if invalid value
        super.setValue(value);
    }
    
    protected static Classification latest(int assetFk) {
        ResultSet rs = null;
        Classification latest = null;
        try {
            rs = latestRS(assetFk, attribute);
            rs.next();
            
            latest = new Classification();
            latest.assetFk = assetFk;
            latest.value = rs.getString("value");
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
