package view.gui.content;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import view.View;
import view.gui.content.tablemodel.CoreTableModel;
import model.Core;
import model.Session;
import model.User;

public class CoreTable extends Table {
	protected User user;
	private Core core;
	
	public CoreTable(Core core){
		this.user = Session.currentUser();
		this.core = core;
	}
	
	public Object GetSelected() {
		return null;
	}

	public void Initialize() {
		CoreTableModel tableModel = new CoreTableModel(core);
		JTable table = new JTable(tableModel);
		JScrollPane pane = new JScrollPane(table);
		pane.setPreferredSize(View.FrameDimension);
		add(pane);
	}
}
