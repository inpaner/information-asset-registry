package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Core;
import model.Log;
import model.RegException;
import model.Session;
import view.AddCoreFrame;
import view.ViewCoreFrame;
import view.ViewCoreListFrame;
import view.eventhandling.CoreEvent;
import view.eventhandling.CoreListener;
import view.gui.content.CoreForm;
import view.gui.page.AddCorePageBuilder;
import view.gui.page.MainPageBuilder;

public class AddCoreController extends Controller {
    
    public AddCoreController(Core core) {
        AddCorePageBuilder builder = new AddCorePageBuilder(core);
        builder.setBackListener(new Back());
        builder.setCoreListener(new AddCore());
        Driver.view.setPanel(builder.build());
    }
    
    private class AddCore implements CoreListener {
        @Override
        public void coreSelected(CoreEvent event) {
            CoreForm form = event.getForm();
            if (form.setFields()) {
                Core core = event.getCore();
                core.add();
                new MainController();
                // TODO show success
                
            }
            
        }
    }
    
    private class Back implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new MainController();
        }
    }
    
}
