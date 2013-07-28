package model.sql;

import java.util.LinkedHashSet;

public class SQLInsert {
    private LinkedHashSet<String> projections;
    private LinkedHashSet<String> tables;
    private LinkedHashSet<String> conditions;
    private LinkedHashSet<String> sequences;
    
    public static void main(String[] args) {
        SQLQuery q = new SQLQuery();
        q.addProjection("pk");
        q.addProjection("cow");
        q.addProjection("pk");
        q.addTable("Assets");
        System.out.println(q);
    }
    
    public SQLInsert() {
        projections = new LinkedHashSet<>();
        tables = new LinkedHashSet<>();
        conditions = new LinkedHashSet<>();
        sequences = new LinkedHashSet<>();
    }
    
    public void addProjection(String projection) {
        projections.add(projection);
    }

    public void addTable(String table) {
        tables.add(table);
    }

    public void addCondition(String condition) {
        conditions.add(condition);
    }

    public void addSequence(String seqence) {
        sequences.add(seqence);
    }

    public String toString(){
        
        StringBuilder query = new StringBuilder();
        
        query.append("INSERT INTO ");
        int count = 0;
        for (String projection : projections) {
            query.append(projection + " ");
            if (count != projections.size() - 1) {
                query.append(", ");
            }
            count++;
        }
        
        query.append("FROM ");
        count = 0;
        for (String table : tables) {
            query.append(table + " ");
            if (count != tables.size() - 1) {
                query.append(", ");
            }
            count++;
        }
        
        if (conditions.size() != 0) {
            query.append("WHERE ");
            count = 0;
            for (String condition : conditions) {
                query.append(condition + " ");
                if (count != conditions.size() - 1) {
                    query.append(", ");
                }
                count++;
            }    
        }
        
        if (sequences.size() != 0) {
            query.append("ORDER BY ");
            count = 0;
            for (String sequence : sequences) {
                query.append(sequence + " ");
                if (count != sequences.size() - 1) {
                    query.append(", ");
                }
                count++;
            }    
        }
        query.append(";");
        return query.toString();
    }
}
