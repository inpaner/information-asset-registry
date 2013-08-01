package view;
import model.Core;
import controller.Driver;
import view.eventhandling.CoreListener;
import view.gui.page.PageBuilder;


public class ViewCoreListFrame {
	/**
	 * Create the frame.
	 * @param core 
	 */
	public ViewCoreListFrame(CoreListener coreListener, Core core) {
		Driver.view.setPanel ( PageBuilder.assignCoreListPageBuilder(coreListener, core) );
	}
}
