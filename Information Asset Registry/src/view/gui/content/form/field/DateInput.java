package view.gui.content.form.field;
import javax.swing.JComboBox;

import org.jdesktop.swingx.JXDatePicker;

import model.attribute.DateAttribute;
import model.attribute.RestrictedAttribute;

public class DateInput extends Input{
		
	public DateInput(RestrictedAttribute attribute){
		super(attribute);
		component = new JComboBox<String>();
	}
	
	public DateInput(DateAttribute attribute) {
        super(attribute);
		component = new JXDatePicker();
	}

    public void initialize() {
		
	}

	public void setInput() {
		// TODO Auto-generated method stub

	}
	
}
