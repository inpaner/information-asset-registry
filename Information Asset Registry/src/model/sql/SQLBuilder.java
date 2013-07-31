package model.sql;

import model.Core;
import model.attribute.Attribute;

public abstract class SQLBuilder {
    public static String getCoreStatement(Core core) {
        SQLQuery query = new SQLQuery();
        
        query.addProjection("pk");
        for (Attribute attribute : core.getAttributes()) {
            query.addProjection(attribute.getName());
        }
        query.addTable(core.getName());
        query.addCondition("pk = " + core.getPk());
        return query.toString();
    }
    
    public static String getAllLogsStatement() {
        SQLQuery query = new SQLQuery();
        query.addProjection("userFk");
        query.addProjection("dateTime");
        query.addProjection("action");
        query.addProjection("coreFk");
        query.addProjection("attribute");
        query.addProjection("previousValue");
        query.addProjection("value");
        query.addTable("Log");
        return query.toString();
    }
    
    public static String insertCoreStatement(Core core) {
        SQLInsert update = new SQLInsert();
        
        update.setTable(core.getName());
        for (Attribute attribute : core.getAttributes()) {
            update.addValue(attribute.getName(), attribute.getSQLValue());
        }
        return update.toString();
    }
    
    public static String insertCoreLogStatement(Core core) {
        SQLInsert update = new SQLInsert();
        
        update.setTable(core.getName());
        for (Attribute attribute : core.getAttributes()) {
            update.addValue(attribute.getName(), attribute.getSQLValue());
        }
        return update.toString();
    }

    public static String updateCoreStatement(Core core) {
        SQLUpdate update = new SQLUpdate();
        
        update.setTable(core.getName());
        for (Attribute attribute : core.getAttributes()) {
            if (attribute.isUpdated())
                update.addValue(attribute.getName(), attribute.getSQLValue());
        }
        update.addCondition("pk = " + core.getPk());
        return update.toString();
    }
}
