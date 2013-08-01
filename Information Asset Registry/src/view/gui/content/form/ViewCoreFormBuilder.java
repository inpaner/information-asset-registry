package view.gui.content.form;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;

import model.Core;

import org.jdesktop.swingx.JXDatePicker;

import view.gui.content.Content;
import view.gui.content.CoreForm;
import view.gui.content.form.field.Field;

public class ViewCoreFormBuilder extends AddCoreFormBuilder{
	
	public ViewCoreFormBuilder(Core core){
		super(core);
	}
	
	@Override
	public Content buildContent() {
		content = super.buildContent();
		setFieldsEditable(false);			
		return content;
	}
	
	@SuppressWarnings("rawtypes")
	protected void setFieldsEditable(boolean editable) {
		CoreForm form = (CoreForm)content;
		ArrayList<Field>fields = form.getFields();
		for (Field field : fields){
			field.initialize();	
			field.setEditable(editable);
		}
	}
	
}
