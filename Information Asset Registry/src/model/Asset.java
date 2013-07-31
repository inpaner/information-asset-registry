package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Vector;

import model.db.DBUtil;
import model.sql.SQLQuery;


/////
// REMNANT!
// Will be replaced by Core
// Temporarily retained to retrieve methods later

public class Asset {
    private static HashMap<Integer, Asset> cache;
    
    private int pk;
   
    static {
        cache = new HashMap<>();
    }
    
    public void add() throws RegException {
        if (pk != 0) {
            String message = "Asset already added.";
            throw new RegException(message);
        }
        
        Connection conn = DBUtil.newConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(
                "INSERT INTO Asset () " +
                "VALUES ()");             
            
            ps.executeUpdate();
           
            ps = conn.prepareStatement("SELECT `pk` FROM `Asset` ORDER BY `pk` DESC LIMIT 1");
            rs = ps.executeQuery();
            rs.next();
            pk = rs.getInt("pk");
            
            name.add(pk);
            identifier.add(pk);
            owner.add(pk);
            custodian.add(pk);
            type.add(pk);
            dateAcquired.add(pk);
            retentionPeriod.add(pk);
            financial.add(pk);
            confidentiality.add(pk);
            integrity.add(pk);
            availability.add(pk);
            classification.add(pk);
            storage.add(pk);
            
            // TODO Log.add();
            
            cache.put(pk, this);
            DBUtil.commit(conn);
            Log.addAsset(pk);
        }
        catch (RegException e) {
            DBUtil.rollback(conn);
            throw e;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.close(ps);
            DBUtil.setAutoCommit(conn, true);
        }
    }
    
    public void update() throws RegException {
        Connection conn = DBUtil.newConnection();
        PreparedStatement ps = null;
        try {
            conn.setAutoCommit(false);
            
            name.update();
            identifier.update();
            owner.update();
            custodian.update();
            type.update();
            dateAcquired.update();
            retentionPeriod.update();
            financial.update();
            confidentiality.update();
            integrity.update();
            availability.update();
            classification.update();
            storage.update();
            
            integrity.update();
            // TODO Log.update();
            
            cache.put(pk, this);
            DBUtil.commit(conn);
        }
        catch (AssertionError e) {
            DBUtil.rollback(conn);
            String message = e.toString() + " not set.";
            throw new RegException(message);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.setAutoCommit(conn, true);
            DBUtil.close(ps);
            DBUtil.close(conn);
        }
    }
    
    public int pk() {
        return pk;
    }

    public static Vector<Asset> getAll() {
        Vector<Asset> allAssets = new Vector<>();
        Connection conn = DBUtil.newConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(
                "SELECT pk " +
                "FROM Asset "
            ); 
            rs = ps.executeQuery();
            while (rs.next()) {
                int pk = rs.getInt("pk");
                allAssets.add(get(pk));
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            DBUtil.close(rs);
            DBUtil.close(ps);
            DBUtil.close(conn);
        }

        return allAssets;
    }
    
    public static Asset get(int pk) {
        Asset toGet = cache.get(pk);
        if (toGet == null) {
            toGet = new Asset();
            toGet.getFromDB(pk);
        }
        return toGet;
    }
    
    private void getFromDB(int pk) {
        Connection conn = DBUtil.newConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            SQLQuery query = new SQLQuery();
            query.addProjection("pk");
            query.addProjection("name");
            query.addProjection("identifier");
            query.addProjection("ownerFk");
            query.addProjection("custodianFk");
            query.addProjection("dateAcquired");
            query.addProjection("retentionPeriod");
            query.addProjection("maintenanceSchedule");
            query.addProjection("typeFk");
            query.addProjection("storage");
            query.addProjection("financialFk");
            query.addProjection("confidentialityFk");
            query.addProjection("integrityFk");
            query.addProjection("availabilityFk");
            
            query.addTable("Asset");
            query.addCondition("pk = (?)");
            
            
            ps = conn.prepareStatement(query.toString()); 
            ps.setInt(1, pk);
            rs = ps.executeQuery();
            if (rs.next()) {
                this.pk = pk;
                
                name = new Name(pk, rs.getString("name"));
                identifier = Identifier.latest(pk);
                owner = Owner.latest(pk);
                custodian = Custodian.latest(pk);
                dateAcquired = DateAcquired.latest(pk);
                type = Type.latest(pk);
                retentionPeriod = RetentionPeriod.latest(pk);
                financial = Financial.latest(pk);
                confidentiality = Confidentiality.latest(pk);
                integrity = Integrity.latest(pk);
                availability = Availability.latest(pk);
                classification = Classification.latest(pk);
                storage = Storage.latest(pk);
            }
            
            cache.put(pk, this);
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            DBUtil.close(rs);
            DBUtil.close(ps);
            DBUtil.close(conn);
        }
    }
}
