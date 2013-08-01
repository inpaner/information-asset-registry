package view;
import java.awt.Dimension;
import java.util.ArrayList;

import controller.Driver;
import model.RegException;
import model.Session;
import view.eventhandling.LoginListener;
import view.gui.content.LoginForm;
import view.gui.content.form.field.Field;
import view.gui.page.LoginPageBuilder;
import view.gui.page.PageBuilder;


public class LogInFrame {
	/**
	 * Create the frame.
	 */
	public LogInFrame(LoginListener loginListener) {
		super();
		Driver.view.setPanel(new LoginPageBuilder(Session.currentUser(), loginListener));
	}
	
	public void handleException(RegException e){
		LoginForm form = ((LoginForm)Driver.view.currentPage.getContent());
		ArrayList<Field> fields = form.getFields();
		
		if (e.getMessage().equals("Unregistered username")){
			fields.get(0).getErrorHandling().setText(e.getMessage());
		}
		if (e.getMessage().equals("Invalid password")){
			fields.get(1).getErrorHandling().setText(e.getMessage());
		}
	}
}
