package view;

import java.util.ArrayList;

import model.Log;
import view.eventhandling.LogListener;
import view.gui.page.PageBuilder;
import controller.Driver;

public class LogsFrame {

	public LogsFrame(LogListener logListener, ArrayList<Log> logs) {
		Driver.view.setPanel(PageBuilder.assignLogPageBuilder(logListener, logs));
	}
	
}
