package view;
import java.util.ArrayList;

import model.Core;
import controller.Driver;
import view.eventhandling.CoreListener;
import view.gui.page.PageBuilder;


public class ViewCoreListFrame {
	/**
	 * Create the frame.
	 * @param core 
	 */
	public ViewCoreListFrame(CoreListener coreListener, ArrayList<Core> core) {
		Driver.view.setPanel ( PageBuilder.assignCoreListPageBuilder(coreListener, core) );
	}
}
