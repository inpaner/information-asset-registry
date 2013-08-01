package view.gui.content.tablemodel;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.Core;
import model.CoreUtil;
import model.attribute.Attribute;

public class CoreTableModel extends DefaultTableModel  {
	private String[] columnNames;
	private String[][] rowData;
	private ArrayList<Attribute> attributes;
	private ArrayList<Core> coreList;
	
	public CoreTableModel(Core core){
		attributes = core.getAttributes();
		
		coreList = CoreUtil.getAll(core.getName());
		
		// Table definition
		int col = attributes.size();
		int row = coreList.size();
		
		// Column definition
		columnNames = new String[col];
		
		// Space for data
		rowData = new String[row][col];
	}
	
	public void Initialize(){
		// Initialize column names
		int i = 0; for (Attribute a : attributes){
			columnNames[i++] = a.getName();
		}
		
		// Initialize data
		for (int k = 0; k < coreList.size(); k++){
			for (int j = 0; j < columnNames.length; j++){
				rowData[k][j] = coreList.get(k).getAttributes().get(j).getStringValue();
			}
		}
		
	}

	public String getColumnName(int col) {
        return columnNames[col].toString();
    }
    public int getRowCount() { return rowData.length; }
    public int getColumnCount() { return columnNames.length; }
    
    public Object getValueAt(int row, int col) {
        return rowData[row][col];
    }
    
    public boolean isCellEditable(int row, int col)
        { return false; }
    
}
