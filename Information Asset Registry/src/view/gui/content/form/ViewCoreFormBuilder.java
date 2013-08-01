package view.gui.content.form;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;

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
		setFieldsEditable(false);			
		return content;
	}
	
	protected void setFieldsEditable(boolean b){
		CoreForm form = (CoreForm)content;
		ArrayList<Field>fields = form.getFields();
		for (Field f : fields){
			f.getInput().initialize();
			JComponent component = f.getInput().getComponent();
			
			// Disable
			if (component instanceof JTextField){
				((JTextField) component).setEditable(b); 
			}else if (component instanceof JComboBox){
				((JComboBox) component).setEnabled(b);
			}else if (component instanceof JXDatePicker){
				((JXDatePicker) component).setEditable(b);
			}
		}
	}
	
}
