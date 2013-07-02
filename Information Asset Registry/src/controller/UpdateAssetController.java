package controller;

import model.bean.Asset;
import model.bean.RegException;
import view.ViewAssetFrame;
import view.eventhandling.AssetEvent;
import view.eventhandling.AssetListener;

public class UpdateAssetController extends Controller implements AssetListener {
    private ViewAssetFrame viewAssetFrame;
    
    protected UpdateAssetController(Asset asset) {
        viewAssetFrame = new ViewAssetFrame();
        viewAssetFrame.initializeUpdateAssetForm(asset);
        viewAssetFrame.setAssetListener(this);
        Driver.display(viewAssetFrame);
    }

    @Override
    public void savedAsset(AssetEvent event) {
        Asset asset = event.getAsset();
        try {
            asset.update();
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