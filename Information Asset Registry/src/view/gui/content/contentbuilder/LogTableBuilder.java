package view.gui.content.contentbuilder;

import java.util.ArrayList;

import model.Log;
import model.Session;
import model.User;
import view.gui.content.Content;
import view.gui.content.LogTable;

public class LogTableBuilder extends TableBuilder {

	protected User user;
	private ArrayList<Log> logs;
	
	public LogTableBuilder(ArrayList<Log> logs) {
		this.user = Session.currentUser();
		this.logs = logs;
	}
	
	@Override
	public void initializeTableContents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Content buildContent() {
		LogTable content = new LogTable(logs);
		content.initialize();
		return content;
	}

}
