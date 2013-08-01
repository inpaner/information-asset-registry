package controller;

import model.Core;
import view.AddCoreFrame;
import view.eventhandling.CoreEvent;
import view.eventhandling.CoreListener;

public class AddCoreController extends Controller implements CoreListener {
    
    public AddCoreController(Core core) {
    	new AddCoreFrame(core, this);
    }
    
    @Override
    public void savedCore(CoreEvent event) {
        Core core = event.getCore();
        core.add();
    }

    @Override
    public void goToMain() {
        new MainController();
    }

}
