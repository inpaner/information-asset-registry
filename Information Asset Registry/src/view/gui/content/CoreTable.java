package view.gui.content;

import model.Session;
import model.User;

public class CoreTable extends Table {
	protected User user;
	
	public CoreTable(){
		user = Session.currentUser();
	}
	
	public Object GetSelected() {
		return null;
	}

	public void Initialize() {
		
	}
}
