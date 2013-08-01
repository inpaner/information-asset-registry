package controller;

import java.util.ArrayList;

import model.Core;
import model.CoreUtil;
import view.ViewCoreListFrame;
import view.eventhandling.CoreEvent;
import view.eventhandling.CoreListener;

public class CoreListController extends Controller implements CoreListener{
    
    public CoreListController(ArrayList<Core> core){
    	new ViewCoreListFrame(this, core);
    }
    
    public CoreListController(Core core){
    	new ViewCoreListFrame(this, CoreUtil.getAll(core.getName()));
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
