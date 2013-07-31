package view.gui.content.form.field;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.gui.LabelFactory;
import net.miginfocom.swing.MigLayout;
import model.attribute.Attribute;
import model.attribute.AttributeUtil;
import model.attribute.DateAttribute;
import model.attribute.IntegerAttribute;
import model.attribute.PrimaryAttribute;
<<<<<<< HEAD
import model.attribute.StringAttribute;

public class Field {
=======
import model.attribute.StringAttribute;
>>>>>>> branch 'master' of https://github.com/inpaner/information-asset-registry.git

<<<<<<< HEAD
=======
public class Field{
>>>>>>> branch 'master' of https://github.com/inpaner/information-asset-registry.git
	
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
	public static Field BuildField(Attribute attribute){
		Input input = Input.CreateInput(attribute);
		Field newField = new Field(input);
		return newField;
	}
	
	/**
	 * This method creates the necessary field depending on
	 * the type of the attribute passed. This changes the 
	 * input, varying between ComboInput, TextInput, or DateInput
	 * @param attribute - this is the attribute to be turned into a field
	 * @return field - the newly constructed Field object
	 */
	public static Field BuildField(StringAttribute attribute){
		Input input = Input.CreateInput(attribute);
		Field newField = new Field(input);
		return newField;
	}
	
	/**
	 * This method creates the necessary field depending on
	 * the type of the attribute passed. This changes the 
	 * input, varying between ComboInput, TextInput, or DateInput
	 * @param attribute - this is the attribute to be turned into a field
	 * @return field - the newly constructed Field object
	 */
	public static Field BuildField(DateAttribute attribute){
		Input input = Input.CreateInput(attribute);
		Field newField = new Field(input);
		return newField;
	}
	
	/**
	 * This method creates the necessary field depending on
	 * the type of the attribute passed. This changes the 
	 * input, varying between ComboInput, TextInput, or DateInput
	 * @param attribute - this is the attribute to be turned into a field
	 * @return field - the newly constructed Field object
	 */
	public static Field BuildField(IntegerAttribute attribute){
		Input input = Input.CreateInput(attribute);
		Field newField = new Field(input);
		return newField;
	}
	
	/**
	 * This method creates the necessary field depending on
	 * the type of the attribute passed. This changes the 
	 * input, varying between ComboInput, TextInput, or DateInput
	 * @param attribute - this is the attribute to be turned into a field
	 * @return field - the newly constructed Field object
	 */
	public static Field BuildField(PrimaryAttribute attribute){
		Input input = Input.CreateInput(attribute);
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
		inputLabel = LabelFactory.CreateFormLabel(label + ":");
		inputField = input; 
		errorLabel = LabelFactory.CreateFormErrorLabel("");
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

	public void setErrorHandling(JLabel errorHandling) {
		errorLabel = errorHandling;
	}
	
	public void addTo(JPanel panel){
		panel.add(inputLabel);
		panel.add(inputField.getComponent());
		panel.add(errorLabel, "wrap");
	}
}
