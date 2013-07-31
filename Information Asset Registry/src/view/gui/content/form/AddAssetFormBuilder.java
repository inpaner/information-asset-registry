package view.gui.content.form;

import view.gui.content.AssetForm;
import view.gui.content.Content;
import view.gui.content.Form;
import view.gui.content.contentbuilder.FormBuilder;
import model.Asset;

public class AddAssetFormBuilder extends FormBuilder{
	protected Asset asset;
	
	public AddAssetFormBuilder(Asset asset) {
		this.asset = asset;
		content = new AssetForm(asset);
		// TODO Auto-generated constructor stub
	}

	
}
