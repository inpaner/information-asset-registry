package view.gui.content.contentbuilder;

import java.util.ArrayList;

import model.Core;
import model.Log;
import model.User;
import view.gui.content.Content;
import view.gui.content.CoreForm;
import view.gui.content.CoreTable;
import view.gui.content.LogTable;
import view.gui.content.LoginForm;
import view.gui.content.form.AddCoreFormBuilder;
import view.gui.content.form.EditCoreFormBuilder;
import view.gui.content.form.LoginFormBuilder;
import view.gui.content.form.ViewCoreFormBuilder;

public abstract class ContentBuilder {
	protected Content content;
	public abstract Content buildContent();
	
	public static LoginForm buildLoginForm(User user) {
		LoginFormBuilder builder = new LoginFormBuilder(user);
		return (LoginForm)builder.buildContent();
	} 
	
	public static CoreForm buildAddForm(Core core){
		AddCoreFormBuilder builder = new AddCoreFormBuilder(core);
		return (CoreForm)builder.buildContent();
	}
	
	public static CoreForm buildEditForm(Core core){
		EditCoreFormBuilder builder = new EditCoreFormBuilder(core);
		return (CoreForm)builder.buildContent();
	}
	
	public static CoreForm buildViewForm(Core core){
		ViewCoreFormBuilder builder = new ViewCoreFormBuilder(core);
		return (CoreForm)builder.buildContent();
	}

	public static CoreTable buildAssetList(ArrayList<Core> core) {
		CoreListTableBuilder builder = new CoreListTableBuilder(core);
		return (CoreTable)builder.buildContent();
	}
	
	public static LogTable buildLogList(ArrayList<Log> logs) {
		LogTableBuilder builder = new LogTableBuilder(logs);
		return (LogTable) builder.buildContent();
	}
}
