package controller;


import model.Log;
import model.RegException;
import model.User;
import view.LogInFrame;
import view.eventhandling.LoginEvent;
import view.eventhandling.LoginListener;
import view.gui.page.LoginPageBuilder;

public class LoginController extends Controller implements LoginListener {
    
    protected LoginController() {
    	Driver.view.setPanel(new LoginPageBuilder(this));
    }
    
    /**
     * This function handles the login attempt of the user.
     * Should it fail, An exception is thrown to the login frame to display an error.  
     */
    @Override
    public void loginPerformed(LoginEvent event) {
        try {
        	User user = event.getUser();
            user.login();
            // Success! Go to main frame, where all assets are listed down.
            Log.loggedIn();
            new MainController();
        } 
        catch (RegException e){
            // Handle the error by displaying a message
            
        }
        
    }
}
