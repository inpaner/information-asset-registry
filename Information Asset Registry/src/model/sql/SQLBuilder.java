package model.sql;

import java.util.LinkedHashSet;

public class SQLBuilder {
    private LinkedHashSet<String> attributes;
    private String table;
    
    private SQLBuilder() {   
    }
    
    private void setTable(String table) {
        this.table = table;
    }
    
    public void addAttribute(String attribute) {
        attributes.add(attribute);
    }
    
    
    public String toString() {
        StringBuilder query = new StringBuilder();
        query.append("SELECT ");
        int attributeCount = 0;
        for (String attribute : attributes) {
            query.append(attribute + " ");
            if (attributeCount != attributes.size() - 1) {
                query.append(",");
            }
            query.append(" \nFROM " + table + " ");
            attributeCount++;
        }
        
        return query.toString();
    }
}
