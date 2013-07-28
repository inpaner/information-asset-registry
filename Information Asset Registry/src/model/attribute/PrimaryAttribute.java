package model.attribute;

import schemacrawler.schema.Column;
import model.RegException;

public abstract class PrimaryAttribute extends Attribute {

    PrimaryAttribute() {
        
    }
    
    protected PrimaryAttribute(Column column) {
        super(column);
    }
    protected abstract String getValue();
    protected abstract void update() throws RegException;
    public abstract void forceValue(String value);
}
