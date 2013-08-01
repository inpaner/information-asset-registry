package controller;

import model.Core;
import model.Log;
import model.RegException;
import view.ViewAssetListFrame;
import view.eventhandling.CoreEvent;
import view.eventhandling.AssetListener;

public class AddAssetController extends Controller implements AssetListener {
    private ViewAssetListFrame viewAssetFrame;
    
    protected AddAssetController() {
        Driver.display(null);
    }
    
    @Override
    public void savedAsset(CoreEvent event) {
        Core core = event.getCore();
        core.add();
    }

    @Override
    public void goToMain() {
        new MainController();
    }

}
