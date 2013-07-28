package model;

import java.util.ArrayList;
import java.util.HashMap;

import model.attribute.Attribute;

public class Core {
    private Attribute pk;
    private String name;
    private HashMap<String, Attribute> attributes;
    
    Core(String name) {
        attributes = new HashMap<>();
        this.name = name;
    }

    private Core(Core toCopy) {
        this(toCopy.name);
        for (Attribute attribute : toCopy.attributes.values()) {
            addAttribute(attribute.clone());
        }
    }
    
    public void add() {
        
    }
    
    public void update() {
        
    }
    
    public String getName() {
        return name;
    }
    
    public Core getModel() {
        return CoreUtil.getModel(name);
    }
    
    public void addAttribute(Attribute attribute) {
        attributes.put(attribute.getName(), attribute);
    }
    
    @Override
    public Core clone() {
        return new Core(this);
    }

    public ArrayList<Attribute> getAttributes() {
        return new ArrayList<>(attributes.values());
    }
}
    

