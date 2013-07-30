package view.gui.content;
import model.User;

public class LoginForm extends Form {
	protected User user;
	
	/**
	 * This class does not ask for a User object
	 * because in the first place, it does not
	 * know which user is going to be logged in.
	 */
	public LoginForm (){
	}
	
	public void Reset() {
		
	}

	public void Initialize() {
		/* TODO This allows you to
		 * load the information of
		 * the asset
		 */
	}
	
	public boolean Validate(){
		return false;
	}
	
}
