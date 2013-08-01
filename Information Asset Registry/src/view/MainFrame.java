package view;

import view.eventhandling.CoreListener;
import view.gui.page.PageBuilder;
import controller.Driver;


public class MainFrame  {
	public MainFrame(CoreListener coreListener) {
		Driver.view.setPanel ( PageBuilder.AssignMainPageBuilder(coreListener) );
	}

}
