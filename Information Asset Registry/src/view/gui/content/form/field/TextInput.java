package view.gui.content.form.field;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JPasswordField;
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
		if (stringAttribute.getName().contains("password") || stringAttribute.getName().startsWith("pw") || stringAttribute.getName().endsWith("pw"))
		{
			component = jTextField = new JPasswordField();
		}else
		{
			component = jTextField = new JTextField();
		}
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
		jTextField.setText(((StringAttribute) attribute).getValue());
	}

	public void setInput() throws RegException{
		String value = jTextField.getText();
	    stringAttribute.setValue(value);
	}

    @Override
    public void setEditable(boolean editable) {
        jTextField.setEditable(editable);
    }
	
}
