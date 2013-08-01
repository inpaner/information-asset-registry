package controller;

import model.Session;
import view.LogInFrame;
import view.ViewAssetListFrame;
import view.eventhandling.CoreEvent;
import view.eventhandling.AssetListener;
import view.gui.page.AddAssetPageBuilder;

public class MainController extends Controller implements AssetListener {

    // views
    private ViewAssetListFrame viewAssetListFrame;
    
    protected MainController() {
    	viewAssetListFrame = new ViewAssetListFrame(this);
    }

    // move to DeleteAssetController
    /*
    public void deleteAssetHandling(AssetEvent event) {
        JOptionPane.showConfirmDialog(Driver.view, "Are you sure you wish to delete these X pcs. assets?", "Confirm delete", JOptionPane.YES_NO_OPTION);
        
        // Deletion code here
    }
    */
	

	public void initialize() {
	}


	@Override
	public void savedAsset(CoreEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void goToMain() {
		// TODO Auto-generated method stub
		
	}
    
}
