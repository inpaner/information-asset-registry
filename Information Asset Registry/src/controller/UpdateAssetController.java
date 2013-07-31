package controller;

import model.Asset;
import model.RegException;
import view.ViewAssetListFrame;
import view.eventhandling.AssetEvent;
import view.eventhandling.AssetListener;

public class UpdateAssetController extends Controller implements AssetListener {
    private ViewAssetListFrame viewAssetFrame;
    
    protected UpdateAssetController(Asset asset) {
        viewAssetFrame = new ViewAssetListFrame();
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
