package view.gui.content.contentbuilder;

import model.Core;
import model.User;
import view.eventhandling.AssetListener;
import view.gui.content.CoreForm;
import view.gui.content.CoreTable;
import view.gui.content.Content;
import view.gui.content.LoginForm;
import view.gui.content.form.AddAssetFormBuilder;
import view.gui.content.form.EditAssetFormBuilder;
import view.gui.content.form.LoginFormBuilder;
import view.gui.content.form.ViewAssetFormBuilder;
import view.gui.page.AssetListPageBuilder;

public abstract class ContentBuilder {
	protected Content content;
	public abstract Content BuildContent();
	
	public static LoginForm BuildLoginForm(User user) {
		LoginFormBuilder builder = new LoginFormBuilder(user);
		return (LoginForm)builder.BuildContent();
	} 
	
	public static CoreForm BuildAddForm(Core core){
		AddAssetFormBuilder builder = new AddAssetFormBuilder(core);
		return (CoreForm)builder.BuildContent();
	}
	
	public static CoreForm BuildEditForm(Core core){
		EditAssetFormBuilder builder = new EditAssetFormBuilder(core);
		return (CoreForm)builder.BuildContent();
	}
	
	public static CoreForm BuildViewForm(Core core){
		ViewAssetFormBuilder builder = new ViewAssetFormBuilder(core);
		return (CoreForm)builder.BuildContent();
	}

	public static CoreTable BuildAssetList() {
		AssetListTableBuilder builder = new AssetListTableBuilder();
		return (CoreTable)builder.BuildContent();
	}
}
