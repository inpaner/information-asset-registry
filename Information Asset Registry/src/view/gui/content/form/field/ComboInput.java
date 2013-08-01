package view.gui.content.form.field;
import javax.swing.JComboBox;

import model.RegException;
import model.attribute.PrimaryAttribute;
import model.attribute.RestrictedAttribute;

public class ComboInput extends Input{
	private RestrictedAttribute attribute;
	private JComboBox<String> comboBox;
	
	public ComboInput(RestrictedAttribute attribute){
		super(attribute);
		this.attribute = attribute;
		component = comboBox = new JComboBox<String>();
		for (PrimaryAttribute possible : attribute.getPossibleAttributes()) {
		    comboBox.addItem(possible.getStringValue());
		}
	}
	
	public void Initialize() {
		
	}

	@Override
	public void setInput() throws RegException {
		attribute.setValue(comboBox.getSelectedIndex());
	}
	
}
