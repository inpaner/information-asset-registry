package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.Core;
import model.CoreUtil;

import view.ViewCoreListFrame;
import view.eventhandling.CoreEvent;
import view.eventhandling.CoreListener;
import view.gui.page.CoreListPageBuilder;
import view.gui.page.MainPageBuilder;


public class CoreListController extends Controller {
    private ViewCoreListFrame viewCoreListFrame;

    public CoreListController(Core core) {
    	ArrayList<Core> allCores = CoreUtil.getAll(core.getName());
        initialize(allCores);
    }

    public CoreListController(ArrayList<Core> cores) {
        initialize(cores);
    }

    private void initialize(ArrayList<Core> result) {
        CoreListPageBuilder builder = new CoreListPageBuilder(result);
        
        builder.setAddListener(new AddListener());
        builder.setUpdateListener(new UpdateListener());
        builder.setViewListener(new ViewListener());
        
        builder.setBackListener(new Back());
        Driver.view.setPanel(builder.build());
    }
    
    private class AddListener implements CoreListener {
        @Override
        public void coreSelected(CoreEvent event) {
            Core core = CoreUtil.getAddable(event.getCore().getName());
            new AddCoreController(core);
        }
    }
    
    private class ViewListener implements CoreListener {
        @Override
        public void coreSelected(CoreEvent event) {
            Core core = event.getCore();
            if (core != null)
                new ViewCoreController(core);
        }
    }
    
    private class UpdateListener implements CoreListener {
        @Override
        public void coreSelected(CoreEvent event) {
            Core core = event.getCore();
            if (core != null)
                new EditCoreController(core);
        }
    }
    
    private class Back implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new MainController();
        }
    }

    
}
