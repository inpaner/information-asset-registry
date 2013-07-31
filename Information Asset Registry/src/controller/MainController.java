package controller;

import model.User;
import view.LogInFrame;
import view.LogsFrame;
import view.MainFrame;
import view.ViewAssetListFrame;
import view.eventhandling.AssetEvent;
import view.eventhandling.AssetListener;
import view.eventhandling.LogoutListener;
import view.eventhandling.MainMenuListener;
import view.gui.content.form.AddAssetFormBuilder;
import view.gui.page.AddAssetPageBuilder;
import view.gui.page.LoginPageBuilder;

public class MainController extends Controller implements AssetListener {

    // views
    private ViewAssetListFrame viewAssetListFrame;
    
    protected MainController() {
    	Driver.view.setPanel(new AddAssetPageBuilder());
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
	public void savedAsset(AssetEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void goToMain() {
		// TODO Auto-generated method stub
		
	}
    
}
