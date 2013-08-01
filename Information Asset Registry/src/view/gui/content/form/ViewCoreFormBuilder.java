package view.gui.content.form;

import java.util.ArrayList;

import view.gui.content.Content;
import view.gui.content.CoreForm;
import view.gui.content.form.field.Field;
import model.Core;

public class ViewCoreFormBuilder extends AddCoreFormBuilder{
	
	public ViewCoreFormBuilder(Core core){
		super(core);
	}
	
	@Override
	public Content buildContent() {
		content = super.buildContent();
		
		CoreForm form = (CoreForm)content;
		ArrayList<Field>fields = form.getFields();
		for (Field f : fields)
			f.getInput().initialize();
			
		return content;
	}
	
}
