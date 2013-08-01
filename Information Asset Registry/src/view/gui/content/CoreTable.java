package view.gui.content;

import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import view.View;
import view.gui.content.tablemodel.CoreTableModel;
import model.Core;
import model.CoreUtil;
import model.Session;
import model.User;

public class CoreTable extends Table {
	protected User user;
	private ArrayList<Core> core;
	private CoreTableModel tableModel;
	private JTable table;
	
	public CoreTable(ArrayList<Core> cores){
		this.user = Session.currentUser();
		this.core = cores;
	}
	
	public Core getSelected() {
		return tableModel.getSelected(table);
	}

	public void initialize() {
		tableModel = new CoreTableModel(core);
		table = new JTable(tableModel);
		JScrollPane pane = new JScrollPane(table);
		pane.setPreferredSize(View.FrameDimension);
		add(pane);
	}
}
