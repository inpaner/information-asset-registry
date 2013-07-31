package model.sql;

import model.Core;
import model.attribute.Attribute;

public class AddCore implements SQLBuilder {
    private SQLInsert update;

    public AddCore(Core core) {
        update = new SQLInsert();
        
        update.setTable(core.getName());
        for (Attribute attribute : core.getAttributes()) {
            update.addValue(attribute.getName(), attribute.getSQLValue());
        }    
    }
    
    @Override
    public String getResult() {
        return update.toString();
    }

}
