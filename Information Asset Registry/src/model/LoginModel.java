package model;

import model.bean.User;
import view.LoginEvent;

public class LoginModel extends Model {

	public User login(LoginEvent event) throws Exception {
		User user = User.login(event.getUsername(), event.getPassword());
		if (user != null){
			System.out.println("The user: " + user.username() + " was found.");
		}else{
			throw new Exception("There was no such user found.");
		}
		return user;
	}
	
}
