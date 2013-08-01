package view;
import controller.Driver;
import view.eventhandling.CoreListener;
import view.gui.page.PageBuilder;


public class ViewCoreListFrame {
	/**
	 * Create the frame.
	 */
	public ViewCoreListFrame(CoreListener coreListener) {
		super();
		Driver.view.setPanel ( PageBuilder.AssignAssetListPageBuilder(coreListener) );
	}
}
