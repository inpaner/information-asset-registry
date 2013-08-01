package view.gui.content.form;

import view.gui.content.Content;
import model.Core;

public class EditCoreFormBuilder extends ViewCoreFormBuilder{
	
	public EditCoreFormBuilder(Core core){
		super(core);
	}
	
	@Override
	public Content BuildContent() {
		super.BuildContent();
		return content;
	}
	
}
