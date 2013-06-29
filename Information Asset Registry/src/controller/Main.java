package controller;

import javax.swing.JOptionPane;

import view.LogInFrame;
import view.LoginEvent;
import view.LoginListener;
import model.User;

public class Main implements LoginListener{
    private User user;
    private LogInFrame loginFrame;
    
    public static void main(String[] args) {
        Main main = new Main();
        main.login();
    }
    
    private void login() {
        loginFrame = new LogInFrame();
        loginFrame.setLoginListener(this);
    }
    
	
	public void LoginPerformed(LoginEvent event) {
		user = User.login(event.getUsername(), event.getPassword());
		if (user != null){
			System.out.println("The user: " + user.username() + " was found.");
		}else{
			JOptionPane.showMessageDialog(null, "There was no such user found.");
		}
	}
}
