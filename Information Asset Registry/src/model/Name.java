package model;

public class Name extends StringAttribute {
    private static final String attribute = "Name"; 
    
    
    public Name(int pk, String string) {
        super(pk, string);
    }

    @Override
    protected String getValue() {
        return attribute;
    }

}
