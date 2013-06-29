package everything;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class Asset {
    private static HashMap<Integer, Asset> cache;
    
    private int pk;
    private String name;
    private String identifier;
    private Date dateAcquired;
    private Date retentionPeriod;
    private Classification classification;
    
    static {
        cache = new HashMap<>();
    }
    
    public static void main(String[] args) {
        Asset a = Asset.get(1);
        System.out.println(a.name);
        Asset b = Asset.get(1);
        System.out.println(b.name);
    }
    
    protected int pk() {
        return pk;
    }

    private void setPk(int pk) {
        this.pk = pk;
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String identifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Date dateAcquired() {
        return dateAcquired;
    }

    public void setDateAcquired(Date dateAcquired) {
        this.dateAcquired = dateAcquired;
    }

    public Date retentionPeriod() {
        return retentionPeriod;
    }

    public void setRetentionPeriod(Date retentionPeriod) {
        this.retentionPeriod = retentionPeriod;
    }

    public Classification classification() {
        return classification;
    }

    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    public static Asset get(int pk) {
        Asset toGet = cache.get(pk);
        if (toGet == null) {
            System.out.println("here");
            
            toGet = getFromDB(pk);
        }
        return toGet;
    }
    
    private static Asset getFromDB(int pk) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Asset toGet = new Asset();
        try {
            ps = conn.prepareStatement(
                "SELECT pk, identifier, name, type" +
                "       dateAcquired, retentionPeriod " + 
                "FROM Asset " +
                "WHERE pk = (?) "
            ); 
            ps.setInt(1, pk);
            rs = ps.executeQuery();
            rs.next();
            
            toGet.setPk(rs.getInt("pk"));
            toGet.setIdentifier(rs.getString("identifier"));
            toGet.setName(rs.getString("name"));
            //TODO toGet.setType(rs.getString("type"));
            toGet.setDateAcquired(rs.getDate("dateAcquired"));
            //TODO toGet.setRetentionPeriod(rs.getDate("retentionPeriod");
            
            cache.put(pk, toGet);
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            DBUtil.close(ps);
            DBUtil.close(conn);
        }
            
        return toGet;
    }
}
