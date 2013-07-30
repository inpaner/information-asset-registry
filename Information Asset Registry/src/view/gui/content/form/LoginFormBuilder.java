package view.gui.content.form;
import model.attribute.CoreAttribute;
import view.gui.content.Content;
import view.gui.content.LoginForm;
import view.gui.content.contentbuilder.FormBuilder;

public class LoginFormBuilder extends FormBuilder{
	
	public LoginFormBuilder() {
		content = new LoginForm();
	}


	/**
	 *  This class creates a login form. However,
	 *  it Given the user, 
	 */
	public Content BuildContent() {
		return content;
	}
	
}
