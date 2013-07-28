package model.attribute;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import everything.DBUtil;

import model.Log;
import model.RegException;

import schemacrawler.schema.Column;
import schemacrawler.schema.Table;

public class RestrictedAttribute extends Attribute {
    private PrimaryAttribute value;
    private PrimaryAttribute replacement;
    private HashMap<Integer, PrimaryAttribute> possibleAttributes;
    
    private RestrictedAttribute() {
    }
    
    RestrictedAttribute(Column column) {
        super(column);
        buildPossibleAttributes(column);
    }
    
    private void buildPossibleAttributes(Column column) {
        possibleAttributes = new HashMap<>();
        Connection conn = DBUtil.newConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Table refTable = column.getReferencedColumn().getParent();
            Column notPk = notPkColumn(refTable);
            ps = conn.prepareStatement(
                    "SELECT pk, " + notPk.getName().replace("`", "") + " " +
                    "FROM " + refTable.getName()
            );             
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                int pk = rs.getInt("pk");
                // Presumes all attributes are primary
                PrimaryAttribute attribute = (PrimaryAttribute) AttributeUtil.build(notPk);
                attribute.forceValue(rs.getString(notPk.getName().replace("`", "")));
                possibleAttributes.put(pk, attribute);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBUtil.close(rs);
            DBUtil.close(ps);
            DBUtil.close(conn);
        }

    }
    
    private Column notPkColumn(Table table) {
        Column notPk = null;
        // gets the first non-pk column
        for (Column column : table.getColumns()) {
            if (column.isPartOfPrimaryKey()) {
                continue;
            }
            notPk = column;
            break;
        }
        
        return notPk;
    }
    
    @Override
    public String getValueString() {
        return value.getValueString();
    }


    @Override
    protected void update() throws RegException {
        // TODO Auto-generated method stub
    }

    @Override
    public Attribute clone() {
        RestrictedAttribute clone = new RestrictedAttribute();
        clone.name = name;
        if (value != null)
            clone.value = (PrimaryAttribute) value.clone();
        if (replacement != null)
            clone.replacement = (PrimaryAttribute) replacement.clone();
        clone.possibleAttributes = possibleAttributes;
        return clone;
    }

    @Override
    public void forceValue(ResultSet rs) throws SQLException {
        int pk = rs.getInt("pk");
        value = possibleAttributes.get(pk);
    }

}
