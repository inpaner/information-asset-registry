package view.gui.content.form.field;
import java.awt.Dimension;

import javax.swing.JComponent;

import model.Core;
import model.RegException;
import model.attribute.Attribute;
import model.attribute.CoreAttribute;
import model.attribute.DateAttribute;
import model.attribute.RestrictedAttribute;
import model.attribute.StringAttribute;

public abstract class Input {
	protected JComponent component;
	protected Attribute attribute;
	public static final Dimension textInputDimension = new Dimension(200, 20);
	public static final Dimension comboBoxInputDimension = new Dimension(150, 30);
	
	public abstract void setInput() throws RegException;

	public Input(){
	}

	
	public static Input createInput(Attribute attribute) {
		if (attribute instanceof RestrictedAttribute)
			return new ComboInput((RestrictedAttribute) attribute);
		
		if (attribute instanceof StringAttribute)
			return new TextInput((StringAttribute) attribute);
		if (attribute instanceof DateAttribute)
		    return new DateInput((DateAttribute) attribute);
		if (attribute instanceof CoreAttribute)
			return new TextInput((CoreAttribute) attribute);
		
		return null;
	}
	
	
	public Input(Attribute attribute) {
		this.attribute = attribute;
	}
	
	/**
	 * This method prepares the field for what kind of
	 * JComponent it will be, and what initial values 
	 * it will have.
	 */
	public abstract void initialize();
	public abstract void setEditable(boolean editable);
	
	public JComponent getComponent() {
		if (component == null){
			
		}
		return component;
	}


}
