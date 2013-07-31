package model.sql;

import model.Action;
import model.Session;

public class UserLogged extends SQLBuilder {
    private SQLInsert statement;

    public UserLogged(Action action) {
        statement = new SQLInsert();
        
        String userPk = String.valueOf(Session.currentUser().getPk());
        
        statement.setTable("Log");
        statement.addValue("userFk", userPk);
        statement.addValue("action", action.toString());
        statement.addValue("dateTime", dateTime());
    }
    
    @Override
    public String getResult() {
        return statement.toString();
    }

}
