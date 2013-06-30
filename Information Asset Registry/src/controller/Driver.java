package controller;

import view.View;
import model.bean.User;

public class Driver{
	
	// current logged in user
    private User user;
    
    // current settings
    public static View view;
    public static Controller controller;
    
    // controller
    public static LoginController loginController = new LoginController();
    public static MainController menuController = new MainController();
    
    public static void main(String[] args) {
    	// Begin the application
        new Driver();
    }
    
    public Driver (){
    	// When you start the application, begin by logging in.
        Login();
    }
    
    protected void Login() {
    	// Create the new login controller.
    	changeControls(loginController);
    }
    
    protected void BeginApplication(User user){
    	this.user = user;
    	changeControls(menuController);
    }
    
    public static void changeControls(Controller control){
    	controller = control;
    	controller.initialize();
    }
    
    /**
     * This function begins by hiding the current view, updating the current view, and finally displays the selected view.
     * @param replacement - The frame that you wish to display
     */
    public static void display(View replacement){
    	if (view != null)
    		view.setVisible(false);
    	
    	view = replacement;
    	view.setVisible(true);
    }


}
