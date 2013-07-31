package controller;


import model.Log;
import model.RegException;
import model.Session;
import model.User;
import view.LogInFrame;
import view.View;
import view.eventhandling.LoginEvent;
import view.eventhandling.LoginListener;
import view.gui.content.LoginForm;
import view.gui.page.LoginPageBuilder;
import view.gui.page.Page;

public class LoginController extends Controller implements LoginListener {
    
    protected LoginController() {
    	View view = Driver.view;
    	view.setPanel(new LoginPageBuilder(Session.currentUser(), this));
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
            new MainController();
        } 
        catch (RegException e){
        	View view = Driver.view;
        	Page page = view.getCurrentPage();
        	((LoginForm)page.getContent()).HandleException(e);
        }
        
    }
}
