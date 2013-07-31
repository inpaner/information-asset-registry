package controller;

import model.Asset;
import model.Log;
import model.RegException;
import view.ViewAssetListFrame;
import view.eventhandling.AssetEvent;
import view.eventhandling.AssetListener;

public class AddAssetController extends Controller implements AssetListener {
    private ViewAssetListFrame viewAssetFrame;
    
    protected AddAssetController() {
        Driver.display(null);
    }
    
    @Override
    public void savedAsset(AssetEvent event) {
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
