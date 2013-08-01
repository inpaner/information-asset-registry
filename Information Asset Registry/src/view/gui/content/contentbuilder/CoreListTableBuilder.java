package view.gui.content.contentbuilder;

import java.util.ArrayList;

import view.gui.content.CoreForm;
import view.gui.content.CoreTable;
import view.gui.content.Content;
import view.gui.content.tablemodel.CoreTableModel;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import model.Core;
import model.CoreUtil;
import model.Session;
import model.User;
import model.attribute.Attribute;

public class CoreListTableBuilder extends TableBuilder{
	protected User user;
	private Core core;
	
	
	protected CoreListTableBuilder(Core core) {
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
	public Content BuildContent() {
		CoreTable content = new CoreTable();
		JTable table = new JTable();
		
		
		TableModel tableModel = new CoreTableModel(core);
		
		table.setModel(tableModel);
		content.Initialize();
		
		return content;
	}


	public void InitializeTableContents() {
		
	}
	
}
