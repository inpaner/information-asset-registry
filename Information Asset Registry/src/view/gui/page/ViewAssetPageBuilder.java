package view.gui.page;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.User;
import view.gui.ButtonFactory;
import view.gui.LabelFactory;
import view.gui.content.Content;
import view.gui.content.contentbuilder.ContentBuilder;

public class ViewAssetPageBuilder extends PageBuilder implements ActionListener{
	private User user;

	public ViewAssetPageBuilder(User user){
		this.user = user;
	}
	
	@Override
	public void BuildHeader(JPanel header) {
		header.add( LabelFactory.CreateHeader("View asset") );
		
	}

	@Override
	public Content CreateContent() {
		return ContentBuilder.BuildAssetList();
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
