package view.gui.content.tablemodel;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Core;
import model.attribute.Attribute;

@SuppressWarnings("serial")
public class CoreTableModel extends DefaultTableModel  {
	private String[] columnNames;
	//private String[][] rowData;
	private ArrayList<Attribute> attributes;
	private ArrayList<Core> coreList;
	
	@SuppressWarnings("rawtypes")
	Class[] columnTypes;
	
	public CoreTableModel(ArrayList<Core> cores){
		super();
		if (cores.size() <= 0) return;
		attributes = cores.get(0).getAttributes();
		coreList = cores;
		
		// Table definition
		int col = attributes.size();
		//int row = coreList.size();
		
		// Column definition
		columnNames = new String[col];
		
		// Space for data
		//rowData = new String[row][col];
		
		// Initialize column names
		columnTypes = new Class[col];
		
		
		int i = 0; 
		for (Attribute a : attributes){
			columnNames[i] = a.getName();
			columnTypes[i] = String.class;
			i++;
		}
		
		setColumnIdentifiers(columnNames);
		
		// Initialize data
		for (int k = 0; k < coreList.size(); k++){
			String[] rowData = new String[columnNames.length];
			
			for (int j = 0; j < columnNames.length; j++){
				rowData[j] = coreList.get(k).getAttributes().get(j).getStringValue();
			}
			
			addRow(rowData);
		}
		
	}

	public String getColumnName(int index){
		return columnNames[index];
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Class getColumnClass(int columnIndex) {
		return columnTypes[columnIndex];
	}
    
    public boolean isCellEditable(int row, int col) { 
        return false; 
    }

	public Core getSelected(JTable table) {
		int selectedRow = table.getSelectedRow();
		
		// Check if a row has been selected
		if (selectedRow != -1) {
			return coreList.get(table.getSelectedRow());
		}
		
		return null;
	}
    
}
