package view.gui.content.form.field;
import javax.swing.JComponent;

import model.attribute.Attribute;
import model.attribute.CoreAttribute;
import model.attribute.RestrictedAttribute;
import model.attribute.StringAttribute;

public abstract class Input {
	protected JComponent component;
	protected Attribute attribute;
	
	public static Input CreateInput(RestrictedAttribute attribute){
		/*
		 * In this case, since a restricted attribute was 
		 * passed, the type of input to return would be a 
		 * ComboInput. The input is initialized in the
		 * constructor of the ComboInput.
		 */
		Input input = new ComboInput(attribute);
		return input;
	}
	
	public static Input CreateInput(StringAttribute attribute){
		/*
		 * This needs to vary depending on what kind
		 * of attribute was sent.
		 */
		Input input = null;
		return input;
	}
	
	public static Input CreateInput(CoreAttribute attribute){
		/*
		 * This needs to vary depending on what kind
		 * of attribute was sent.
		 */
		Input input = null;
		return input;
	}
	
	public Input() {}
	
	/**
	 * This method prepares the field for what kind of
	 * JComponent it will be, and what initial values 
	 * it will have.
	 */
	public abstract void Initialize();
	
	public JComponent getComponent() {
		return component;
	}

	public void setComponent(JComponent component) {
		this.component = component;
	}
	
}
