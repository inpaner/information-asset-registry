package view;

import view.eventhandling.CoreListener;
import view.gui.page.PageBuilder;
import controller.Driver;


public class MainFrame  {
	public MainFrame() {
		Driver.view.setPanel ( PageBuilder.assignMainPageBuilder() );
	}

}
