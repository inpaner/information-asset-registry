package model.sql;

import model.Core;
import model.attribute.Attribute;

public class SQLUtil {
    public static String refreshCoreQuery(Core core) {
        SQLQuery query = new SQLQuery();
        
        query.addProjection("pk");
        for (Attribute attribute : core.getAttributes()) {
            query.addProjection(attribute.getName());
        }
        query.addTable(core.getName());
        query.addCondition("pk = " + core.getPk());
        return query.toString();
    }
    
    public static String insertCoreQuery(Core core) {
        SQLInsert update = new SQLInsert();
        
        update.setTable(core.getName());
        for (Attribute attribute : core.getAttributes()) {
            update.addProjection(attribute.getName());
            update.addValue(attribute.getValueString());
        }
        return update.toString();
    }
    
    public static String updateCoreQuery(Core core) {
        SQLInsert update = new SQLInsert();
        
        update.setTable(core.getName());
        for (Attribute attribute : core.getAttributes()) {
            update.addProjection(attribute.getName());
            update.addValue(attribute.getValueString());
        }
        return update.toString();
    }
}
