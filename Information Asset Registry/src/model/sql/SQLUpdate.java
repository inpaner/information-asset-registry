package model.sql;

import java.util.ArrayList;

public class SQLUpdate extends SQLStatement {
    private String table;
    private ArrayList<String> values;
    private ArrayList<String> conditions;
    
    public static void main(String[] args) {
        SQLQuery q = new SQLQuery();
        q.addProjection("pk");
        q.addProjection("cow");
        q.addProjection("pk");
        q.addTable("Assets");
        System.out.println(q);
    }
    
    public SQLUpdate() {
        values = new ArrayList<>();
        conditions = new ArrayList<>();
    }
    
    public void setTable(String table) {
        this.table = table;
    }

    public void addValue(String projection, String value) {
        values.add("`" + projection + "`" 
                    + "=" + "'" + value + "'");
    }

    public void addCondition(String condition) {
        conditions.add(condition);
    }

    
    public String toString(){
        StringBuilder update = new StringBuilder();
        
        update.append("UPDATE ");
        update.append(table);
        update.append(" SET ");
        for (int i = 0; i < values.size(); i++) {
            update.append(values.get(i) + " ");
            if (i != values.size() - 1) {
                update.append(", ");
            }
        }
        
        update.append(" WHERE ");
        for (int i = 0; i < conditions.size(); i++) {
            update.append(conditions.get(i) + " ");
            if (i != conditions.size() - 1) {
                update.append("AND ");
            }
        }
        
        update.append(";");
        return update.toString();
    }
}
