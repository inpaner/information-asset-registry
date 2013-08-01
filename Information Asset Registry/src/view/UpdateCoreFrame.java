package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Core;
import view.eventhandling.CoreListener;
import view.gui.page.PageBuilder;
import controller.Driver;

public class UpdateCoreFrame {

	public UpdateCoreFrame(Core core, CoreListener coreListener){
		Driver.view.setPanel ( PageBuilder.AssignEditCorePageBuilder(core, coreListener) );
	}
	
}
