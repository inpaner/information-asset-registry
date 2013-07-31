package model.sql;

import java.sql.Timestamp;

import model.Core;
import model.Session;
import model.attribute.Attribute;

public class EditAttributeLog implements SQLBuilder {
    private SQLUpdate statement;

    public EditAttributeLog(Core core, Attribute attribute, String dateTime) {
        statement = new SQLUpdate();
        
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
