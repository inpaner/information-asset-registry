package view.gui.content.form;

import view.gui.content.AssetForm;
import view.gui.content.Content;
import view.gui.content.Form;
import view.gui.content.contentbuilder.FormBuilder;
import model.Asset;

public class AddAssetFormBuilder extends FormBuilder{
	protected Asset asset;
	
	protected AddAssetFormBuilder(Asset asset) {
		this.asset = asset;
		content = new AssetForm(asset);
		// TODO Auto-generated constructor stub
	}


	/**
	 *  Using the asset, determine the
	 * attributes it has and start to
	 * create multiple fields using the
	 * FieldFactory, and add it into the
	 * content file to be returned.
	 */
	public Content BuildContent() {
		
		return content;
	}
	
}
