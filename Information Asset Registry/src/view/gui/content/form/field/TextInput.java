package view.gui.content.form.field;
import java.awt.Dimension;

import javax.swing.JTextField;

import model.attribute.StringAttribute;

public class TextInput extends Input{
	
	public TextInput(StringAttribute attribute){
		super(attribute);
		component = new JTextField();
	}
	
	public void Initialize() {
		
	}
	
}
