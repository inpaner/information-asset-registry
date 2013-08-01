package controller;

import model.Asset;
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
        Asset asset = event.getAsset();
        try {
            asset.add();
        }
        catch(RegException e){
            e.printStackTrace();
        }
    }

    @Override
    public void goToMain() {
        new MainController();
    }

}
