package model.attribute;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;


import model.Log;
import model.RegException;
import model.db.DBUtil;

import schemacrawler.schema.Column;
import schemacrawler.schema.Table;

public class RestrictedAttribute extends Attribute {
    private PrimaryAttribute value;
    private PrimaryAttribute previousValue;
    private HashMap<Integer, PrimaryAttribute> possibleAttributes;
    
    private RestrictedAttribute() {
    }
    
    RestrictedAttribute(Column column) {
        super(column);
        buildPossibleAttributes(column);
    }
    
    public ArrayList<PrimaryAttribute> getPossibleAttributes() {
        return new ArrayList<>(possibleAttributes.values());
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
                PrimaryAttribute attribute = (PrimaryAttribute) AttributeUtil.build(notPk);
                String notPkValue = rs.getString(notPk.getName().replace("`", ""));
                attribute.forceValue(notPkValue);
                attribute.pk = pk;
                possibleAttributes.put(pk, attribute);
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
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
    public String getSQLValue() {
        return String.valueOf(value.getPk());
    }

    @Override
    public Attribute clone() {
        RestrictedAttribute clone = new RestrictedAttribute();
        clone.name = name;
        if (value != null)
            clone.value = (PrimaryAttribute) value.clone();
        if (previousValue != null)
            clone.previousValue = (PrimaryAttribute) previousValue.clone();
        clone.possibleAttributes = possibleAttributes;
        return clone;
    }

    @Override
    public void setValue(ResultSet rs) throws SQLException {
        int pk = rs.getInt(name);
        value = possibleAttributes.get(pk);
 
    }

    public void setValue(PrimaryAttribute value) throws RegException {
        this.value = value;
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
        return value.getStringValue();
    }

    @Override
    public String getStringPreviousValue() {
        return previousValue.getStringPreviousValue();
    }
    
    public void setValue(int pk) throws RegException {
        value = possibleAttributes.get(pk);
    }

    @Override
    public boolean contains(String substring) {
        return value.contains(substring);
    }

    public PrimaryAttribute getValue() {
        return value;
    }

}
