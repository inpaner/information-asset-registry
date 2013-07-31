package model.sql;

import model.Core;
import model.attribute.Attribute;

public class EditCore implements SQLBuilder {
    private SQLUpdate statement;

    public EditCore(Core core) {
        statement = new SQLUpdate();
        
        statement.setTable(core.getName());
        for (Attribute attribute : core.getAttributes()) {
            if (attribute.isUpdated())
                statement.addValue(attribute.getName(), attribute.getSQLValue());
        }
        statement.addCondition("pk = " + core.getPk());
        
    }
    
    @Override
    public String getResult() {
        return statement.toString();
    }

}
