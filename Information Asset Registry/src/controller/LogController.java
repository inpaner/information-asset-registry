package controller;

import view.LogsFrame;
import view.eventhandling.LogEvent;
import view.eventhandling.LogListener;

public class LogController implements LogListener {
    private LogsFrame logsFrame; 
    
    protected LogController() {
        logsFrame = new LogsFrame();
        logsFrame.setLogListener(this);
        logsFrame.initialize();
        Driver.display(logsFrame);
    }
    
    @Override
    public void back(LogEvent event) {
        new MainController();
    }

}
