package view.gui.content.form;

import view.gui.content.Content;
import model.Core;

public class ViewCoreFormBuilder extends AddCoreFormBuilder{
	
	public ViewCoreFormBuilder(Core core){
		super(core);
	}
	
	@Override
	public Content buildContent() {
		content = super.buildContent();
		return content;
	}
	
}
