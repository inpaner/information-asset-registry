package view.gui.page;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

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

	public Page BuildPage() {
		return new Page();
	}

	@Override
	public void BuildHeader(JPanel header) {
		header.add( LabelFactory.CreateHeader("Add " ) );
		
	}

	@Override
	public Content CreateContent() {
		return ContentBuilder.BuildAddForm(null);
	}

	@Override
	public void BuildFooter(JPanel footer) {
		JButton add = ButtonFactory.CreateButton("Add");
		add.addActionListener(this);
		footer.add(add);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
