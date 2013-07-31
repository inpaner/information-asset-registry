package view.gui.content.form;
import model.User;
import model.attribute.AttributeUtil;
import model.attribute.StringAttribute;
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
	public Content BuildContent() {
		Field field;
		LoginForm content = (LoginForm)this.content;
		
		// Username
		field = Field.BuildField(user.getUsername());
		field.addTo(content);
		
		// Password
		field = Field.BuildField(user.getPassword());
		field.addTo(content);
		
		return content;
	}
	
}
