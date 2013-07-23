package model;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import schemacrawler.schema.Column;
import schemacrawler.schema.Database;
import schemacrawler.schema.Schema;
import schemacrawler.schema.Table;
import schemacrawler.schemacrawler.SchemaCrawlerException;
import schemacrawler.schemacrawler.SchemaCrawlerOptions;
import schemacrawler.schemacrawler.SchemaInfoLevel;
import schemacrawler.utility.SchemaCrawlerUtility;
import everything.DBUtil;

public class CoreUtil {
    private static HashMap<String, Core> models;
    private static HashMap<String, HashMap<String, Core>> coreCollection;
    
    
    public static void main(String[] args) {
        init();
    }

    protected static void init() {
        models = new HashMap<>();
        coreCollection = new HashMap<>();
        
        // TODO load coreNames from some file
        ArrayList<String> coreNames = new ArrayList<>();     
        coreNames.add("asset");
        coreNames.add("user");
        
        for (String name : coreNames) {
            models.put(name, new Core(name));
        }
        
        Connection conn = DBUtil.newConnection();
        final SchemaCrawlerOptions options = new SchemaCrawlerOptions();
        options.setSchemaInfoLevel(SchemaInfoLevel.standard());
        Database database = null;
        try {
            database = SchemaCrawlerUtility.getDatabase(conn, options);
            for (Core model : models.values()) {
                build(database, model);
            }
        }
        catch (SchemaCrawlerException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.close(conn);
        }
    }
    
    protected static boolean isCore(String name) {
        boolean isCore = false;
        if (models.keySet().contains(name))
            isCore = true;
        return isCore;
    }
    
    protected static Core getModel(String name) {
        return models.get(name);
    }
    
    public static ArrayList<Core> getAll(String coreName) {
        HashMap<String, Core> cores = coreCollection.get(coreName);
        return new ArrayList<Core>(cores.values());
    }
    
    public static Core get(String coreName, String pk) {
        Core toGet = coreCollection.get(coreName).get(pk);
        if (toGet == null) {
            getFromDB(pk);
        }
        return toGet;
    }
    
    private static void getFromDB(String name) {
        
    }
    
    protected static void build(Database database, Core model) {
        //TODO DBUtil getSchemaName
        Schema schema = database.getSchema("`information asset registry`");

        Table table = database.getTable(schema, model.getName());    
        
        // Catches inconsistencies with DB naming scheme
        if (table == null) {
            String modelName = "`" + model.getName() + "`";
            table = database.getTable(schema, modelName);
        }
        
        for (Column column: table.getColumns()) {
            System.out.println(column.getColumnDataType().getName());
            Attribute attribute = AttributeUtil.build(column);
            model.addAttribute(attribute);
        }
    }
    
    public void testSchema() {

    }
}
