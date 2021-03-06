
package view.gui.content;
import java.util.ArrayList;

import view.gui.content.form.field.Field;

import java.awt.Dimension;
import java.util.ArrayList;

import view.gui.content.form.field.Field;
import model.RegException;
import net.miginfocom.swing.MigLayout;

public abstract class Form extends Content {
    protected ArrayList<Field> fields;
    
	public Form(){
		fields = new ArrayList<>(); 
		setLayout(new MigLayout("", "[][grow][]", "[shrink]"));
	}
	
	/**
	 * This method turns the whole
	 * form into a blank form.
	 */
	public abstract void reset();
	
	public boolean setFields() {
	    boolean noErrors = true; 
	    for (Field field : fields) {
	        if (field.setField() == false)
	            noErrors = false;
	    }
	    System.out.println("form level: " + noErrors);
        
	    return noErrors;
	}
	
	public abstract void handleException(RegException e);

	public ArrayList<Field> getFields() {
		return fields;
	}
}
