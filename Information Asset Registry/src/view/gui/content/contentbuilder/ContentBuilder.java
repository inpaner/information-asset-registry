package view.gui.content.contentbuilder;

import view.gui.content.Content;
import view.gui.content.LoginForm;
import view.gui.content.form.LoginFormBuilder;

public abstract class ContentBuilder {
	protected Content content;
	public abstract Content BuildContent();
	
	
	public static LoginForm BuildLoginForm() {
		LoginFormBuilder builder = new LoginFormBuilder();
		return (LoginForm)builder.BuildContent();
	} 
}
