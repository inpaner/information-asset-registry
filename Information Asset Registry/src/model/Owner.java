package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import everything.DBUtil;

public class Owner extends StringAttribute {
    private static final String attribute = "Owner"; 
    
    protected Owner() {
    }
    

    protected void add(int assetFk) throws RegException {
        super.add(assetFk);
    }
    
    
    protected static Owner latest(int assetFk) {
        ResultSet rs = null;
        Owner latest = null;
        try {
            rs = latestRS(assetFk, attribute);
            if (rs.next()){
                latest = new Owner();
                latest.assetFk = assetFk;
                latest.value = rs.getString("value");
                latest.isNew = false;
            }else
            	throw new SQLException("There weren't any owners found for asset (" + assetFk + "). That's weird.");
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            DBUtil.close(rs);
        }
            
        return latest;
    }


    @Override
    protected String getValue() {
        return attribute;
    }
    

}
