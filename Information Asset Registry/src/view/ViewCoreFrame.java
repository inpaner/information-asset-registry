package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Core;
import view.eventhandling.CoreListener;
import view.gui.page.PageBuilder;
import controller.Driver;

public class ViewCoreFrame implements ActionListener {

    public ViewCoreFrame(Core core, CoreListener coreListener){
        Driver.view.setPanel ( PageBuilder.AssignViewCorePageBuilder(core, coreListener) );
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
