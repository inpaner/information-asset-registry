package controller;

<<<<<<< HEAD
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Session;
=======
>>>>>>> branch 'master' of https://github.com/inpaner/information-asset-registry.git
import view.MainFrame;
<<<<<<< HEAD
import view.eventhandling.CoreEvent;
import view.eventhandling.CoreListener;
import view.gui.page.MainPageBuilder;

=======
>>>>>>> branch 'master' of https://github.com/inpaner/information-asset-registry.git

public class MainController extends Controller{
    
    public MainController() {
<<<<<<< HEAD
    	MainPageBuilder builder = new MainPageBuilder();
    	builder.setLogoutListener(new Back());
    	builder.setLogsListener(new ViewLogs());
    	builder.setCoreListener(new MainMenu());
    	Driver.view.setPanel(builder.build());
=======
    	new MainFrame();
>>>>>>> branch 'master' of https://github.com/inpaner/information-asset-registry.git
    }

    // move to DeleteAssetController
    /*
    public void deleteAssetHandling(AssetEvent event) {
        JOptionPane.showConfirmDialog(Driver.view, "Are you sure you wish to delete these X pcs. assets?", "Confirm delete", JOptionPane.YES_NO_OPTION);
        
        // Deletion code here
    }
    */
    
    private class MainMenu implements CoreListener {
        @Override
        public void coreSelected(CoreEvent event) {
            new CoreListController(event.getCore());
        }
    }
    
    private class Back implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Session.currentUser().logOut();
            new LoginController();
        }
    }
    
    private class ViewLogs implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new LogController();
        }
    }
}

