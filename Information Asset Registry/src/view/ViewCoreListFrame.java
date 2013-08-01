package view;
import controller.Driver;
import view.eventhandling.CoreListener;
import view.gui.page.PageBuilder;


public class ViewCoreListFrame {
	/**
	 * Create the frame.
	 */
	public ViewCoreListFrame(CoreListener coreListener) {
		Driver.view.setPanel ( PageBuilder.AssignCoreListPageBuilder(coreListener) );
	}
}
