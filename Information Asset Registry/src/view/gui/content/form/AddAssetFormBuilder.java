package view.gui.content.form;

import view.gui.content.CoreForm;
import view.gui.content.Content;
import view.gui.content.Form;
import view.gui.content.contentbuilder.FormBuilder;
import model.Core;

public class AddAssetFormBuilder extends FormBuilder{
	protected Core core;
	
	public AddAssetFormBuilder(Core core) {
		this.core = core;
		content = new CoreForm(core);
		// TODO Auto-generated constructor stub
	}

	
}
