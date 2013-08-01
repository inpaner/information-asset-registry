package controller;

import model.Log;
import model.Session;
import model.User;
import view.LogsFrame;
import view.eventhandling.LogEvent;
import view.eventhandling.LogListener;

public class LogController extends Controller implements LogListener {
	protected User user;
	
	public LogController() {
		user = Session.currentUser();
		new LogsFrame(this, Log.getAll());
	}

	@Override
	public void back(LogEvent event) {
		// TODO Auto-generated method stub
		
	}

}
