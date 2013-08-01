package view.gui.content.contentbuilder;

import model.Core;
import model.User;
import view.eventhandling.CoreListener;
import view.gui.content.CoreForm;
import view.gui.content.CoreTable;
import view.gui.content.Content;
import view.gui.content.LoginForm;
import view.gui.content.form.AddCoreFormBuilder;
import view.gui.content.form.EditCoreFormBuilder;
import view.gui.content.form.LoginFormBuilder;
import view.gui.content.form.ViewCoreFormBuilder;
import view.gui.page.CoreListPageBuilder;

public abstract class ContentBuilder {
	protected Content content;
	public abstract Content BuildContent();
	
	public static LoginForm BuildLoginForm(User user) {
		LoginFormBuilder builder = new LoginFormBuilder(user);
		return (LoginForm)builder.BuildContent();
	} 
	
	public static CoreForm BuildAddForm(Core core){
		AddCoreFormBuilder builder = new AddCoreFormBuilder(core);
		return (CoreForm)builder.BuildContent();
	}
	
	public static CoreForm BuildEditForm(Core core){
		EditCoreFormBuilder builder = new EditCoreFormBuilder(core);
		return (CoreForm)builder.BuildContent();
	}
	
	public static CoreForm BuildViewForm(Core core){
		ViewCoreFormBuilder builder = new ViewCoreFormBuilder(core);
		return (CoreForm)builder.BuildContent();
	}

	public static CoreTable BuildAssetList(Core core) {
		CoreListTableBuilder builder = new CoreListTableBuilder(core);
		return (CoreTable)builder.BuildContent();
	}
}
