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

public class CoreListPageBuilder extends PageBuilder implements ActionListener {
	private CoreListener coreListener;

	public CoreListPageBuilder(CoreListener coreListener) {
	this.coreListener = coreListener;
	}

	@Override
	public void BuildHeader(JPanel header) {
		header.add( LabelFactory.CreateHeader("Asset list") );
	}

	@Override
	public Content CreateContent() {
		return ContentBuilder.BuildAssetList();
	}

	@Override
	public void BuildFooter(JPanel footer) {
		JButton button;
		button = ButtonFactory.CreateButton("View asset");
		button.setActionCommand("view");
		button.addActionListener(this);
		footer.add(button);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
