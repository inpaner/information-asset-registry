package controller;

import model.Session;
import view.View;
import view.gui.page.LoginPageBuilder;

public class Driver{
	public static View view;
    
    public static void main(String[] args) {
    	new Driver();
    }
    
    public Driver (){
        
        // new LoginController();
        
        // new MainController();
    	Session session = new Session();
    	view = new View();
    	Controller controller = new MainController();
    	// Controller controller = new LoginController(); 
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
