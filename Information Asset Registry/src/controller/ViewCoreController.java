package controller;

import model.Core;
import model.Log;
import model.RegException;
import view.ViewCoreFrame;
import view.ViewCoreListFrame;
import view.eventhandling.CoreEvent;
import view.eventhandling.CoreListener;

public class ViewCoreController extends Controller implements CoreListener {
    private ViewCoreFrame viewCoreFrame;
    
    public ViewCoreController(Core core) {
    	viewCoreFrame = new ViewCoreFrame(core, this);
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
