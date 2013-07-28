package view.gui.content.form;

import view.gui.content.Content;
import model.Asset;

public class EditAssetFormBuilder extends ViewAssetFormBuilder{
	
	protected EditAssetFormBuilder(Asset asset){
		super(asset);
	}
	
	@Override
	public Content BuildContent() {
		return content;
	}
	
}