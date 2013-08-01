package view.gui.content;

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
	private Core core;
	private CoreTableModel tableModel;
	private JTable table;
	
	public CoreTable(Core core){
		this.user = Session.currentUser();
		this.core = core;
	}
	
	public Core GetSelected() {
		return tableModel.getSelected(table);
	}

	public void Initialize() {
		tableModel = new CoreTableModel(core);
		table = new JTable(tableModel);
		JScrollPane pane = new JScrollPane(table);
		pane.setPreferredSize(View.FrameDimension);
		add(pane);
	}
}
