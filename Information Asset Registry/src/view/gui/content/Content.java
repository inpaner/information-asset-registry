package view.gui.content;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public abstract class Content extends JPanel {
	
	public Content(){
		setLayout(new FlowLayout());
	}
	
	/**
	 * This method prepares the content, 
	 * given an object on the subclasses'
	 * constructor, it creates the necessary
	 * Content.
	 */
	public abstract void Initialize();
}
