package model.attribute;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Vector;

import model.Log;
import model.RegException;
import model.db.DBUtil;

import schemacrawler.schema.Column;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;


public class IntegerAttribute extends PrimaryAttribute {
    protected int value = 0;
    protected int previousValue = 0;
    
    private IntegerAttribute() {
    }
    
    IntegerAttribute(Column column) {
        super(column);
    }
    
    public int value() {
        return value;
    }
    
    public String toString() {
        return String.valueOf(value);
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    @Override
    public String getSQLValue() {
        return String.valueOf(value);
    }

    @Override
    public Attribute clone() {
        IntegerAttribute clone = new IntegerAttribute();
        clone.name = name;
        clone.value = value;
        clone.previousValue = previousValue;
        return clone;
    }

    @Override
    public void setValue(ResultSet rs) throws SQLException {
        value = rs.getInt(name);
    }

    @Override
    public boolean isUpdated() {
        return value != previousValue;
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
    protected void forceValue(String value) {
        this.value = Integer.valueOf(value);
    }

    @Override
    public String getStringValue() {        
        return String.valueOf(value);
    }

    @Override
    public String getStringPreviousValue() {
        return String.valueOf(previousValue);
    }

}
