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
import view.eventhandling.CoreListener;
import view.gui.LabelFactory;
import view.gui.content.Content;
import view.gui.content.CoreTable;
import view.gui.content.contentbuilder.ContentBuilder;
import controller.AddCoreController;
import controller.CoreListController;
import controller.MainController;
import controller.UpdateCoreController;
import controller.ViewCoreController;

public class CoreListPageBuilder extends PageBuilder implements ActionListener, KeyListener {
	private CoreListener coreListener;
	private ArrayList<Core> core;
	private JTextField Search;

	public CoreListPageBuilder(CoreListener coreListener, ArrayList<Core> cores) {
	this.coreListener = coreListener;
	this.core = cores;
	}

	public void buildHeader(JPanel header) {
		header.add( LabelFactory.createHeader(CapitalizeCore(core.get(0)) + " list") );
		header.add(Box.createHorizontalStrut(30)); 
		header.add( Search = new JTextField(15) );
		Search.addKeyListener(this);
	}

	public Content createContent() {
		return ContentBuilder.buildAssetList(core);
	}

	public void buildFooter(JPanel footer) {
		addButton("Back", footer);
		addButton("Update", footer);
		addButton("View", footer);
		addButton("Add", footer);
		
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
			new AddCoreController(core.get(0));
		}
		
		else if (e.getActionCommand().equals("update")){
			CoreTable coreTable = (CoreTable)pageReference.getContent();
			Core core = coreTable.getSelected();
				
			if (core != null)
				// Fires up a new core list
				new UpdateCoreController(core);
		}else if (e. getActionCommand().equals("back")){
			new MainController();
		}
	}

	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		JTextField target = (JTextField) e.getSource();
		if (e.getKeyCode() == KeyEvent.VK_ENTER && Search.equals(target)){
			String query = Search.getText();
			
			ArrayList<Core> result = CoreUtil.search(core.get(0).getName(), query);
			if (result.size() == 0){
				new CoreListController(core.get(0));
			}else
				new CoreListController(result);
		}
		
		
	}
	public void keyTyped(KeyEvent e) {
	}

}
