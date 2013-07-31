
package view.gui.content;

import java.util.ArrayList;

import view.gui.content.form.field.Field;

public abstract class Form extends Content {
	
	protected ArrayList<Field> fields = new ArrayList<Field>();
	
	
	
	/**
	 * This method turns the whole
	 * form into a blank form.
	 */
	public abstract void Reset();

	public ArrayList<Field> getFields() {
		return fields;
	}
	
}
