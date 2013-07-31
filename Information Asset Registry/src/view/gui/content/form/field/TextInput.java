package view.gui.content.form.field;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import model.RegException;
import model.attribute.StringAttribute;

public class TextInput extends Input{
	
	public TextInput(StringAttribute attribute){
		super(attribute);
		component = new JTextField();
		component.setPreferredSize(Input.TextInputDimension);
	}
	
	public void Initialize() {
		
	}

	public boolean setInput() throws RegException{
		String value = ((JTextField)component).getText();
		((StringAttribute)attribute).setValue(value);
		return true;
	}
	
}
