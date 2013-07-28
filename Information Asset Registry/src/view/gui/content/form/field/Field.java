package view.gui.content.form.field;
import javax.swing.JLabel;

import model.Attribute;

public class Field {
	
	protected JLabel Label;
	protected Input input;
	protected JLabel ErrorHandling;
	
	/**
	 * This method creates the necessary field depending on
	 * the type of the attribute passed. This changes the 
	 * input, varying between ComboInput, TextInput, or DateInput
	 * @param attribute - this is the attribute to be turned into a field
	 * @return field - the newly constructed Field object
	 */
	public static Field BuildField(Attribute attribute){
		Field newField = new Field();
		return newField;
	}
	
	/**
	 * The constructor of the field object
	 * is set to private so that the user is
	 * forced to make use of the FieldFactory
	 * which makes use of the static methods
	 * of this same class.
	 */
	private Field(){
		
	}

	public JLabel getLabel() {
		return Label;
	}

	public void setLabel(JLabel label) {
		Label = label;
	}

	public Input getInput() {
		return input;
	}

	public void setInput(Input input) {
		this.input = input;
	}

	public JLabel getErrorHandling() {
		return ErrorHandling;
	}

	public void setErrorHandling(JLabel errorHandling) {
		ErrorHandling = errorHandling;
	}
}
