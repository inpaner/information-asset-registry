package model.sql;

import java.sql.Timestamp;

public abstract class SQLBuilder {
    public abstract String getResult();
    
    protected String dateTime() {
        Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
        return timeStamp.toString();
    }
}
