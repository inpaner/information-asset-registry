package controller;


import javax.swing.JOptionPane;

import model.DeleteAssetModel;
import model.MainFrameModel;
import model.UpdateAssetModel;
import model.bean.Asset;
import model.bean.Log;
import model.bean.RegException;
import model.bean.User;
import view.LogsFrame;
import view.MainFrame;
import view.ViewAssetFrame;
import view.eventhandling.AssetEvent;
import view.eventhandling.AssetListener;
import view.eventhandling.LogoutListener;
import view.eventhandling.MainMenuListener;

public class MainController extends Controller implements MainMenuListener, LogoutListener {

    // views
    private MainFrame mainFrame;
    private ViewAssetFrame viewAssetFrame = new ViewAssetFrame();
    private LogsFrame logsFrame = new LogsFrame();
    
    
    protected MainController() {
        mainFrame = new MainFrame();
        mainFrame.setMainMenuListener(this);
        mainFrame.setLogoutListener(this);
        Driver.display(mainFrame);
    }
    
	@Override
    public void newAsset(AssetEvent event) {
        new AddAssetController();
    }

	@Override
    public void updateAsset(AssetEvent event) {
	    new UpdateAssetController(event.getAsset());
	}

	@Override
    public void deleteAsset(AssetEvent event) {
        // TODO Auto-generated method stub
        
    }

    // move to DeleteAssetController
    /*
    public void deleteAssetHandling(AssetEvent event) {
        JOptionPane.showConfirmDialog(Driver.view, "Are you sure you wish to delete these X pcs. assets?", "Confirm delete", JOptionPane.YES_NO_OPTION);
        
        // Deletion code here
    }
    */
	
	@Override
    public void viewLogs() {
        logsFrame.initialize();
        Driver.display(logsFrame);
    }

	public void initialize() {
	}

	@Override
	public void logout() {
		new LoginController();
	}
    
}
