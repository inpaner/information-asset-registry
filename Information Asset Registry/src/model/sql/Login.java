package model.sql;

import model.User;

public class Login extends SQLBuilder {
    SQLQuery statement;
    
    public Login(User user) {
        statement = new SQLQuery();
        statement.addProjection("pk");
        statement.addTable("user");
        statement.addCondition(
                "username = " + user.getUsername().getStringValue());
        statement.addCondition(
                "password = " + user.getPassword().getStringValue());
    }
    
    @Override
    public String getResult() {
        // TODO Auto-generated method stub
        return statement.toString();
    }

}
