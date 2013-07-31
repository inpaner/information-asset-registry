
package view.gui.content;
import java.util.ArrayList;
import view.gui.content.form.field.Field;
import java.awt.Dimension;
import java.util.ArrayList;

import view.gui.content.form.field.Field;
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
	public abstract void Reset();
	
	public boolean setFields() {
	    boolean noError = true; 
	    for (Field field : fields) {
	        if (field.setField() == false)
	            noError = false;
	    }
	    
	    return noError;
	}
}
