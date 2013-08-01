package controller;

import model.Core;
import view.LogsFrame;
import view.ViewCoreListFrame;
import view.eventhandling.CoreEvent;
import view.eventhandling.CoreListener;

public class CoreListController extends Controller implements CoreListener{
    private ViewCoreListFrame viewCoreListFrame;
    
    public CoreListController(Core core){
    	viewCoreListFrame = new ViewCoreListFrame(this, core);
    }

	@Override
	public void savedCore(CoreEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void goToMain() {
		// TODO Auto-generated method stub
		
	} 
    
}
