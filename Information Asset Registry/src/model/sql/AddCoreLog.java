package model.sql;

import model.Core;
import model.attribute.Attribute;

public class AddCoreLog implements SQLBuilder {
    private SQLInsert statement;

    public AddCoreLog(Core core) {
        statement = new SQLInsert();
        
        statement.setTable(core.getName());
        for (Attribute attribute : core.getAttributes()) {
            statement.addValue(attribute.getName(), attribute.getSQLValue());
        }
    }
    
    @Override
    public String getResult() {
        return statement.toString();
    }

}
