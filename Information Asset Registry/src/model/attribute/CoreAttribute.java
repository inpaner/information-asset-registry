package model.attribute;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Core;
import model.CoreUtil;
import model.RegException;
import schemacrawler.schema.Column;

public class CoreAttribute extends Attribute {
    private Core value;
    private Core replacement;
    
    private CoreAttribute(CoreAttribute toClone) {
        value = toClone.value.clone();
        replacement = toClone.replacement.clone();
    }
    
    CoreAttribute(Column column) {
        value = CoreUtil.getModel(column.getName());
        name = column.getName();
    }
    
    protected Core model() {
        return value.getModel();
    }
    
    @Override
    protected String getValueString() {
        return null;
    }

    @Override
    protected void update() throws RegException {
        // TODO Auto-generated method stub
    }

    @Override
    public Attribute clone() {
        return new CoreAttribute(this);
    }

    @Override
    public void forceValue(ResultSet rs) throws SQLException {
        int pk = rs.getInt(name);
        value = CoreUtil.getCore(name, pk);
    }
    
}
