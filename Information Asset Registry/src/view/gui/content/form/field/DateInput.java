package view.gui.content.form.field;
import javax.swing.JComboBox;

import org.jdesktop.swingx.JXDatePicker;

import model.RegException;
import model.attribute.DateAttribute;
import model.attribute.RestrictedAttribute;

public class DateInput extends Input{
	DateAttribute attribute;
	JXDatePicker datePicker;
    
	public DateInput(DateAttribute attribute) {
        super(attribute);
        this.attribute = attribute;
        component = datePicker = new JXDatePicker();
	}

    public void initialize() {
		
	}

	public void setInput() throws RegException {
		attribute.setValue(datePicker.getDate());
	}

    @Override
    public void setEditable(boolean editable) {
        datePicker.setEditable(editable);
    }
	
}
