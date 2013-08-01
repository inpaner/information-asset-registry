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

import controller.CoreListController;
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
		JButton button;
		button = ButtonFactory.createButton("View");
		button.setActionCommand("view");
		button.addActionListener(this);
		footer.add(button);
	}

	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		
		if (e.getActionCommand().equals("view")){
			CoreTable coreTable = (CoreTable)PageReference.getContent();
			Core core = coreTable.getSelected();
			// Fires up a new core list
			new ViewCoreController(core);
		}
	}

}
