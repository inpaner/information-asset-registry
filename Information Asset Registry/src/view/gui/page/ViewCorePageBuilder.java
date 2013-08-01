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

public class ViewCorePageBuilder extends PageBuilder implements ActionListener{
	private Core core;
	private CoreListener coreListener;

	public ViewCorePageBuilder(Core core, CoreListener coreListener){
		this.core = core;
		this.coreListener = coreListener;
	}
	
	@Override
	public void BuildHeader(JPanel header) {
		header.add( LabelFactory.CreateHeader("View asset") );
		
	}

	@Override
	public Content CreateContent() {
		return ContentBuilder.BuildViewForm(core);
	}

	@Override
	public void BuildFooter(JPanel footer) {
		JButton delete = ButtonFactory.CreateButton("Delete");
		delete.addActionListener(this);
		footer.add(delete);
		
		JButton edit = ButtonFactory.CreateButton("Edit");
		edit.addActionListener(this);
		footer.add(edit);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
