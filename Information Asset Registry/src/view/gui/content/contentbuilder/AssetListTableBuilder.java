package view.gui.content.contentbuilder;

import view.gui.content.AssetForm;
import view.gui.content.AssetTable;
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
		AssetTable content = new AssetTable();
		
		JTable table = new JTable();
		table.setModel(new AssetTableModel());
		content.Initialize();
		return content;
	}


	public void InitializeTableContents() {
		
	}
	
}
