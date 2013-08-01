package model.attribute;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Core;
import model.CoreUtil;
import model.RegException;
import schemacrawler.schema.Column;

public class CoreAttribute extends Attribute {
    private Core model;
    private Core value;
    private Core previousValue;
    
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
    public String getSQLValue() {
        return String.valueOf(value.getPk());
    }

    @Override
    public String getStringPreviousValue() {
        return String.valueOf(previousValue.getPk());
    }

    @Override
    public Attribute clone() {
        CoreAttribute clone = new CoreAttribute();
        clone.name = name;
        clone.model = model;
        if (value != null)
            clone.value = value.clone();
        if (previousValue != null)
            clone.previousValue = previousValue.clone();
        
        return clone;
    }

    @Override
    public void setValue(ResultSet rs) throws SQLException {
        int pk = rs.getInt(name);
        value = CoreUtil.getCore(model.getName(), pk);
    }

    @Override
    public boolean isUpdated() {
        return !value.equals(previousValue);
    }

    @Override
    public void commitValue() {
        previousValue = value;
    }

    @Override
    public void resetValue() {
        value = previousValue;
    }

    @Override
    public String getStringValue() {
    	try {
    		return String.valueOf(value.getPk());
    	}
    	catch (NumberFormatException e) {
    	}
    	
    	return "";
    }
    
    public Core getValue(){
    	return value;
    }
    
    public void setValue(int pk) throws RegException {
        value = CoreUtil.getCore(model.getName(), pk);
    }

	public void setValue(Core core) throws RegException {
		value = core;
	}

	public void setValue(String value) throws RegException {
		
	}
    
	public ArrayList<Core> search(String substring) {
	    return CoreUtil.search(model.getName(), substring);
	}
	
    @Override
    public boolean contains(String substring) {
        return value.contains(substring);
    }
}
