package view.gui.content.contentbuilder;

import java.util.ArrayList;

import view.gui.content.CoreTable;
import view.gui.content.Content;
import view.gui.content.tablemodel.CoreTableModel;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import model.Core;
import model.Session;
import model.User;

public class CoreListTableBuilder extends TableBuilder{
	protected User user;
	private ArrayList<Core> core;
	
	
	protected CoreListTableBuilder(ArrayList<Core> core) {
		this.user = Session.currentUser();
		this.core = core;
	}


	/**
	 *  Using the user, this method begins
	 *  collecting the assets that the user
	 *  has access to, which is specifically
	 *  the assets that the user owns (Owner)
	 *  and the asset that the user has in 
	 *  his or her custody (Custodian).
	 *  
	 *  This method creates the table
	 */
	public Content buildContent() {
		CoreTable content = new CoreTable(core);
		content.initialize();
		return content;
	}


	public void initializeTableContents() {
		
	}
	
}
