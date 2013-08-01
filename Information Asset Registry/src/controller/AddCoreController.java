package controller;

import model.Core;
import model.Log;
import model.RegException;
import view.ViewCoreListFrame;
import view.eventhandling.CoreEvent;
import view.eventhandling.CoreListener;

public class AddCoreController extends Controller implements CoreListener {
    private ViewCoreListFrame viewAssetFrame;
    
    public AddCoreController() {
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
