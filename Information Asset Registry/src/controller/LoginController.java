package model;

import model.bean.User;
import view.eventhandling.LoginEvent;

public class LoginModel extends Model {

	public User login(LoginEvent event) throws Exception {
		User user = User.login(event.getUsername(), event.getPassword());
		if (user != null){
			System.out.println("The user: " + user.username() + " was found.");
		}else{
			/*
			 * TODO
			 * Instead of having an extremely vague error message like
			 * "The login was invalid", there can be different exceptions 
			 * thrown, such as
			 * 
			 * a) The username was not a valid registered user. 
			 * b) The password was invalid.
			 */
			throw new Exception("The login was invalid.");
		}
		return user;
	}
	
}
