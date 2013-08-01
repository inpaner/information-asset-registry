package view.gui.page;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.AddCoreController;
import controller.CoreListController;
import model.Core;
import view.eventhandling.CoreListener;
import view.gui.ButtonFactory;
import view.gui.LabelFactory;
import view.gui.content.Content;
import view.gui.content.contentbuilder.ContentBuilder;

public class AddCorePageBuilder extends PageBuilder implements ActionListener{
	private Core core;
	private CoreListener coreListener;
	
	public AddCorePageBuilder(Core core, CoreListener coreListener) {
		super();
		this.core = core;
		this.coreListener = coreListener;
	}

	public Page buildPage() {
		return new Page();
	}

	@Override
	public void buildHeader(JPanel header) {
		header.add( LabelFactory.createHeader("Add new " + CapitalizeCore(core)) );
		
	}

	@Override
	public Content createContent() {
		return ContentBuilder.buildAddForm(core);
	}

	@Override
	public void buildFooter(JPanel footer) {
		addButton("Reset", footer);
		addButton("Back", footer);
		addButton("Add", footer);
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
		}else if (btn.getActionCommand().equals("add"))
		{
			new AddCoreController(core);
		}
	}

}
