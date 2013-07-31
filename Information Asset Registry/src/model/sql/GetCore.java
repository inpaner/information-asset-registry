package model.sql;

import model.Core;
import model.attribute.Attribute;

public class GetCore extends SQLBuilder {
    private SQLQuery query;
    
    public GetCore(Core core) {
        query = new SQLQuery();
        
        query.addProjection("pk");
        for (Attribute attribute : core.getAttributes()) {
            query.addProjection(attribute.getName());
        }
        query.addTable(core.getName());
        query.addCondition("pk = " + core.getPk());
    }
    
    @Override
    public String getResult() {
        return query.toString();
    }

}
