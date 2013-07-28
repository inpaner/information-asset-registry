package model.utils;

import model.Core;
import model.attribute.Attribute;

public class SQLUtil {
    public static SQLQuery refreshCoreQuery(Core core) {
        SQLQuery query = new SQLQuery();
        
        query.addProjection("pk");
        for (Attribute attribute : core.getAttributes()) {
            query.addProjection(attribute.getName());
        }
        query.addTable(core.getName());
        query.addCondition("pk = " + core.getPk());
        return query;
    }
}
