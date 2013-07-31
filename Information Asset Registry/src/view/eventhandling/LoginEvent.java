package view.eventhandling;

import model.User;

public class LoginEvent {
	private User user;
	
	public LoginEvent(User user) {
		super();
		this.user = user;
	}

	public User getUser() {
		return user;
	}


}
