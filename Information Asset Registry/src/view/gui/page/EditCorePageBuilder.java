package view.gui.page;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import view.gui.ButtonFactory;
import view.gui.LabelFactory;
import view.gui.content.Content;
import view.gui.content.contentbuilder.ContentBuilder;

public class EditCorePageBuilder extends PageBuilder implements ActionListener{

	@Override
	public void buildHeader(JPanel header) {
		header.add( LabelFactory.createHeader("Edit page") );
		
	}

	@Override
	public Content createContent() {
		return ContentBuilder.buildEditForm(null);
	}

	@Override
	public void buildFooter(JPanel footer) {
		JButton edit = ButtonFactory.createButton("Edit");
		edit.addActionListener(this);
		footer.add(edit);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
