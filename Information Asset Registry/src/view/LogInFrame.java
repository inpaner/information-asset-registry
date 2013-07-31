package view;
import java.awt.Dimension;

import view.eventhandling.LoginListener;
import view.gui.page.PageBuilder;


public class LogInFrame extends View  {
	private static final Dimension LoginFrameDimension = new Dimension(View.ViewWidth, 200);

	/**
	 * Create the frame.
	 */
	public LogInFrame(LoginListener loginListener) {
		super();
		setPreferredSize(LoginFrameDimension);
		setTitle("Asset management system");
		SelectBuilder( PageBuilder.AssignLoginBuilder(loginListener) );
	}
}
