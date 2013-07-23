package model;

public abstract class Attribute {
    protected int assetFk;
    protected boolean isNew = true;
    protected String name;
    
    protected String getName() {
        return name;
    }
    
    @Override
    protected abstract Attribute clone();
    protected abstract String getValue();
    protected abstract void update() throws RegException;
    
}
