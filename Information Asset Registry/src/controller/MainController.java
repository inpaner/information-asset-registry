package controller;


import javax.swing.JOptionPane;

import model.DeleteAssetModel;
import model.MainFrameModel;
import model.bean.User;
import view.MainFrame;
import view.ViewAssetFrame;
import view.eventhandling.AssetEvent;
import view.eventhandling.AssetListener;

public class MainController extends Controller implements AssetListener {

	// current settings
	private User user;
	
    // views
    private MainFrame mainFrame = new MainFrame();
    private ViewAssetFrame viewAssetFrame = new ViewAssetFrame();
    
    // model	
	private MainFrameModel mainFrameModel = new MainFrameModel();
    private DeleteAssetModel deleteAssetModel = new DeleteAssetModel();
    
    
    protected MainController() {
        mainFrame.setAssetListener(this);
        viewAssetFrame.setAssetListener(this);
    }

    
    
	public void NewAssetHandling(AssetEvent event) {
		viewAssetFrame.InitializeNewAssetForm();
		Driver.display(viewAssetFrame);
	}

	public void UpdateAssetHandling(AssetEvent event) {
		viewAssetFrame.InitializeUpdateAssetForm();
		Driver.display(viewAssetFrame);
	}

	public void DeleteAssetHandling(AssetEvent event) {
		JOptionPane.showConfirmDialog(Driver.view, "Are you sure you wish to delete these X pcs. assets?", "Confirm delete", JOptionPane.YES_NO_OPTION); 
	}

	public void initialize() {
		Driver.display(mainFrame);
	}
	
}
