package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Core;
import view.eventhandling.CoreListener;
import view.gui.page.PageBuilder;
import controller.Driver;

public class AddCoreFrame implements ActionListener {
	
	public AddCoreFrame(Core core, CoreListener coreListener){
		Driver.view.setPanel ( PageBuilder.AssignAddCorePageBuilder(core, coreListener) );
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
