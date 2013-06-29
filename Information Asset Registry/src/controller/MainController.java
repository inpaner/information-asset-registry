package controller;

import javax.swing.JOptionPane;

import view.LogInFrame;
import view.MainFrame;
import view.View;
import view.ViewAssetFrame;
import view.eventhandling.AssetEvent;
import view.eventhandling.AssetListener;
import view.eventhandling.LoginEvent;
import view.eventhandling.LoginListener;
import model.DeleteAssetModel;
import model.MainFrameModel;
import model.Model;
import model.NewAssetModel;
import model.UpdateAssetModel;
import model.bean.RegException;
import model.bean.User;

public class MainController AssetListener {
	
	// current logged in user
    private User user;
    
    // current settings
    private Model model;
    private static View view;
    
    // views
    private MainFrame mainFrame = new MainFrame();
    private ViewAssetFrame viewAssetFrame = new ViewAssetFrame();
    
    // models 
    private MainFrameModel mainFrameModel = new MainFrameModel();
    private NewAssetModel newAssetModel = new NewAssetModel();
    private UpdateAssetModel updateAssetModel = new UpdateAssetModel();
    private DeleteAssetModel deleteAssetModel = new DeleteAssetModel();
    
    public static void main(String[] args) {
        new MainController();
    }
    
    public MainController (){
        Login();
    }
    
    protected void Login() {
        new LoginController();
    }
    
    /**
     * This function begins by hiding the current view, updating the current view, and finally displays the selected view.
     * @param replacement - The frame that you wish to display
     */
    public static void display(View replacement){
    	if (view != null)
    		view.setVisible(false);
    	
    	view = replacement;
    	view.setVisible(true);
    }

	public void NewAssetHandling(AssetEvent event) {
		viewAssetFrame.InitializeNewAssetForm();
		display(viewAssetFrame);
		this.model = newAssetModel;
	}

	public void UpdateAssetHandling(AssetEvent event) {
		viewAssetFrame.InitializeUpdateAssetForm();
		display(viewAssetFrame);
		this.model = updateAssetModel;
	}

	public void DeleteAssetHandling(AssetEvent event) {
		this.model = deleteAssetModel;
		JOptionPane.showConfirmDialog(view, "Are you sure you wish to delete these X pcs. assets?", "Confirm delete", JOptionPane.YES_NO_OPTION); 
	}
}
