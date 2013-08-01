package view.gui.content.form.field;
import java.awt.Dimension;

import javax.swing.JComponent;

import model.RegException;
import model.attribute.Attribute;
import model.attribute.CoreAttribute;
import model.attribute.DateAttribute;
import model.attribute.RestrictedAttribute;
import model.attribute.StringAttribute;

public abstract class Input {
	protected JComponent component;
	protected Attribute attribute;
	public static final Dimension TextInputDimension = new Dimension(200, 25);
	public static final Dimension ComboBoxInputDimension = new Dimension(150, 30);
	
	public abstract void setInput() throws RegException;
	
	public static Input CreateInput(Attribute attribute) {
		if (attribute instanceof RestrictedAttribute)
			return new ComboInput((RestrictedAttribute) attribute);
		
		if (attribute instanceof StringAttribute)
			return new TextInput((StringAttribute) attribute);
		if (attribute instanceof DateAttribute)
		    return new DateInput((DateAttribute) attribute);
		if (attribute instanceof CoreAttribute)
			return null;
		
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
	public abstract void Initialize();
	
	public JComponent getComponent() {
		return component;
	}

}
