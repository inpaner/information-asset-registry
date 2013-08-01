package view.gui.content.form.field;

import javax.swing.JLabel;

import view.gui.LabelFactory;
import view.gui.content.Form;
import model.Core;
import model.RegException;
import model.attribute.Attribute;

public class Field{
	
	protected JLabel inputLabel;
	protected Input inputField;
	protected JLabel errorLabel;
	
	/**
	 * This method creates the necessary field depending on
	 * the type of the attribute passed. This changes the 
	 * input, varying between ComboInput, TextInput, or DateInput
	 * @param attribute - this is the attribute to be turned into a field
	 * @return field - the newly constructed Field object
	 */
	public static Field buildField(Attribute attribute){
		Input input = Input.createInput(attribute);
		Field newField = new Field(input);
		return newField;
	}
	
	/**
	 * The constructor of the field object
	 * is set to private so that the user is
	 * forced to make use of the FieldFactory
	 * which makes use of the static methods
	 * of this same class.
	 */
	private Field(Input input) {
		String label = input.attribute.getName();
		inputLabel = LabelFactory.createFormLabel(label + ":");
		inputField = input; 
		errorLabel = LabelFactory.createFormErrorLabel("");
	}

	public JLabel getLabel() {
		return inputLabel;
	}

	public Input getInput() {
		return inputField;
	}

	public JLabel getErrorHandling() {
		return errorLabel;
	}
	
	public void ResetErrorHandling(){
		errorLabel.setText("");
	}

	public void setErrorHandling(JLabel errorHandling) {
		errorLabel = errorHandling;
	}
	
	public void addTo(Form form){
		try {
			form.getFields().add(this);
			form.add(inputLabel);
			if (inputField == null)
				throw new RegException("InvalidInputException: The input was null.");
			form.add(inputField.getComponent(), "grow");
			form.add(errorLabel, "wrap");
		}catch(RegException e){
			e.printStackTrace();
		}
	}

	public boolean setField() {
		boolean noErrors = true;
	    try {
			inputField.setInput();
		}catch (RegException e){
		    noErrors = false;
			errorLabel.setText(e.getMessage());
		}
		return noErrors;
	}
}
