package view.gui.content.contentbuilder;

import view.gui.content.CoreForm;
import view.gui.content.CoreTable;
import view.gui.content.Content;
import view.gui.content.tablemodel.AssetTableModel;

import javax.swing.JTable;

import model.Asset;
import model.Session;
import model.User;

public class AssetListTableBuilder extends TableBuilder{
	protected User user;
	
	protected AssetListTableBuilder() {
		this.user = Session.currentUser();
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
		table.setModel(new CoreTableModel());
		content.Initialize();
		return content;
	}


	public void InitializeTableContents() {
		
	}
	
}
