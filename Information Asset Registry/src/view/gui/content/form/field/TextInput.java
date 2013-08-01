package view.gui.content.form.field;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import model.Core;
import model.RegException;
import model.attribute.CoreAttribute;
import model.attribute.StringAttribute;

public class TextInput extends Input{
	
	public TextInput(StringAttribute attribute){
		super(attribute);
		component = new JTextField();
		component.setPreferredSize(Input.textInputDimension);
	}
	
	public TextInput(Core core){
		
	}
	
	public void initialize() {
		
	}

	public void setInput() throws RegException{
		String value = ((JTextField)component).getText();
		((StringAttribute)attribute).setValue(value);
	}
	
}
