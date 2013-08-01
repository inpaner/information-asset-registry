package view.gui.page;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.MainController;
import model.Log;
import view.eventhandling.LogListener;
import view.gui.LabelFactory;
import view.gui.content.Content;
import view.gui.content.contentbuilder.ContentBuilder;

public class LogPageBuilder extends PageBuilder implements ActionListener, KeyListener {
	
	private LogListener logListener;
	private ArrayList<Log> logs;
	
	public LogPageBuilder(LogListener logListener, ArrayList<Log> logs) {
		this.logListener = logListener;
		this.logs = logs;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (((JButton) e.getSource()).getText() == "Back") {
			new MainController();
		}
	}

	@Override
	public void buildHeader(JPanel header) {
		header.add( LabelFactory.createHeader("Log") );
	}

	@Override
	public Content createContent() {
		return ContentBuilder.buildLogList(logs);
	}

	@Override
	public void buildFooter(JPanel footer) {
		this.addButton("Back", footer);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
