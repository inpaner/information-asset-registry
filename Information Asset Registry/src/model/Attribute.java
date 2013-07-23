package model;

public abstract class Attribute {
    protected int assetFk;
    protected boolean isNew = true;
    protected String name;
    
    protected String getName() {
        return name;
    }
    
    protected abstract String getValue();
    protected abstract void update() throws RegException;
    protected abstract Attribute clone();
    
}
