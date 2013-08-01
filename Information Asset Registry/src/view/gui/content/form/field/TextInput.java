package view.gui.content.form.field;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import model.Core;
import model.CoreUtil;
import model.RegException;
import model.attribute.Attribute;
import model.attribute.CoreAttribute;
import model.attribute.StringAttribute;

public class TextInput extends Input{
	
	public TextInput(Attribute attribute){
		super(attribute);
		component = new JTextField();
		component.setPreferredSize(Input.textInputDimension);
	}
	
	public TextInput(Core core){
		
	}
	public void initialize() {
		JTextField txtField = (JTextField)component;
		if (attribute instanceof StringAttribute){
			txtField.setText(((StringAttribute) attribute).getValue());
		}else{
			Core core = ((CoreAttribute) attribute).getValue();
			CoreUtil.getCore(core.getName(), core.getPk());
			txtField.setText(core.getAttributes().get(0).getStringValue());
		}
	}

	public void setInput() throws RegException{
		String value = ((JTextField)component).getText();
		
		if (attribute instanceof StringAttribute)
			((StringAttribute)attribute).setValue(value);
		else
			((CoreAttribute)attribute).setValue(value);
	}
	
}
