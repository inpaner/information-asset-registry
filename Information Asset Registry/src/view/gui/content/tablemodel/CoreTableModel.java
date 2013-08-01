package view.gui.content.tablemodel;
import javax.swing.table.DefaultTableModel;

public class CoreTableModel extends DefaultTableModel  {
	private String[] columnNames = {"col1", "col2", "col3"};
	private String[][] rowData;
	
	public CoreTableModel(){
		rowData = new String[2][3];
		
		for (int i = 0; i < 2; i++){
			rowData[i][0] = "a";
			rowData[i][1] = "b";
			rowData[i][2] = "c";
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
