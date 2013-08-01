package controller;

import model.Core;
import model.Log;
import model.RegException;
import view.AddCoreFrame;
import view.ViewCoreFrame;
import view.ViewCoreListFrame;
import view.eventhandling.CoreEvent;
import view.eventhandling.CoreListener;

public class AddCoreController extends Controller implements CoreListener {
    private AddCoreFrame addCoreFrame;
    
    public AddCoreController(Core core) {
    	addCoreFrame = new AddCoreFrame(core, this);
        Driver.display(null);
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
