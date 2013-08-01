package controller;

import view.MainFrame;

public class MainController extends Controller{
    
    public MainController() {
    	new MainFrame();
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

    
}
