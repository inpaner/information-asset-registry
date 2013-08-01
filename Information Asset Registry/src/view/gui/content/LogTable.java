package view.gui.content;

import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Core;
import model.Log;
import model.Session;
import model.User;
import view.View;
import view.gui.content.tablemodel.LogTableModel;

public class LogTable extends Table {
	
	protected User user;
	private ArrayList<Log> logs;
	private LogTableModel tableModel;
	private JTable table;
	
	public LogTable(ArrayList<Log> logs) {
		this.user = Session.currentUser();
		this.logs = logs;
	}

	@Override
	public void initialize() {
		tableModel = new LogTableModel(logs);
		table = new JTable(tableModel);
		JScrollPane jsp = new JScrollPane(table);
		jsp.setPreferredSize(View.FrameDimension);
		this.add(jsp);
		
	}

	@Override
	public Core getSelected() {
		return null;
	}

}
