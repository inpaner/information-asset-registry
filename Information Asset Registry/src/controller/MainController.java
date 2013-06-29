package controller;

import view.LogInFrame;
import view.LoginEvent;
import view.LoginListener;
import view.MainFrame;
import view.View;
import view.ViewAssetFrame;
import model.LoginModel;
import model.MainFrameModel;
import model.Model;
import model.bean.User;

public class MainController implements LoginListener{
	
	// current logged in user
    private User user;
    
    // current settings
    private Model model;
    private View view;
    
    // views
    private LogInFrame loginFrame = new LogInFrame();
    private MainFrame mainFrame = new MainFrame();
    private ViewAssetFrame viewAssetFrame = new ViewAssetFrame();
    
    // models 
    private LoginModel loginModel = new LoginModel();
    private MainFrameModel mainFrameModel = new MainFrameModel();
    
    public static void main(String[] args) {
        new MainController();
    }
    
    public MainController (){
        prepareForLogin();
    }
    
    private void prepareForLogin() {
    	// Create a new model that will handle the data
    	this.model = loginModel;
    	
    	// Go to log in screen, where you can... well duh
    	display(loginFrame);
        loginFrame.setLoginListener(this);
    }
    
    /**
     * This function begins by hiding the current view, updating the current view, and finally displays the selected view.
     * @param view - The frame that you wish to display
     */
    public void display(View view){
    	if (this.view != null)
    		this.view.setVisible(false);
    	
    	this.view = view;
    	this.view.setVisible(true);
    }
    
    /**
     * This function handles the login attempt of the user.
     * Should it fail, An exception is thrown to the login frame to display an error.  
     */
	public void LoginPerformed(LoginEvent event) {
		try {
			user = loginModel.login(event);
			if (user != null){	
				// Success! Go to main frame, where all assets are listed down.
				display(mainFrame);
				this.model = mainFrameModel;
			}
		}catch (Exception e){
			// Handle the error by displaying a message
			loginFrame.displayError(e);
		}

	}
}
