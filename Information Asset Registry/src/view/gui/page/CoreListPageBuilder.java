package view.gui.page;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.eventhandling.CoreListener;
import view.gui.ButtonFactory;
import view.gui.LabelFactory;
import view.gui.content.Content;
import view.gui.content.contentbuilder.ContentBuilder;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.Core;

public class CoreListPageBuilder extends PageBuilder implements ActionListener {
	private CoreListener coreListener;
	private Core core;

	public CoreListPageBuilder(CoreListener coreListener, Core core) {
	this.coreListener = coreListener;
	this.core = core;
	}

	public void BuildHeader(JPanel header) {
		String name = core.getName();
		name = Character.toUpperCase(name.charAt(0)) + name.substring(1);  
		header.add( LabelFactory.CreateHeader(name + " list") );
	}

	public Content CreateContent() {
		return ContentBuilder.BuildAssetList(core);
	}

	public void BuildFooter(JPanel footer) {
		JButton button;
		button = ButtonFactory.CreateButton("View");
		button.setActionCommand("view");
		button.addActionListener(this);
		footer.add(button);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
