package view;
import java.util.ArrayList;

import model.RegException;
import view.eventhandling.LoginListener;
import view.gui.content.Form;
import view.gui.content.form.field.Field;
import view.gui.page.PageBuilder;


public class LogInFrame extends View  {
	/**
	 * Create the frame.
	 */
	public LogInFrame(LoginListener loginListener) {
		super();
		setTitle("Asset management system");
		SelectBuilder( PageBuilder.AssignLoginBuilder(loginListener) );
	}

	public void displayError(RegException e) {
		Form content = (Form)currentPage.getContent();
		ArrayList<Field> fields = content.getFields();
		
	}
}
