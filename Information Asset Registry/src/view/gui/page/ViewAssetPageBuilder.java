package view.gui.page;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import view.gui.ButtonFactory;
import view.gui.LabelFactory;
import view.gui.content.Content;

public class ViewAssetPageBuilder extends PageBuilder implements ActionListener{

	@Override
	public void BuildHeader(JPanel header) {
		header.add( LabelFactory.CreateHeader("View page") );
		
	}

	@Override
	public Content CreateContent() {
		return ContentBuilder.BuildViewForm(null);
	}

	@Override
	public void BuildFooter(JPanel footer) {
		JButton delete = ButtonFactory.CreateButton("Delete");
		delete.addActionListener(this);
		footer.add(delete);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
