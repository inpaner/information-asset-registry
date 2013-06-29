package view.eventhandling;

public class LoginEvent {
	private String username;
	private char[] password;
	
	public LoginEvent(String username, char[] password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public char[] getPassword() {
		return password;
	}


}
