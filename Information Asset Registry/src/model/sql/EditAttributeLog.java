package model.sql;

import model.Core;
import model.Session;
import model.attribute.Attribute;

public class EditAttributeLog extends SQLBuilder {
    private SQLInsert statement;

    public EditAttributeLog(Core core, Attribute attribute, String dateTime) {
        statement = new SQLInsert();
        
        String userPk = String.valueOf(Session.currentUser().getPk());
        String corePk = String.valueOf(core.getPk());
        
        statement.setTable("Log");
        statement.addValue("userFk", userPk);
        statement.addValue("action", "Edit");
        statement.addValue("dateTime", dateTime);
        statement.addValue("coreFk", corePk);
        statement.addValue("previousValue", attribute.getStringPreviousValue());
        statement.addValue("value", attribute.getStringValue());
    }
    
    @Override
    public String getResult() {
        return statement.toString();
    }

}
