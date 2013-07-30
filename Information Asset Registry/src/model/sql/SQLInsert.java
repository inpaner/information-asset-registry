package model.sql;

import java.util.ArrayList;
import java.util.HashSet;

public class SQLInsert {
    private String table;
    private ArrayList<String> projections;
    private ArrayList<String> values;
    
    public static void main(String[] args) {
        SQLQuery q = new SQLQuery();
        q.addProjection("pk");
        q.addProjection("cow");
        q.addProjection("pk");
        q.addTable("Assets");
        System.out.println(q);
    }
    
    public SQLInsert() {
        projections = new ArrayList<>();
        values = new ArrayList<>();
        
    }
    
    public void addProjection(String projection) {
        projections.add(projection);
    }

    public void setTable(String table) {
        this.table = table;
    }

    public void addValue(String condition) {
        values.add(condition);
    }

    public String toString(){
        
        StringBuilder update = new StringBuilder();
        
        update.append("INSERT INTO ");
        update.append(table);
        update.append(" (");
        for (int i = 0; i < projections.size(); i++) {
            update.append(projections.get(i) + " ");
            if (i != projections.size() - 1) {
                update.append(", ");
            }
        }
        
        update.append(") VALUES ( ");
        for (int i = 0; i < values.size(); i++) {
            update.append(values.get(i) + " ");
            if (i != values.size() - 1) {
                update.append(", ");
            }
        }
        
        update.append(");");
        return update.toString();
    }
}
