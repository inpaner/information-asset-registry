package view.gui.content.form.field;
import javax.swing.JComboBox;

import model.RegException;
import model.attribute.RestrictedAttribute;

public class ComboInput extends Input{
	
	public ComboInput(RestrictedAttribute attribute){
		super(attribute);
		component = new JComboBox<String>();
	}
	
	public void Initialize() {
		
	}

	@Override
	public boolean setInput() throws RegException {
		// TODO Auto-generated method stub
		return false;
	}
	
}
