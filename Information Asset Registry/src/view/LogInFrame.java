package view;
import view.eventhandling.LoginListener;
import view.gui.page.PageBuilder;


public class LogInFrame extends View  {
	/**
	 * Create the frame.
	 */
	public LogInFrame(LoginListener loginListener) {
		super();
		setTitle("Asset management system");
		SelectBuilder( PageBuilder.AssignLoginBuilder(loginListener) );
	}
}
