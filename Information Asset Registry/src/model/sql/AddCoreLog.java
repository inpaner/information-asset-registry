package model.sql;

import model.Core;
import model.Session;

public class AddCoreLog extends SQLBuilder {
    private SQLInsert statement;

    public AddCoreLog(Core core) {
        statement = new SQLInsert();
        
        String userPk = String.valueOf(Session.currentUser().getPk());
        String corePk = String.valueOf(core.getPk());

        
        statement.setTable("Log");
        statement.addValue("userFk", userPk);
        statement.addValue("action", "Add");
        statement.addValue("dateTime", dateTime());
        statement.addValue("coreFk", corePk);
        
    }
    
    @Override
    public String getResult() {
        return statement.toString();
    }

}
