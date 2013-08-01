package view.gui.content.form.field;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import org.jdesktop.swingx.combobox.ListComboBoxModel;

import model.Core;
import model.CoreUtil;
import model.RegException;
import model.attribute.CoreAttribute;
import model.attribute.StringAttribute;

public class TextInput extends Input{
	
	JComboBox jComboBox;
	JTextField jTextField;
	
	StringAttribute stringAttribute;
	CoreAttribute coreAttribute;
	
	public TextInput(StringAttribute attribute){
		super(attribute);
		stringAttribute = attribute;
		component = jTextField = new JTextField();
		component.setPreferredSize(Input.textInputDimension);
	}
	
	public TextInput(CoreAttribute attribute){
		super(attribute);
		coreAttribute = attribute;
		component = jComboBox = new JComboBox<String>();
		AutoCompleteDecorator.decorate(jComboBox);
		
		component.setPreferredSize(Input.textInputDimension);
	}
	public void initialize() {
		if (attribute instanceof StringAttribute){
			jTextField.setText(((StringAttribute) attribute).getValue());
			
			
			
		}else{
			Core core = coreAttribute.getValue();
			List<Core> list = java.util.Collections.unmodifiableList(CoreUtil.getAll(core.getName()));
			jComboBox.setModel(new ListComboBoxModel<Core>(list));
			jComboBox.setSelectedItem(core);
		}
	}

	public void setInput() throws RegException{
		String value = jTextField.getText();
		
		if (attribute instanceof StringAttribute)
			((StringAttribute)attribute).setValue(value);
		else
			((CoreAttribute)attribute).setValue(value);
	}

    @Override
    public void setEditable(boolean editable) {
        jComboBox.setEnabled(editable);
    }
	
}
