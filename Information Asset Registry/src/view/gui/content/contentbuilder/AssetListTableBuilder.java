package view.gui.content.contentbuilder;

import view.gui.content.AssetForm;
import view.gui.content.Content;
import model.Asset;
import model.User;

public class AssetListTableBuilder extends TableBuilder{
	protected User user;
	
	protected AssetListTableBuilder(User user) {
		this.user = user;
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
		
		return content;
	}


	public void InitializeTableContents() {
		
	}
	
}
