package view.gui.content;

import model.Asset;
import model.Session;
import model.User;

public class AssetTable extends Table {
	protected User user;
	
	public AssetTable(){
		user = Session.currentUser();
	}
	
	public Object GetSelected() {
		return null;
	}

	public void Initialize() {
		
	}
}
