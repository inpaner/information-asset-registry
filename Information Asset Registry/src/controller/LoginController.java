package controller;


import model.Log;
import model.RegException;
import model.Session;
import model.User;
import view.LogInFrame;
import view.eventhandling.LoginEvent;
import view.eventhandling.LoginListener;
import view.gui.page.LoginPageBuilder;

public class LoginController extends Controller implements LoginListener {
    User user;
    LogInFrame loginFrame;
    
    public LoginController() {
    	 loginFrame = new LogInFrame(this);
    	 user = Session.currentUser();
    }
    
    /**
     * This function handles the login attempt of the user.
     * Should it fail, An exception is thrown to the login frame to display an error.  
     */
    
    @Override
    public void loginPerformed(LoginEvent event) {
        try {
        	user.login();
            // Success! Go to main frame, where all assets are listed down.
            Log.loggedIn();
            new MainController();
        } 
        catch (RegException e){
        	loginFrame.HandleException(e);
        	
        }
    }
}
