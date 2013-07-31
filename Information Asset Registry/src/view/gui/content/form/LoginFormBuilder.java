package view.gui.content.form;
import model.attribute.AttributeUtil;
import model.attribute.StringAttribute;
import view.gui.content.Content;
import view.gui.content.LoginForm;
import view.gui.content.contentbuilder.FormBuilder;
import view.gui.content.form.field.Field;

public class LoginFormBuilder extends FormBuilder{
	
	public LoginFormBuilder() {
		content = new LoginForm();
	}


	/**
	 *  This class creates a login form. 
	 */
	public Content BuildContent() {
		Field field;
		
		// Username
		field = Field.BuildField(AttributeUtil.genericAttribute());
		field.addTo(content);
		
		// Password
		field = Field.BuildField(AttributeUtil.genericAttribute());
		field.addTo(content);
		
		return content;
	}
	
}
