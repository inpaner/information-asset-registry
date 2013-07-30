package model.attribute;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Core;
import model.CoreUtil;
import model.RegException;
import schemacrawler.schema.Column;

public class CoreAttribute extends Attribute {
    private Core model;
    private Core value;
    private Core replacement;
    
    private CoreAttribute() {

    }
    
    CoreAttribute(Column column) {
        super(column);
        String tableName = column.getReferencedColumn()
                                 .getParent()
                                 .getName()
                                 .replace("`", "");
        model = CoreUtil.getModel(tableName);
    }
    
    protected Core model() {
        return model;
    }
    
    @Override
    public String getValueString() {
        return null;
    }

    @Override
    public void update() throws RegException {
        // TODO Auto-generated method stub
    }

    @Override
    public Attribute clone() {
        CoreAttribute clone = new CoreAttribute();
        clone.name = name;
        clone.model = model;
        if (value != null)
            clone.value = value.clone();
        if (replacement != null)
            clone.replacement = replacement.clone();
        
        return clone;
    }

    @Override
    public void forceValue(ResultSet rs) throws SQLException {
        int pk = rs.getInt(name);
        value = CoreUtil.getCore(model.getName(), pk);
    }

    @Override
    public boolean isUpdated() {
        return !value.equals(replacement);
    }

    @Override
    public void commitValue() {
        value = replacement;
    }
    
}
