package view.gui.page;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.CoreListController;
import controller.UpdateCoreController;
import model.Core;
import view.eventhandling.CoreListener;
import view.gui.ButtonFactory;
import view.gui.LabelFactory;
import view.gui.content.Content;
import view.gui.content.contentbuilder.ContentBuilder;

public class EditCorePageBuilder extends PageBuilder implements ActionListener{
	
	private CoreListener coreListener;
	private Core core;

	public EditCorePageBuilder(Core core, CoreListener coreListener) {
		this.core = core;
		this.coreListener = coreListener;
	}

	@Override
	public void buildHeader(JPanel header) {
		header.add( LabelFactory.createHeader("Update " + CapitalizeCore(core)) );
		
	}

	@Override
	public Content createContent() {
		return ContentBuilder.buildEditForm(core);
	}

	@Override
	public void buildFooter(JPanel footer) {
		addButton("Back", footer);
		addButton("Reset", footer);
		addButton("Update", footer);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		if (btn.getActionCommand().equals("back"))
		{
			new CoreListController(core);
		}else if (btn.getActionCommand().equals("reset"))
		{
			// TODO 
		}else if (btn.getActionCommand().equals("update"))
		{
			new UpdateCoreController(core); 
		}
	}

}
