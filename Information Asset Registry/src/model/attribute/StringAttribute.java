package model.attribute;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Log;
import model.RegException;
import model.db.DBUtil;

import schemacrawler.schema.Column;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class StringAttribute extends PrimaryAttribute {
    private String value;
    private String previousValue;
    private int MAX_LENGTH;
    
    StringAttribute() {
        MAX_LENGTH = 256;
    }
    
    StringAttribute(Column column) {
        super(column);
        String length = column.getWidth()
                              .replace("(", "")
                              .replace(")", "");
        MAX_LENGTH = Integer.valueOf(length);
    }
    
    public String getSQLValue() {
        return value;
    }
    
    public void setValue(String value) throws RegException {
        if (value.length() > MAX_LENGTH)
            throw new RegException("Max characters: " + MAX_LENGTH);
        this.value = value;
    }
    
    @Override
    public String toString() {
        return value;
    }
    
    public StringAttribute(int assetFk, String value) {
        this.assetFk = assetFk;
        forceValue(value);
    }
    
    public void forceValue(String value) {
        this.value = value;
    }

    @Override
    public Attribute clone() {
        StringAttribute clone = new StringAttribute();
        clone.name = name;
        clone.value = value;
        clone.previousValue = previousValue;
        
        return clone;
    }

    @Override
    public void setValue(ResultSet rs) throws SQLException {
        value = rs.getString(name);
    }

    @Override
    public boolean isUpdated() {
        return !value.equals(previousValue);
    }

    @Override
    public void commitValue() {
        previousValue = value;
    }
    
    public void resetValue() {
        value = previousValue;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String getStringValue() {
        return value;
    }

    @Override
    public String getStringPreviousValue() {
        return previousValue;
    }

    @Override
    public boolean contains(String substring) {
        return value.contains(substring);
    }
}
