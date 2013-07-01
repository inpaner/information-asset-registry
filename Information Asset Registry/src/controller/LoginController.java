package controller;


import model.bean.Log;
import model.bean.RegException;
import model.bean.User;
import view.LogInFrame;
import view.eventhandling.LoginEvent;
import view.eventhandling.LoginListener;

public class LoginController extends Controller implements LoginListener {
    private LogInFrame loginFrame;
    
    
    protected LoginController() {
        loginFrame = new LogInFrame();
        loginFrame.setLoginListener(this);
    }
    
    /**
     * This function handles the login attempt of the user.
     * Should it fail, An exception is thrown to the login frame to display an error.  
     */
    @Override
    public void LoginPerformed(LoginEvent event) {
        try {
            User.login(event.getUsername(), event.getPassword());
            // Success! Go to main frame, where all assets are listed down.
            Driver.changeControls(Driver.menuController);
            Log.loggedIn();
        } 
        catch (RegException e){
            // Handle the error by displaying a message
            loginFrame.displayError(e);
        }
        
    }

	public void initialize() {
		Driver.display(loginFrame);
	}	
}
