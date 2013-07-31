
package view.gui.content;

import java.awt.Dimension;

import net.miginfocom.swing.MigLayout;

public abstract class Form extends Content {
	public Form(){
		setLayout(new MigLayout("", "[][grow][]", "[shrink]"));
	}
	/**
	 * This method turns the whole
	 * form into a blank form.
	 */
	public abstract void Reset();
}
