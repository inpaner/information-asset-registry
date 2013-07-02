package controller;

import model.bean.Asset;
import model.bean.Log;
import model.bean.RegException;
import view.ViewAssetFrame;
import view.eventhandling.AssetEvent;
import view.eventhandling.AssetListener;

public class AddAssetController extends Controller implements AssetListener {
    private ViewAssetFrame viewAssetFrame;
    
    protected AddAssetController() {
        viewAssetFrame = new ViewAssetFrame();
        viewAssetFrame.initializeNewAssetForm();
        viewAssetFrame.setAssetListener(this);
        Driver.display(viewAssetFrame);
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
