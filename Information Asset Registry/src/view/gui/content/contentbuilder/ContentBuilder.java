package view.gui.content.contentbuilder;

import model.Asset;
import model.User;
import view.gui.content.AssetForm;
import view.gui.content.Content;
import view.gui.content.LoginForm;
import view.gui.content.form.AddAssetFormBuilder;
import view.gui.content.form.EditAssetFormBuilder;
import view.gui.content.form.LoginFormBuilder;
import view.gui.content.form.ViewAssetFormBuilder;

public abstract class ContentBuilder {
	protected Content content;
	public abstract Content BuildContent();
	
	public static LoginForm BuildLoginForm(User user) {
		LoginFormBuilder builder = new LoginFormBuilder(user);
		return (LoginForm)builder.BuildContent();
	} 
	
	public static AssetForm BuildAddForm(Asset asset){
		AddAssetFormBuilder builder = new AddAssetFormBuilder(asset);
		return (AssetForm)builder.BuildContent();
	}
	
	public static AssetForm BuildEditForm(Asset asset){
		EditAssetFormBuilder builder = new EditAssetFormBuilder(asset);
		return (AssetForm)builder.BuildContent();
	}
	
	public static AssetForm BuildViewForm(Asset asset){
		ViewAssetFormBuilder builder = new ViewAssetFormBuilder(asset);
		return (AssetForm)builder.BuildContent();
	}
}
