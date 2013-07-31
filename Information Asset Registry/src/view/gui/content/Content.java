package view.gui.content;

import java.awt.Dimension;
import javax.swing.JPanel;

import view.View;
import net.miginfocom.swing.MigLayout;

public abstract class Content extends JPanel {
	public Content(){
		setLayout(new MigLayout());
		setPreferredSize(new Dimension(View.ViewWidth, View.ContentHeight));
	}
	/**
	 * This method prepares the content, 
	 * given an object on the subclasses'
	 * constructor, it creates the necessary
	 * Content.
	 */
	public abstract void Initialize();
}
