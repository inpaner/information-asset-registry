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


public class LogInFrame extends View  {
	/**
	 * Create the frame.
	 */
	public LogInFrame(LoginListener loginListener) {
		super();
		setPanel(new LoginPageBuilder(Session.currentUser(), loginListener));
	}
	
	public void HandleException(RegException e){
		LoginForm form = ((LoginForm)this.currentPage.getContent());
		ArrayList<Field> fields = form.getFields();
		
		if (e.getMessage().equals("Unregistered username")){
			fields.get(0).getErrorHandling().setText(e.getMessage());
		}else if (e.getMessage().equals("Invalid password")){
			fields.get(1).getErrorHandling().setText(e.getMessage());
		}
	}
}
