package controller;

import model.Session;
import view.LogInFrame;
import view.MainFrame;
import view.ViewCoreListFrame;
import view.eventhandling.CoreEvent;
import view.eventhandling.CoreListener;
import view.gui.page.AddCorePageBuilder;

public class MainController extends Controller implements CoreListener {

    // views
    private MainFrame mainFrame;
    
    public MainController() {
    	mainFrame = new MainFrame(this);
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
	public void savedCore(CoreEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void goToMain() {
		// TODO Auto-generated method stub
		
	}
    
}
