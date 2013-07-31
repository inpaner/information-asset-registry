package controller;

import model.Session;
import view.View;

public class Driver{
	public static View view;
    
    public static void main(String[] args) {
    	new Driver();
    }
    
    public Driver (){
        Session session = new Session();
        new MainController();
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
