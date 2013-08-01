package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Core;
import view.eventhandling.CoreEvent;
import view.eventhandling.CoreListener;
import view.gui.content.CoreForm;
import view.gui.page.AddCorePageBuilder;
import view.gui.page.EditCorePageBuilder;

public class EditCoreController extends Controller {
	
	public EditCoreController(Core core) {
		EditCorePageBuilder builder = new EditCorePageBuilder(core);
        builder.setBackListener(new Back());
        builder.setCoreListener(new EditCore());
        Driver.view.setPanel(builder.build());
	}

    private class EditCore implements CoreListener {
        @Override
        public void coreSelected(CoreEvent event) {
            CoreForm form = event.getForm();
            if (form.setFields()) {
                Core core = event.getCore();
                core.edit();
                core.commit();
                new CoreListController(core);
                // TODO show success
            }
        }
    }
	
    private class Back implements CoreListener {
        @Override
        public void coreSelected(CoreEvent event) {
            Core core = event.getCore();
            core.reset();
            new MainController();
        }
    }
    
}
