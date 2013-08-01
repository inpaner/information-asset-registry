package view.gui.content.tablemodel;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.Log;

@SuppressWarnings("serial")
public class LogTableModel extends DefaultTableModel {
	
	private String[] columnNames;
	
	public LogTableModel(ArrayList<Log> logs) {
		super();
		
		columnNames = new String[] {
				"Time",
				"Event"
		};
		
		this.setColumnIdentifiers(columnNames);
		
		// Initialize data
		for (int k = 0; k < logs.size(); k++){
			String[] rowData = new String[columnNames.length];
			
			rowData[0] = logs.get(k).timestamp().toGMTString();
			rowData[1] = logs.get(k).plaintext();
			
			addRow(rowData);
		}
	}
    
    public boolean isCellEditable(int row, int col) { 
        return false; 
    }
}
