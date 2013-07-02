package model.bean;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import everything.DBUtil;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public abstract class DateAttribute extends Attribute {
    protected Date value;
    protected Date replacement;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    
    
    // protected static Classification latest(int assetFk);
        // Java doesn't do abstract static, but latest() 
        // is required by all attributes
    
    public Date value() {
        return value;
    }
    
    @Override
    public String toString() {
        return dateFormat.format(value);
    }

    public void setValue(Date value) {
        replacement = value;
        if (isNew) {
            this.value = value;
        }
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

    private void insert(int assetFk) throws RegException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Connection conn = DBUtil.getConnection();
            String update = 
                "INSERT INTO " + attribute() + " (assetFk, value) " +
                "VALUES (?, ?)";
            ps = conn.prepareStatement(update);                
            ps.setInt(1, assetFk);
            ps.setDate(2, value);
            ps.executeUpdate();
            
            isNew = false;
            this.assetFk = assetFk;
        }
        catch (MySQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
            String message = "Invalid value for " + attribute() + ".";
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
            String message = attribute() + " already exists.";
            throw new RegException(message);            
        }
        if (value == null) {
            String message = attribute() + " not set.";
            throw new RegException(message);            
        }
        insert(assetFk);
    }
    
    protected void update() throws RegException {
        if (isNew) {
            String message = attribute() + " does not yet exist.";
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
            Log.updateAttribute(assetFk, attribute(), attributeFk);
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            DBUtil.close(rs);
            DBUtil.close(ps);
        }   
    }
}
