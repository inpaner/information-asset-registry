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
    private Name name;
    private Identifier identifier;
    private Owner owner;
    private Custodian custodian;
    private String type;
    private DateAcquired dateAcquired;
    private RetentionPeriod retentionPeriod;
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
            a.setType("Paper");
            a.setIntegrity(3);
            a.add();
            System.out.println("here");
            
        }
        catch (RegException e) {
            e.printStackTrace();
        }
            
    }

    public Name name() {
        return name;
    }

    public Identifier identifier() {
        return identifier;
    }

    public Owner owner() {
        return owner;
    }

    public Custodian custodian() {
        return custodian;
    }

    public String type() {
        return type;
    }

    public DateAcquired dateAcquired() {
        return dateAcquired;
    }

    public RetentionPeriod retentionPeriod() {
        return retentionPeriod;
    }

    public Financial getFinancial() {
        return financial;
    }

    public Confidentiality confidentiality() {
        return confidentiality;
    }

    public Integrity integrity() {
        return integrity;
    }

    public Availability availability() {
        return availability;
    }

    public Classification classification() {
        return classification;
    }

    public Storage storage() {
        return storage;
    }

    public void setName(String value) {
        name.setValue(value);
    }

    public void setIdentifier(String value) {
        identifier.setValue(value);
    }

    public void setOwner(String value) {
        owner.setValue(value);
    }

    public void setCustodian(String value) {
        custodian.setValue(value);
    }

    public void setDateAcquired(Timestamp value) {
        dateAcquired.setValue(value);
    }

    public void setRetentionPeriod(Timestamp value) {
        retentionPeriod.setValue(value);
    }

    public void setFinancial(int value) {
        financial.setValue(value);
    }

    public void setConfidentiality(int value) {
        confidentiality.setValue(value);
    }

    public void setIntegrity(int value) {
        integrity.setValue(value);
    }

    public void setAvailability(int value) {
        availability.setValue(value);
    }

    public void setClassification(String value) {
        classification.setValue(value);
    }

    public void setStorage(String value) {
        storage.setValue(value);
    }

    public void setType(String type) {
        this.type = type;
    }

    private Asset() {
        pk = 0;
        name = new Name();
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
            String message = "Asset already added.";
            throw new RegException(message);
        }
        
        Connection conn = DBUtil.newConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn.setAutoCommit(false);
            ps = conn.prepareStatement(
                "INSERT INTO Asset (type) " +
                "VALUES (?)");             
            
            ps.setString(1, type);
            ps.executeUpdate();
          
            ps = conn.prepareStatement("SELECT pk FROM Asset ORDER BY pk desc");
            rs = ps.executeQuery();
            rs.next();
            pk = rs.getInt("pk");
            /*
            name.add(pk);
            identifier.add(pk);
            owner.add(pk);
            custodian.add(pk);
            dateAcquired.add(pk);
            retentionPeriod.add(pk);
            financial.add(pk);
            confidentiality.add(pk);
            integrity.add(pk);
            availability.add(pk);
            classification.add(pk);
            storage.add(pk);
            */
            
            integrity.add(pk);
            // TODO Log.add();
            System.out.println("here");
            
            cache.put(pk, this);
            DBUtil.commit(conn);
            
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
            /*
            name.update();
            identifier.update();
            owner.update();
            custodian.update();
            dateAcquired.update();
            retentionPeriod.update();
            financial.update();
            confidentiality.update();
            integrity.update();
            availability.update();
            classification.update();
            storage.update();
            */
            
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
            DBUtil.close(ps);
            DBUtil.close(conn);
        }
    }
    
    protected int pk() {
        return pk;
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
            ps = conn.prepareStatement(
                "SELECT type " +
                "FROM Asset " +
                "WHERE pk = (?) "
            ); 
            ps.setInt(1, pk);
            rs = ps.executeQuery();
            rs.next();
            
            this.pk = pk;
            name = Name.latest(pk);
            identifier = Identifier.latest(pk);
            type = rs.getString("type");
                      
            owner = Owner.latest(pk);
            custodian = Custodian.latest(pk);
            dateAcquired = DateAcquired.latest(pk);
            retentionPeriod = RetentionPeriod.latest(pk);
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
