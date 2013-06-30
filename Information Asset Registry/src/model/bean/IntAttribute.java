package model.bean;

public abstract class IntAttribute extends Attribute {
    protected int value;
    
    // protected static Classification latest(int assetFk);
        // Java doesn't do abstract static, but latest() 
        // is required by all attributes

    public abstract void update(int replacement);
    
    public int value() {
        return value;
    }
    
    public String toString() {
        return String.valueOf(value);
    }
}
