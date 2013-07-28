package model.attribute;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import model.Log;
import model.RegException;

import schemacrawler.schema.Column;

import everything.DBUtil;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class DateAttribute extends PrimaryAttribute {
    protected Date value;
    protected Date replacement;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    
    private DateAttribute() {
    }
    
    DateAttribute(Column column) {
        super(column);
    }
    
    @Override
    public String getValueString() {
        return dateFormat.format(value);
    }

    public void setValue(Date value) {
        replacement = value;
        if (isNew)
            this.value = value;
    }

    public void setValue(String text) throws RegException {
        try {
            java.util.Date sdf = dateFormat.parse(text);
            Date date = new Date(sdf.getTime());
            setValue(date);
        }
        catch (ParseException e) {
            throw new RegException("Date format: MM/dd/yyyy");
        }
    }
/*
    private void insert(int assetFk) throws RegException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection conn = DBUtil.getConnection();
            String update = 
                "INSERT INTO " + getValue() + " (assetFk, value) " +
                "VALUES (?, ?)";
            ps = conn.prepareStatement(update);                
            ps.setInt(1, assetFk);
            ps.setDate(2, replacement);
            ps.executeUpdate();
            
            isNew = false;
            this.assetFk = assetFk;
        }
        catch (MySQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
            String message = "Invalid value for " + getValue() + ".";
            throw new RegException(message);	
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.close(rs);
            DBUtil.close(ps);
        }   
    }

    protected void add(int assetFk) throws RegException {
        if (!isNew) {
            String message = getValue() + " already exists.";
            throw new RegException(message);            
        }
        if (value == null) {
            String message = getValue() + " not set.";
            throw new RegException(message);            
        }
        insert(assetFk);
    }
    
    protected void update() throws RegException {
        if (isNew) {
            String message = getValue() + " does not yet exist.";
            throw new RegException(message);   
        }
        
        if (value.equals(replacement)) 
            return;
        // early return
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            insert(assetFk);
            
            Connection conn = DBUtil.getConnection();
            ps = conn.prepareStatement("SELECT LAST_INSERT_ID() AS fk");
            rs = ps.executeQuery();
            rs.next();
            int attributeFk = rs.getInt("fk");
            Log.updateAttribute(assetFk, getValue(), attributeFk);
            value = replacement;
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            DBUtil.close(rs);
            DBUtil.close(ps);
        }
        
        
    }

*/

    @Override
    public Attribute clone() {
        DateAttribute clone = new DateAttribute();
        clone.value = value;
        clone.replacement = replacement;
        return clone;
    }

    @Override
    protected void update() throws RegException {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected String getValue() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void forceValue(String value) {
        this.value = Date.valueOf(value);
    }
}
