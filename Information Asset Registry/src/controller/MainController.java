package controller;


import javax.swing.JOptionPane;

import model.DeleteAssetModel;
import model.MainFrameModel;
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

public class MainController extends Controller implements AssetListener, LogoutListener {

	// current settings
	private User user;
	
    // views
    private MainFrame mainFrame = new MainFrame();
    private ViewAssetFrame viewAssetFrame = new ViewAssetFrame();
    private LogsFrame logsFrame = new LogsFrame();
    
    // model	
	private MainFrameModel mainFrameModel = new MainFrameModel();
    private DeleteAssetModel deleteAssetModel = new DeleteAssetModel();
    
    
    protected MainController() {
        mainFrame.setAssetListener(this);
        mainFrame.setLogoutListener(this);
        viewAssetFrame.setAssetListener(this);
        logsFrame.setAssetListener(this);
    }

    
    
	public void MoveToNewAssetHandling(AssetEvent event) {
		viewAssetFrame.InitializeNewAssetForm();
		Driver.display(viewAssetFrame);
	}
	
	public void CreateNewAsset(AssetEvent event){
		Asset asset = event.getAsset();
		try {
			asset.add();
		}catch(RegException e){
			e.printStackTrace();
		}
	}
	
	public void UpdateAsset(AssetEvent event){
		
	}

	public void MoveToUpdateAssetHandling(AssetEvent event) {
		viewAssetFrame.initializeUpdateAssetForm(event.getAsset());
		Driver.display(viewAssetFrame);
	}

	public void DeleteAssetHandling(AssetEvent event) {
		JOptionPane.showConfirmDialog(Driver.view, "Are you sure you wish to delete these X pcs. assets?", "Confirm delete", JOptionPane.YES_NO_OPTION);
		
		// Deletion code here
	}
	
	public void ViewLogsHandling(){
		logsFrame.initialize();
		Driver.display(logsFrame);
	}

	public void initialize() {
		Driver.display(mainFrame);
	}

	public void ReturnToMain() {
		Driver.display(mainFrame);
		
	}

	@Override
	public void logout() {
		Driver.changeControls(new LoginController());
		Log.loggedOut();
	}
    
}
