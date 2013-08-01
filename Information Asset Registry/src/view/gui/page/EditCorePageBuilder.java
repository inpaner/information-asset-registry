package view.gui.page;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.CoreListController;
import controller.EditCoreController;
import model.Core;
import view.eventhandling.CoreEvent;
import view.eventhandling.CoreListener;
import view.gui.ButtonFactory;
import view.gui.LabelFactory;
import view.gui.content.Content;
import view.gui.content.CoreForm;
import view.gui.content.contentbuilder.ContentBuilder;

public class EditCorePageBuilder extends PageBuilder implements ActionListener {
    private Core core;
    private CoreListener coreListener;
    private CoreListener backListener;
    private CoreForm coreForm;
    
	public EditCorePageBuilder(Core core) {
		this.core = core;
	}
	
	public void setBackListener(CoreListener listener) {
        backListener = listener;
    }

    public void setCoreListener(CoreListener listener) {
        coreListener = listener;
    }
    	
	
	@Override
	public void buildHeader(JPanel header) {
		header.add( LabelFactory.createHeader("Update " + CapitalizeCore(core)) );
		
	}

	@Override
	public Content createContent() {
       coreForm = ContentBuilder.buildEditForm(core);
        return coreForm;
	}

	@Override
	public void buildFooter(JPanel footer) {
		addButton("Back", footer, new BackButtonPressed());
		addButton("Edit", footer, new EditButtonPressed());
	}
    
	private class BackButtonPressed implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            CoreEvent event = new CoreEvent(core, coreForm);
            backListener.coreSelected(event);
        }
    }	
	
	private class EditButtonPressed implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            CoreEvent event = new CoreEvent(core, coreForm);
            coreListener.coreSelected(event);
        }
    }
	
	
	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
