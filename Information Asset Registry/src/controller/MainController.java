package controller;

import javax.swing.JOptionPane;

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
        MainController main = new MainController();
        
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
    
    public void display(View view){
    	if (this.view != null)
    		this.view.setVisible(false);
    	
    	this.view = view;
    	this.view.setVisible(true);
    }
    
	public void LoginPerformed(LoginEvent event) {
		if ((user = loginModel.login(event)) != null){
			
			// Go to main frame, where all assets are listed down.
			display(mainFrame);
			this.model = mainFrameModel;
		}

	}
}
