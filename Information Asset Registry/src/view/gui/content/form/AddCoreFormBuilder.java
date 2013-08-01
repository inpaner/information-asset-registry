package view.gui.content.form;

import view.gui.content.CoreForm;
import view.gui.content.Content;
import view.gui.content.Form;
import view.gui.content.contentbuilder.FormBuilder;
import view.gui.content.form.field.Field;
import model.Core;
import model.attribute.Attribute;

public class AddCoreFormBuilder extends FormBuilder{
	protected Core core;
	
	public AddCoreFormBuilder(Core core) {
		this.core = core;
		content = new CoreForm(core);
		// TODO Auto-generated constructor stub
	}
	
	   @Override
	    public Content buildContent() {
	       CoreForm content = (CoreForm) this.content;
	       
	       for (Attribute attribute : core.getAttributes()) {
	           Field field = Field.buildField(attribute);
	           field.addTo(content);
	       }
	       
	       return content;
	    }
}
