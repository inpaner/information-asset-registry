package view.gui.content;
import javax.swing.JPanel;

public abstract class Content extends JPanel {
	/**
	 * This method prepares the content, 
	 * given an object on the subclasses'
	 * constructor, it creates 
	 */
	public abstract void Initialize();
}
