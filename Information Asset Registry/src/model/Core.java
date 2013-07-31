package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;


import model.attribute.Attribute;
import model.db.DBUtil;
import model.sql.SQLQuery;
import model.sql.SQLBuilder;

public class Core {
    private int pk;
    private String name;
    private ArrayList<Attribute> attributes;
    private Attribute uniqueAttribute;
    
    Core(String name) {
        attributes = new ArrayList<>();
        this.name = name;
    }

    private Core(Core toCopy) {
        this(toCopy.name);
        for (Attribute attribute : toCopy.attributes) {
            Attribute clone = attribute.clone();
            addAttribute(clone);
        }
    }
    
    protected void setPk(int pk) {
        this.pk = pk;
    }
    
    public int getPk() {
        return pk;
    }
    
    public void add() {
        // TODO check if all attributes are valid
        String statement = SQLBuilder.insertCoreStatement(this);
        DBUtil.executeUpdate(statement);
        for (Attribute attribute : attributes) {
            attribute.commitValue();
        }
    }
    
    public void update() {
        String statement = SQLBuilder.updateCoreStatement(this);
        DBUtil.executeUpdate(statement);
        for (Attribute attribute : attributes) {
            attribute.commitValue();
        }
    }
    
    public String getName() {
        return name;
    }
    
    protected void refresh() {
        Connection conn = DBUtil.newConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = SQLBuilder.getCoreStatement(this);                        
            ps = conn.prepareStatement(query); 
            rs = ps.executeQuery();
            rs.next();
            for (Attribute attribute : attributes) {
                attribute.setValue(rs);
                attribute.commitValue();
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
    }
    
    protected void addAttribute(Attribute attribute) {
        attributes.add(attribute);
    }
    
    @Override
    public Core clone() {
        return new Core(this);
    }

    public ArrayList<Attribute> getAttributes() {
        return attributes;
    }

    protected void setUnique(Attribute attribute) {
        if (uniqueAttribute != null)
            uniqueAttribute = attribute;
    }
    
    public String getUniqueString() {
        return uniqueAttribute.getStringValue();
    }
}
    

