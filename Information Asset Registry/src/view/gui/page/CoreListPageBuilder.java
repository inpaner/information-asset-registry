package view.gui.page;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.eventhandling.CoreListener;
import view.gui.ButtonFactory;
import view.gui.LabelFactory;
import view.gui.content.Content;
import view.gui.content.CoreTable;
import view.gui.content.contentbuilder.ContentBuilder;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.AddCoreController;
import controller.CoreListController;
import controller.LoginController;
import controller.MainController;
import controller.UpdateCoreController;
import controller.ViewCoreController;
import model.Core;
import model.CoreUtil;

public class CoreListPageBuilder extends PageBuilder implements ActionListener {
	private CoreListener coreListener;
	private Core core;

	public CoreListPageBuilder(CoreListener coreListener, Core core) {
	this.coreListener = coreListener;
	this.core = core;
	}

	public void buildHeader(JPanel header) {
		header.add( LabelFactory.createHeader(CapitalizeCore(core) + " list") );
	}

	public Content createContent() {
		return ContentBuilder.buildAssetList(core);
	}

	public void buildFooter(JPanel footer) {
		addButton("Back", footer);
		addButton("Update", footer);
		addButton("View", footer);
		addButton( "Add", footer);
		
	}

	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		
		if (e.getActionCommand().equals("view")){
			CoreTable coreTable = (CoreTable)PageReference.getContent();
			Core core = coreTable.getSelected();
				
			if (core != null)
				// Fires up a new core list
				new ViewCoreController(core);
		}else if (e.getActionCommand().equals("add")){
			CoreTable coreTable = (CoreTable)PageReference.getContent();

			// Fires up a new core list
			new AddCoreController(core);
		}else if (e.getActionCommand().equals("update")){
			CoreTable coreTable = (CoreTable)PageReference.getContent();
			Core core = coreTable.getSelected();
				
			if (core != null)
				// Fires up a new core list
				new UpdateCoreController(core);
		}else if (e. getActionCommand().equals("back")){
			new MainController();
		}
	}

}
