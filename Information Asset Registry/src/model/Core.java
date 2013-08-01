package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;


import model.attribute.Attribute;
import model.db.DBUtil;
import model.sql.AddCore;
import model.sql.EditCore;
import model.sql.GetCore;
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

    private Core(Core toClone) {
        this(toClone.name);
        for (Attribute attribute : toClone.attributes) {
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
    
    public String getName() {
        return name;
    }

    public void add() {
        // TODO check if all attributes are valid
        SQLBuilder builder = new AddCore(this);
        DBUtil.executeUpdate(builder.getResult());
        Log.addCore(this);
        for (Attribute attribute : attributes) {
            attribute.commitValue();
        }
    }
    
    public void edit() {
        SQLBuilder builder = new EditCore(this);
        DBUtil.executeUpdate(builder.getResult());
        Log.editCore(this);
        for (Attribute attribute : attributes) {
            attribute.commitValue();
        }
    }
    
    protected void refresh() {
        SQLBuilder builder = new GetCore(this);
        ResultSet rs = DBUtil.executeQuery(builder.getResult());
        try {
            rs.next();
            for (Attribute attribute : attributes) {
                attribute.setValue(rs);
                attribute.commitValue();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.finishQuery();
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
    
    public String toString(){
    	return attributes.get(0).getStringValue();
    }
}
    

