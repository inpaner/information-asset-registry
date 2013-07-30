package model.attribute;

import schemacrawler.schema.Column;

public abstract class PrimaryAttribute extends Attribute {

    PrimaryAttribute() {
        
    }
    
    protected PrimaryAttribute(Column column) {
        super(column);
    }
    protected abstract void forceValue(String value);
}
