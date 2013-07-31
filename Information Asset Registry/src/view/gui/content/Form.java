
package view.gui.content;
import java.util.ArrayList;
import view.gui.content.form.field.Field;
import java.awt.Dimension;
import net.miginfocom.swing.MigLayout;

public abstract class Form extends Content {
	protected ArrayList<Field> fields = new ArrayList<Field>();
	
	public Form(){
		setLayout(new MigLayout("", "[][grow][]", "[shrink]"));
	}
	
	/**
	 * This method turns the whole
	 * form into a blank form.
	 */
	public abstract void Reset();

	public ArrayList<Field> getFields() {
		return fields;
	}
	
}
