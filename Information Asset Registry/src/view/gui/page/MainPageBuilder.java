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
	public void buildHeader(JPanel header) {
		header.add( LabelFactory.createHeader("Main menu") );
	}

	@Override
	public Content createContent() {
		BasicContent content = new BasicContent();
		content.add(LabelFactory.createLabel("Please select below which list you would like to view."));
		return content;
	}

	@Override
	public void buildFooter(JPanel footer) {
		addButton("Logout", footer);
		addButton("Logs", footer);
		ArrayList<Core> models = CoreUtil.getModels();
		
		for(Core core : models){
			String name = core.getName();
			JButton button = ButtonFactory.createButton(name);
			button.addActionListener(this);
			button.setActionCommand(name);
			footer.add( button );
			
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		
		if (btn.getActionCommand().equals("logout")){
			// Logs out
			Session.currentUser().logOut();
			new LoginController();
		}else if (btn.getActionCommand().equals("logs")){
			// Logs
			
			
		}else{
			// Gets the template of the selected core
			Core model = CoreUtil.getModel(btn.getActionCommand());
			
			// Fires up a new core list
			new CoreListController(model);
		}
		
	}

}
