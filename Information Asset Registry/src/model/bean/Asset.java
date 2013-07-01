package model.bean;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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
    private Type type;
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
    
    public Asset() {
        pk = 0;
        name = new Name();
        identifier = new Identifier();
        owner = new Owner();
        custodian = new Custodian();
        type = new Type();
        dateAcquired = new DateAcquired();
        retentionPeriod = new RetentionPeriod();
        financial = new Financial();
        confidentiality = new Confidentiality();
        integrity = new Integrity();
        availability = new Availability();
        classification = new Classification();
        storage = new Storage();
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

    public Type type() {
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

    public void setDateAcquired(Date value) {
        dateAcquired.setValue(value);
    }

    public void setDateAcquired(String text) throws RegException {
        dateAcquired.setValue(text);
    }
    
    public void setRetentionPeriod(Date value) {
        retentionPeriod.setValue(value);
    }

    public void setRetentionPeriod(String text) throws RegException {
        retentionPeriod.setValue(text);
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

    public void setType(String value) {
        type.setValue(value);
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
          
            ps = conn.prepareStatement("SELECT pk FROM Asset ORDER BY pk desc");
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
    
    protected int pk() {
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
            ps = conn.prepareStatement(
                "SELECT type " +
                "FROM Asset " +
                "WHERE pk = (?) "
            ); 
            ps.setInt(1, pk);
            rs = ps.executeQuery();
            if (rs.next()) {
                this.pk = pk;
                name = Name.latest(pk);
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
