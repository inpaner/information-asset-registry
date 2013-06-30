package model.bean;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import everything.DBUtil;

public class Asset {
    private static HashMap<Integer, Asset> cache;
    
    private int pk;
    private String name;
    private Owner owner;
    private Custodian custodian;
    private String type;
    private Date dateAcquired;
    private Date retentionPeriod;
    private Financial financial;
    private Confidentiality confidentiality;
    private Integrity integrity;
    private Availability availability;
    private Classification classification;
    private Storage storage;
    
    static {
        cache = new HashMap<>();
    }
    
    public static void main(String[] args) {
        Asset a = new Asset();
        try {
            a.setName("Table");
            a.setType("Paper");
            a.setDateAcquired(new Date(System.currentTimeMillis()));
            a.setRetentionPeriod(new Date(System.currentTimeMillis()));
            a.setClassification("Internal");
            System.out.println(a.classification().value);
            a.add();
        }
        catch (RegException e) {
            e.printStackTrace();
        }
            
    }
    
    private void setType(String type) {
        this.type = type;
    }

    private Asset() {
        pk = 0;
        owner = new Owner();
        custodian = new Custodian();
        financial = new Financial();
        confidentiality = new Confidentiality();
        integrity = new Integrity();
        availability = new Availability();
        classification = new Classification();
        storage = new Storage();
    }
    
    public void add() throws RegException {
        if (pk != 0) {
            String message = "Asset " + pk + " already added.";
            throw new RegException(message);
        }
        
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(
                "INSERT INTO Asset (name, type, dateAcquired, retentionPeriod) " +
                "VALUES (?, ?, ?, ?)");             
            
            ps.setString(1, name);
            ps.setString(2, type);
            ps.setDate(3, dateAcquired);
            ps.setDate(4, retentionPeriod);
            ps.executeUpdate();
          
            ps = conn.prepareStatement("SELECT pk FROM Asset ORDER BY pk desc");
            rs = ps.executeQuery();
            rs.next();
            pk = rs.getInt("pk");
            
            classification.add(pk);
            
            
            /*            
            owner.add(pk);
            custodian.add(pk);
            financial.add(pk);
            confidentiality.add(pk);
            integrity.add(pk);
            availability.add(pk);
            classification.add(pk);
            storage.add(pk);
            */
            
            // TODO Log.add();
            
            cache.put(pk, this);
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.close(ps);
            DBUtil.close(conn);
        }
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
    
    public void setClassification(String value) {
        classification.setValue(value);
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
        Connection conn = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(
                "SELECT identifier, name, type" +
                "       dateAcquired, retentionPeriod " + 
                "FROM Asset " +
                "WHERE pk = (?) "
            ); 
            ps.setInt(1, pk);
            rs = ps.executeQuery();
            rs.next();
            
            this.pk = pk;
            name = rs.getString("name");
            type = rs.getString("type");
            dateAcquired = rs.getDate("dateAcquired");
            retentionPeriod = rs.getDate("retentionPeriod");
                      
            owner = Owner.latest(pk);
            custodian = Custodian.latest(pk);
            financial = Financial.latest(pk);
            confidentiality = Confidentiality.latest(pk);
            integrity = Integrity.latest(pk);
            availability = Availability.latest(pk);
            classification = Classification.latest(pk);
            storage = Storage.latest(pk);
            
            cache.put(pk, this);
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            DBUtil.close(ps);
            DBUtil.close(conn);
        }
    }
}
