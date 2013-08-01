package view.gui.page;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Core;
import view.eventhandling.CoreListener;
import view.gui.LabelFactory;
import view.gui.content.Content;
import view.gui.content.contentbuilder.ContentBuilder;
import controller.CoreListController;
import controller.UpdateCoreController;

public class ViewCorePageBuilder extends PageBuilder implements ActionListener{
	private Core core;
	private CoreListener coreListener;

	public ViewCorePageBuilder(Core core, CoreListener coreListener){
		this.core = core;
		this.coreListener = coreListener;
	}
	
	@Override
	public void buildHeader(JPanel header) {
		header.add( LabelFactory.createHeader("View asset") );
	}

	@Override
	public Content createContent() {
		return ContentBuilder.buildViewForm(core);
	}

	@Override
	public void buildFooter(JPanel footer) {
		addButton("Back", footer);
		addButton("Delete", footer);
		addButton("Edit", footer);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton) e.getSource();
		if (btn.getActionCommand().equals("back"))
		{
			new CoreListController(core);
		}else if (btn.getActionCommand().equals("delete"))
		{
			// TODO 
		}else if (btn.getActionCommand().equals("edit"))
		{
			new UpdateCoreController(core);
		}
	}
	
}
