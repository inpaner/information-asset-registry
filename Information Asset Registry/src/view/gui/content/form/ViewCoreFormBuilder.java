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
			
			//TODO remove code below 
			/*
			JComponent component = field.getInput().getComponent();
			// Disable
			if (component instanceof JTextField){
				((JTextField) component).setEditable(editable); 
			}else if (component instanceof JComboBox){
				((JComboBox) component).setEnabled(editable);
			}else if (component instanceof JXDatePicker){
				((JXDatePicker) component).setEditable(editable);
			}
			*/
		}
	}
	
}
