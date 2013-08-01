package view.gui.page;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.AddCoreController;
import controller.CoreListController;
import model.Core;
import model.CoreUtil;
import view.eventhandling.CoreEvent;
import view.eventhandling.CoreListener;
import view.gui.ButtonFactory;
import view.gui.LabelFactory;
import view.gui.content.Content;
import view.gui.content.CoreForm;
import view.gui.content.contentbuilder.ContentBuilder;

public class AddCorePageBuilder extends PageBuilder implements ActionListener {
	private Core core;
	private CoreListener coreListener;
    private CoreListener backListener;
    private CoreForm coreForm;
	
	public AddCorePageBuilder(Core core) {
		super();
		this.core = core;
	}

    public void setBackListener(CoreListener listener) {
        backListener = listener;
    }

    public void setCoreListener(CoreListener listener) {
        coreListener = listener;
    }
	
	public Page buildPage() {
		return new Page();
	}

	@Override
	public void buildHeader(JPanel header) {
		header.add(LabelFactory.createHeader("Add new " + CapitalizeCore(core)) );
	}

	@Override
	public Content createContent() {
	    coreForm = ContentBuilder.buildAddForm(core);
	    return coreForm;
	}

	@Override
	public void buildFooter(JPanel footer) {
		addButton("Back", footer, new BackButtonPressed());
		addButton("Add", footer, new CoreButtonPressed());
	}
	
	private class CoreButtonPressed implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            CoreEvent event = new CoreEvent(core, coreForm);
            coreListener.coreSelected(event);
        }
    }
	
    private class BackButtonPressed implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            CoreEvent event = new CoreEvent(core, coreForm);
            backListener.coreSelected(event);
        }
    }   	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	}
	
}
