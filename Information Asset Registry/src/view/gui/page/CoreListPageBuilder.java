package view.gui.page;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Core;
import model.CoreUtil;
import view.eventhandling.CoreEvent;
import view.eventhandling.CoreListener;
import view.gui.LabelFactory;
import view.gui.content.Content;
import view.gui.content.CoreTable;
import view.gui.content.contentbuilder.ContentBuilder;
import controller.AddCoreController;
import controller.CoreListController;
import controller.MainController;
import controller.EditCoreController;
import controller.ViewCoreController;

public class CoreListPageBuilder extends PageBuilder implements KeyListener {
	private CoreListener addListener;
	private CoreListener viewListener;
	private CoreListener updateListener;
    private ActionListener backListener;
	
    private ArrayList<Core> cores;
	private JTextField Search;

	public CoreListPageBuilder(ArrayList<Core> cores) {
    	this.cores = cores;
	}

    public void setBackListener(ActionListener listener) {
        backListener = listener;
    }

    public void setAddListener(CoreListener listener) {
        addListener = listener;
    }
	
    public void setViewListener(CoreListener listener) {
        viewListener = listener;
    }
    
    public void setUpdateListener(CoreListener listener) {
        updateListener = listener;
    }
    
    
	public void buildHeader(JPanel header) {
		header.add( LabelFactory.createHeader(CapitalizeCore(cores.get(0)) + " list") );
		header.add(Box.createHorizontalStrut(30)); 
		header.add( Search = new JTextField(15) );
		Search.addKeyListener(this);
	}

	public Content createContent() {
		return ContentBuilder.buildCoreList(cores);
	}

	public void buildFooter(JPanel footer) {
		addButton("Back", footer, backListener);
		addButton("Update", footer, new UpdateButtonPressed());
		addButton("View", footer, new ViewButtonPressed());
		addButton("Add", footer, new AddButtonPressed());
	}
	
	private class AddButtonPressed implements ActionListener {
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        CoreEvent event = new CoreEvent(cores.get(0));
	        addListener.coreSelected(event);
	    }
	}
	
	private class ViewButtonPressed implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            CoreTable coreTable = (CoreTable)pageReference.getContent();
            Core core = coreTable.getSelected();
            CoreEvent event = new CoreEvent(core);
            viewListener.coreSelected(event);
        }
    }

    private class UpdateButtonPressed implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            CoreTable coreTable = (CoreTable)pageReference.getContent();
            Core core = coreTable.getSelected();
            CoreEvent event = new CoreEvent(core);
            updateListener.coreSelected(event);
        }
    }

	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		
		if (e.getActionCommand().equals("view")){
			CoreTable coreTable = (CoreTable)pageReference.getContent();
			Core core = coreTable.getSelected();
				
			if (core != null)
				// Fires up a new core list
				new ViewCoreController(core);
		}
		
		else if (e.getActionCommand().equals("add")){
			CoreTable coreTable = (CoreTable)pageReference.getContent();

			// Fires up a new core list
			new AddCoreController(cores.get(0));
		}
		
		else if (e.getActionCommand().equals("update")){
			CoreTable coreTable = (CoreTable)pageReference.getContent();
			Core core = coreTable.getSelected();
				
			if (core != null)
				// Fires up a new core list
				new EditCoreController(core);
		}else if (e. getActionCommand().equals("back")){
			new MainController();
		}
	}

	public void keyPressed(KeyEvent e) {
	}
	
	public void keyReleased(KeyEvent e) {
		JTextField target = (JTextField) e.getSource();
		if (e.getKeyCode() == KeyEvent.VK_ENTER && Search.equals(target)) {
			String query = Search.getText();
			
			ArrayList<Core> result = CoreUtil.search(cores.get(0).getName(), query);
			if (result.size() == 0){
				new CoreListController(cores.get(0));
			} else
				new CoreListController(result);
		}
		
		
	}
	public void keyTyped(KeyEvent e) {
	}

}
