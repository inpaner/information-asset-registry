package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import everything.DBUtil;

import model.attribute.Attribute;
import model.utils.SQLQuery;
import model.utils.SQLUtil;

public class Core {
    private int pk;
    private String name;
    private ArrayList<Attribute> attributes;
    
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
    
    public void add() {
        
    }
    
    public void update() {
        
    }
    
    public String getName() {
        return name;
    }
    
    protected void refresh() {
        Connection conn = DBUtil.newConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            SQLQuery query = SQLUtil.refreshCoreQuery(this);                        
            ps = conn.prepareStatement(query.toString()); 
            rs = ps.executeQuery();
            rs.next();
            for (Attribute attribute : attributes) {
                attribute.forceValue(rs);
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
        
    public Core getModel() {
        return CoreUtil.getModel(name);
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

    public int getPk() {
        // TODO Auto-generated method stub
        return pk;
    }
}
    

