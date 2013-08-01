package controller;

import java.util.ArrayList;

import model.Core;
import model.CoreUtil;
import view.LogsFrame;
import view.ViewCoreListFrame;
import view.eventhandling.CoreEvent;
import view.eventhandling.CoreListener;

public class CoreListController extends Controller implements CoreListener{
    private ViewCoreListFrame viewCoreListFrame;
    
    public CoreListController(ArrayList<Core> core){
    	viewCoreListFrame = new ViewCoreListFrame(this, core);
    }
    
    public CoreListController(Core core){
    	viewCoreListFrame = new ViewCoreListFrame(this, CoreUtil.getAll(core.getName()));
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
