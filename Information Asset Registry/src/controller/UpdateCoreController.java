package controller;

import model.Core;
import view.UpdateCoreFrame;
import view.eventhandling.CoreEvent;
import view.eventhandling.CoreListener;

public class UpdateCoreController extends Controller implements CoreListener {
	private UpdateCoreFrame updateCoreFrame;

	public UpdateCoreController(Core core) {
		updateCoreFrame = new UpdateCoreFrame(core, this);
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
