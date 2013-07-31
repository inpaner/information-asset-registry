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
    protected String value;
    protected String previousValue;
    
    StringAttribute() {
    }
    
    StringAttribute(Column column) {
        super(column);
    }
    
    public String getSQLValue() {
        return value;
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

    @Override
    public void update() throws RegException {
        // TODO Auto-generated method stub
    }

    public String getValue() {
        return value;
    }

    @Override
    public String getStringValue() {
        return value;
    }
}
