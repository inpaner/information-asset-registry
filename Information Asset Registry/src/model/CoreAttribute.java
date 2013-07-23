package model;

import schemacrawler.schema.Column;

public class CoreAttribute extends Attribute {
    private Core value;
    private Core replacement;
    
    private CoreAttribute(CoreAttribute toClone) {
        value = toClone.value.clone();
        replacement = toClone.replacement.clone();
    }
    
    CoreAttribute(Column column) {
        Core model = CoreUtil.getModel(column.getName());
        value = model;
    }
    
    protected Core model() {
        return value.getModel();
    }
    
    @Override
    protected String getValue() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected void update() throws RegException {
        // TODO Auto-generated method stub
    }

    @Override
    protected Attribute clone() {
        return new CoreAttribute(this);
    }

}
