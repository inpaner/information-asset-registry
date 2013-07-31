package model.attribute;

import java.sql.ResultSet;
import java.sql.SQLException;

import schemacrawler.schema.Column;
import model.RegException;

public abstract class Attribute {
    private int pk;
    protected int assetFk;
    protected boolean isNew = true;
    protected String name;
    
    public String getName() {
        return name;
    }
    
    protected Attribute() {
    }
    
    protected Attribute(Column column) {
        name = column.getName().replace("`", "");
    }
    
    public int getPk() {
        return pk;
    }
    
    @Override
    public abstract Attribute clone();
    public abstract String getStringValue();
    public abstract String getSQLValue();
    public abstract String getStringPreviousValue();
    public abstract void update() throws RegException;
    public abstract boolean isUpdated();
    public abstract void commitValue();
    public abstract void resetValue();
    
    // TODO check for null forceValues
    public abstract void setValue(ResultSet rs) throws SQLException;

    
}
