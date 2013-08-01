package view.gui.page;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import view.gui.ButtonFactory;
import view.gui.LabelFactory;
import view.gui.content.CoreForm;
import view.gui.content.Content;
import view.gui.content.contentbuilder.ContentBuilder;
import view.gui.content.form.AddAssetFormBuilder;
import view.gui.content.form.ViewAssetFormBuilder;

public class AddAssetPageBuilder extends PageBuilder implements ActionListener{

	public Page BuildPage() {
		return new Page();
	}

	@Override
	public void BuildHeader(JPanel header) {
		header.add( LabelFactory.CreateHeader("Add page") );
		
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
