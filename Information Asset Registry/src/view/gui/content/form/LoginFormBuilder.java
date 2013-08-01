package view.gui.content.form;
import model.User;
import view.gui.content.Content;
import view.gui.content.LoginForm;
import view.gui.content.contentbuilder.FormBuilder;
import view.gui.content.form.field.Field;

public class LoginFormBuilder extends FormBuilder{
	private User user;
	
	public LoginFormBuilder(User user) {
		content = new LoginForm();
		this.user = user;
	}


	/**
	 *  This class creates a login form. 
	 */
	public Content buildContent() {
		Field field;
		LoginForm content = (LoginForm)this.content;
		
		// Username
		field = Field.buildField(user.getUsername());
		field.addTo(content);
		
		// Password
		field = Field.buildField(user.getPassword());
		field.addTo(content);
		
		return content;
	}
	
}
