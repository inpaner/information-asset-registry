package view.gui.content.form;

import view.gui.content.Content;
import model.Core;

public class EditAssetFormBuilder extends ViewAssetFormBuilder{
	
	public EditAssetFormBuilder(Core core){
		super(core);
	}
	
	@Override
	public Content BuildContent() {
		super.BuildContent();
		return content;
	}
	
}
