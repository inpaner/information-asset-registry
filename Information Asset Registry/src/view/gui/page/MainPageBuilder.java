package view.gui.page;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.CoreListController;
import controller.Driver;
import controller.LoginController;
import model.Core;
import model.CoreUtil;
import model.Session;
import view.eventhandling.CoreListener;
import view.gui.ButtonFactory;
import view.gui.LabelFactory;
import view.gui.content.BasicContent;
import view.gui.content.Content;

public class MainPageBuilder extends PageBuilder implements ActionListener{
	public MainPageBuilder() {
	}

	@Override
	public void BuildHeader(JPanel header) {
		header.add( LabelFactory.CreateHeader("Main menu") );
	}

	@Override
	public Content CreateContent() {
		BasicContent content = new BasicContent();
		content.add(LabelFactory.CreateLabel("Please select below which list you would like to view."));
		return content;
	}

	@Override
	public void BuildFooter(JPanel footer) {
		ArrayList<Core> models = CoreUtil.getModels();
		for(Core core : models){
			String name = core.getName();
			JButton button = ButtonFactory.CreateButton(name);
			button.addActionListener(this);
			button.setActionCommand(name);
			footer.add( button );
			
		}
		
		JButton button = ButtonFactory.CreateButton("Logout");
		button.addActionListener(this);
		button.setActionCommand("logout");
		footer.add( button );
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		
		if (btn.getActionCommand().equals("back")){
			Session.currentUser().logOut();
			new LoginController();
		}
		
		// Gets the template of the selected core
		Core model = CoreUtil.getModel(btn.getActionCommand());
		
		// Fires up a new core list
		new CoreListController(model);
		
	}

}
