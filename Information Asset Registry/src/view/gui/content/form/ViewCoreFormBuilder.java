package view.gui.content.form;

import view.gui.content.Content;
import view.gui.content.CoreForm;
import view.gui.content.form.field.Field;
import model.Core;

public class ViewCoreFormBuilder extends AddCoreFormBuilder{
	private Core core;
	
	public ViewCoreFormBuilder(Core core){
		super(core);
		this.core = core;
	}
	
	@Override
	public Content BuildContent() {
		Field field;
		CoreForm content = (CoreForm)this.content;
		
		//asset name not shown
		for(int i = 0; i < core.getAttributes().size(); i++){
			field = Field.BuildField(core.getAttributes().get(i));
			field.addTo(content);
		}
		return content;
	}
	
}
