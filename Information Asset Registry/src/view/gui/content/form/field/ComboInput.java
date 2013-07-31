package view.gui.content.form.field;
import javax.swing.JComboBox;

import model.attribute.RestrictedAttribute;

public class ComboInput extends Input{
	
	public ComboInput(RestrictedAttribute attribute){
		super(attribute);
		component = new JComboBox<String>();
	}
	
	public void Initialize() {
		
	}
	
}
