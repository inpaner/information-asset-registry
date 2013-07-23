package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Vector;

import everything.DBUtil;

public class Type extends StringAttribute {
    private static Vector<String> validValues = new Vector<String>();
    private static final String attribute = "Type"; 
    
    protected Type() {
    }
    
    static {
        queryValids();
    }
    
    private static void queryValids() {
        Connection conn = DBUtil.newConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(
                "SELECT value " +
                "FROM TypeList "
            ); 
            rs = ps.executeQuery();
            while (rs.next()) {
                validValues.add(rs.getString("value"));
            }
            Collections.sort(validValues);
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            DBUtil.close(ps);
            DBUtil.close(conn);
        }
    }
    
    public static Vector<String> validValues() {
        return validValues;
    }
    
    protected String getValue() {
        return attribute;
    }
    
    @Override
    public void setValue(String value) {
        //TODO check if invalid value
        super.setValue(value);
    }
    
    protected static Type latest(int assetFk) {
        ResultSet rs = null;
        Type latest = null;
        try {
            rs = latestRS(assetFk, attribute);
            rs.next();
            
            latest = new Type();
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
