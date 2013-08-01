package model.attribute;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import model.Log;
import model.RegException;
import model.db.DBUtil;

import schemacrawler.schema.Column;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class DateAttribute extends PrimaryAttribute {
    protected Date value;
    protected Date previousValue;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
    private final SimpleDateFormat sqlFormat = new SimpleDateFormat("yyyy/mm/dd");
    
        
    private DateAttribute() {
    }
    
    DateAttribute(Column column) {
        super(column);
    }
    
    @Override
    public String getSQLValue() {
        return value.toString();
    }

 
    @Override
    public String getStringValue() {
        return value.toString();
    }

    @Override
    public String getStringPreviousValue() {
        return previousValue.toString();
    }

    @Override
    protected void forceValue(String value) {
        java.util.Date parsedDate;
        try {
            parsedDate = sqlFormat.parse(value);
            Date date = new Date(parsedDate.getTime());
            setValue(date);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void setValue(Date value) {
        this.value = value;
    }

    
    ///// THIS ONE IS BEING USED BY VIEW
    public void setValue(java.util.Date date) throws RegException {
        System.out.println("here");
        if (date == null)
            throw new RegException("Date is not set.");
        value = new Date(date.getTime());
    }

    public void setValue(String text) throws RegException {
        java.util.Date parsedDate;
        try {
            parsedDate = dateFormat.parse(text);
            Date date = new Date(parsedDate.getTime());
            setValue(date);
        }
        catch (ParseException e) {
            throw new RegException("Date format: " + dateFormat.toPattern());
        }
    }

    @Override
    public Attribute clone() {
        DateAttribute clone = new DateAttribute();
        clone.name = name;
        if (value != null)
            clone.value = (Date) value.clone();
        if (previousValue != null)
            clone.previousValue = (Date) previousValue.clone();
        return clone;
    }

    @Override
    public void setValue(ResultSet rs) throws SQLException {
        value = rs.getDate(name);
    }

    @Override
    public boolean isUpdated() {
        return !value.equals(previousValue); 
    }

    @Override
    public void commitValue() {
        previousValue = value;
    }

    @Override
    public void resetValue() {
        value = previousValue;
    }

    @Override
    public boolean contains(String substring) {
        boolean contains = false;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(value);
        int day = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        
        String dayString = String.valueOf(day);
        String monthString = new DateFormatSymbols().getMonths()[month-1];
        String yearString = String.valueOf(year);
        
        if (dayString.contains(substring) || monthString.contains(substring) 
                || yearString.contains(substring) ) {
            contains = true;
        }
        
        return contains;
    }
    

}
