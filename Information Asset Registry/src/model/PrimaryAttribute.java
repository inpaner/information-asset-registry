package model;

public abstract class PrimaryAttribute extends Attribute {

    protected abstract String getValue();
    protected abstract void update() throws RegException;
}
