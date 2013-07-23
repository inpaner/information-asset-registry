package model;

import schemacrawler.schema.Column;

public class AttributeUtil {
    
    protected static Attribute build(Column column) {
        Attribute attribute;
        if (column.isPartOfForeignKey()) {
            attribute = foreignUtil(column);
        }
        else {
            attribute = primaryUtil(column);
        }
        return attribute;
    }
    
    private static Attribute foreignUtil(Column column) {
        Attribute attribute;
        if (CoreUtil.isCore(column.getName())) {
            attribute = new CoreAttribute(column);
        }
        // TODO CompoundAttribute
        else {
            attribute = new RestrictedAttribute(column);
        }
        
        return attribute;
    }
    
    private static Attribute primaryUtil(Column column) {
        Attribute attribute;
        
        switch (column.getColumnDataType().getName()) {
        case "INT" : 
            attribute = new IntegerAttribute(column);
            break;
        case "VARCHAR" : 
            attribute = new StringAttribute(column);
            break;
        case "DATE" : 
            attribute = new DateAttribute(column);
            break;
        default :
            attribute = null;
        }
           
        return attribute;
    }
}
