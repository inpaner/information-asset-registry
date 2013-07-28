package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import model.attribute.Attribute;
import model.attribute.AttributeUtil;

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
    private static HashMap<String, HashMap<Integer, Core>> coreCache;
    
    public static void main(String[] args) {
        init();
    }
    
    protected static void init() {
        models = new HashMap<>();
        coreCache = new HashMap<>();
        
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
                // TODO remove line below lel
                System.out.println("******" + model.getName());
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
    
    public static boolean isCore(String name) {
        boolean isCore = false;
        
        name = name.replace("`", "");
        if (models.keySet().contains(name))
            isCore = true;
        return isCore;
    }
    
    public static Core getModel(String name) {
        return models.get(name);
    }
    
    public static Core getAddable(String name) {
        return getModel(name).clone();
    }
    
    public static ArrayList<Core> getAll(String coreName) {
        Connection conn = DBUtil.newConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Integer> pks = new ArrayList<>();
        try {
            // TODO Builder this shit
            String query = "SELECT pk FROM " + coreName;
            ps = conn.prepareStatement(query); 
            rs = ps.executeQuery();
            while (rs.next()) {
                pks.add(rs.getInt("pk"));
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            DBUtil.close(rs);
            DBUtil.close(ps);
            DBUtil.close(conn);
        }
    
        ArrayList<Core> cores = new ArrayList<>();
        for (Integer pk : pks) {
            cores.add(getCore(coreName,pk));
        }
        return cores;
    }
    
    public static Core getCore(String coreName, int pk) {
        Core toGet = coreCache.get(coreName).get(pk);
        if (toGet == null) {
            toGet = new Core(pk);
            coreCache.get(coreName).put(pk, toGet);
        }
        return toGet;
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
            //System.out.println(column.getColumnDataType().getName());
            Attribute attribute = AttributeUtil.build(column);
            System.out.println(attribute.getClass());
            
            model.addAttribute(attribute);
        }
        
    }
    
    public void testSchema() {

    }
}
