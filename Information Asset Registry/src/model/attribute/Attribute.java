package model.attribute;

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
        name = column.getName();
    }
    
    @Override
    public abstract Attribute clone();
    protected abstract String getValueString();
    protected abstract void update() throws RegException;
    
}
