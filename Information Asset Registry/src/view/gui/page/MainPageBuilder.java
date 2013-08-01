package view.gui.page;

import java.util.ArrayList;

import javax.swing.JPanel;

import model.Core;
import model.CoreUtil;
import view.eventhandling.CoreListener;
import view.gui.ButtonFactory;
import view.gui.LabelFactory;
import view.gui.content.BasicContent;
import view.gui.content.Content;

public class MainPageBuilder extends PageBuilder {
	private CoreListener coreListener;
	
	public MainPageBuilder(CoreListener coreListener) {
		this.coreListener = coreListener;
	}

	@Override
	public void BuildHeader(JPanel header) {
		header.add( LabelFactory.CreateHeader("Main menu") );
	}

	@Override
	public Content CreateContent() {
		BasicContent content = new BasicContent();
		content.add(LabelFactory.CreateLabel("Please select below which list you would like to view."));
		return content;
	}

	@Override
	public void BuildFooter(JPanel footer) {
		ArrayList<Core> models = CoreUtil.getModels();
		for(Core core : models){
			String name = core.getName();
			footer.add( ButtonFactory.CreateButton(name) );
		}
		

	}

}
