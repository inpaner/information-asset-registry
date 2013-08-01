package view.gui.page;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.Core;
import model.CoreUtil;
import model.Session;
import view.eventhandling.CoreEvent;
import view.eventhandling.CoreListener;
import view.eventhandling.MainMenuListener;
import view.gui.ButtonFactory;
import view.gui.LabelFactory;
import view.gui.content.BasicContent;
import view.gui.content.Content;
import controller.CoreListController;
import controller.LogController;
import controller.LoginController;

public class MainPageBuilder extends PageBuilder {
    private CoreListener coreListener;
    private ActionListener logoutListener;
    private ActionListener logsListener;
    
    public MainPageBuilder() {
	}

	public void setLogoutListener(ActionListener listener) {
        logoutListener = listener;
    }

    public void setLogsListener(ActionListener listener) {
        logsListener = listener;
    }

    public void actionPerformed(ActionEvent e) {
    
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
		addButton("Logout", footer, logoutListener);
		addButton("Logs", footer, logsListener);
		ArrayList<Core> models = CoreUtil.getModels();
		
		for(Core core : models){
			String name = core.getName();
			JButton button = ButtonFactory.createButton(name);
			button.addActionListener(new CoreButtonPressed());
			button.setActionCommand(name);
			footer.add(button);
		}
	}
	
	private class CoreButtonPressed implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Core model = CoreUtil.getModel(e.getActionCommand());
            CoreEvent event = new CoreEvent(model);
            coreListener.coreSelected(event);
        }
	}

	
	public void setCoreListener(CoreListener listener) {
        coreListener = listener;
    }

}
