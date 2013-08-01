package view.gui.content.form.field;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;

import model.RegException;
import model.attribute.PrimaryAttribute;
import model.attribute.RestrictedAttribute;

public class ComboInput extends Input{
	private RestrictedAttribute attribute;
	private JComboBox<PrimaryAttribute> comboBox;
	
	public ComboInput(RestrictedAttribute attribute){
		super(attribute);
		this.attribute = attribute;
		component = comboBox = new JComboBox<>();
		for (PrimaryAttribute possible : attribute.getPossibleAttributes()) {
		    comboBox.addItem(possible);
		}
	}
	
	public void initialize() {
		comboBox.setSelectedItem(attribute.getValue());
	}

	@Override
	public void setInput() throws RegException {
        attribute.setValue((PrimaryAttribute) comboBox.getSelectedItem());
	}

    @Override
    public void setEditable(boolean editable) {
        comboBox.setEditable(editable);
        comboBox.setEnabled(editable);
    }
	
}
