package view.gui.content.form.field;
import javax.swing.JComboBox;

import model.attribute.RestrictedAttribute;

public class DateInput extends Input{
	
	public DateInput(RestrictedAttribute attribute){
		super(attribute);
		component = new JComboBox<String>();
	}
	
	public void Initialize() {
		
	}

	public boolean setInput() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
