package controller;

import view.View;
import model.bean.User;

public class Driver{
	
    // current settings
    public static View view;
    public static Controller controller;
    
    // controller
    public static LoginController loginController;
    public static MainController menuController;
    
    public static void main(String[] args) {
    	// Begin the application
        new Driver();
    }
    
    public Driver (){
        loginController = new LoginController();
        menuController = new MainController();
        
    	// When you start the application, begin by logging in.
        Login();
    }
    
    protected void Login() {
    	// Create the new login controller.
    	changeControls(loginController);
    }
    
    protected void BeginApplication(User user){
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
