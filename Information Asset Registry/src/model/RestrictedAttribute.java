package model;

import java.util.ArrayList;

import schemacrawler.schema.Column;

public class RestrictedAttribute extends Attribute {
    private PrimaryAttribute value;
    private PrimaryAttribute replacement;
    private ArrayList<PrimaryAttribute> possibleAttributes;
    
    private RestrictedAttribute() {
        
    }
    
    protected RestrictedAttribute(Column column) {
        
    }
    
    @Override
    protected String getValue() {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    protected void update() throws RegException {
        // TODO Auto-generated method stub
    }


    @Override
    protected Attribute clone() {
        RestrictedAttribute clone = new RestrictedAttribute();
        clone.value = (PrimaryAttribute) value.clone();
        clone.replacement = (PrimaryAttribute) replacement.clone();
        clone.possibleAttributes = possibleAttributes;
        return clone;
    }

}
