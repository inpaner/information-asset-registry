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
	public void BuildHeader(JPanel header) {
		header.add( LabelFactory.CreateHeader("Edit page") );
		
	}

	@Override
	public Content CreateContent() {
		return ContentBuilder.BuildEditForm(null);
	}

	@Override
	public void BuildFooter(JPanel footer) {
		JButton edit = ButtonFactory.CreateButton("Edit");
		edit.addActionListener(this);
		footer.add(edit);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
