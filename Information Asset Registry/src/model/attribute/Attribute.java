package model.attribute;

import java.sql.ResultSet;
import java.sql.SQLException;

import schemacrawler.schema.Column;
import model.RegException;

public abstract class Attribute {
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
    
    @Override
    public abstract Attribute clone();
    public abstract String getValueString();
    public abstract void update() throws RegException;
    public abstract boolean isUpdated();
    public abstract void commitValue();
    public abstract void resetValue();
    
    // TODO check for null forceValues
    public abstract void setValue(ResultSet rs) throws SQLException;
}
