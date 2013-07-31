package view.gui.content;
import java.awt.FlowLayout;

import model.RegException;
import model.User;

public class LoginForm extends Form {
	protected User user;
	
	/**
	 * This class does not ask for a User object
	 * because in the first place, it does not
	 * know which user is going to be logged in.
	 */
	public LoginForm (){
		super();
	}
	
	public void Reset() {
		
	}

	public void Initialize() {
	}
	
	public boolean Validate(){
		return false;
	}

	public void HandleException(RegException e) {
		
	}
	
}
