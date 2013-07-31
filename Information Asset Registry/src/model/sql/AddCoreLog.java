package model.sql;

import java.sql.Timestamp;

import model.Core;
import model.Session;
import model.attribute.Attribute;

public class AddCoreLog implements SQLBuilder {
    private SQLInsert statement;

    public AddCoreLog(Core core) {
        statement = new SQLInsert();
        
        String userPk = String.valueOf(Session.currentUser().getPk());
        String corePk = String.valueOf(core.getPk());
        Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
        String dateTime = timeStamp.toString();
        
        statement.setTable("Log");
        statement.addValue("userFk", userPk);
        statement.addValue("action", "Add");
        statement.addValue("dateTime", dateTime);
        statement.addValue("coreFk", corePk);
        
    }
    
    @Override
    public String getResult() {
        return statement.toString();
    }

}
