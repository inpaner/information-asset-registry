package model.sql;

public class GetAllLogs extends SQLBuilder {
    private SQLQuery query;
    
    public GetAllLogs() {
        query = new SQLQuery();
        query.addProjection("userFk");
        query.addProjection("dateTime");
        query.addProjection("action");
        query.addProjection("coreFk");
        query.addProjection("attribute");
        query.addProjection("previousValue");
        query.addProjection("value");
        query.addTable("Log");
    }
    
    @Override
    public String getResult() {
        return query.toString();
    }

}
