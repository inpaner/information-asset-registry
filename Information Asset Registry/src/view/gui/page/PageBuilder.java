package view.gui.page;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.Core;
import model.RegException;
import model.User;
import view.eventhandling.CoreListener;
import view.eventhandling.LoginListener;
import view.gui.ButtonFactory;
import view.gui.content.Content;

public abstract class PageBuilder implements ActionListener {
	protected Page PageReference;
	
	public final Page Build() throws RegException{
		PageReference = new Page();
		buildHeader(PageReference.getHeader());
		PageReference.setContent( createContent() );
		buildFooter(PageReference.getFooter());
		
		if (PageReference == null){
			throw new RegException("PageBuildingException: The page was not instantiated.");
		}
		PageReference.initialize();
		return PageReference;
	}
	
	/**
	 * This passes the panel for the header of the page.
	 * You may add labels and headers here using the LabelFactory.
	 * @param header 
	 */
	public abstract void buildHeader(JPanel header);
	
	/**
	 * This method requires the user to create a new Content
	 * object. 
	 */
	public abstract Content createContent();
	
	/**
	 * This method passes the panel for the footer of
	 * the page. You may add buttons here using the ButtonFactory.
	 * @param footer
	 */
	public abstract void buildFooter(JPanel footer);
	
	public String CapitalizeCore(Core core){
		String name = core.getName();
		name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
		return name;
	}
		
	public void addButton(String buttonTitle, JPanel panel){
		JButton button = null;
		button = ButtonFactory.createButton(buttonTitle);
		button.setActionCommand(buttonTitle.toLowerCase());
		button.addActionListener(this);
		panel.add(button);
	}

	public static PageBuilder assignLoginBuilder(User user, LoginListener loginListener) {
		return new LoginPageBuilder(user, loginListener);
	}

	public static PageBuilder assignCoreListPageBuilder(CoreListener coreListener, ArrayList<Core> core) {
		return new CoreListPageBuilder(coreListener, core);
	}

	public static PageBuilder assignMainPageBuilder() {
		return new MainPageBuilder();
	}
	
	public static PageBuilder AssignViewCorePageBuilder(Core core, CoreListener coreListener) {
		return new ViewCorePageBuilder(core, coreListener);
	}

	public static PageBuilder AssignAddCorePageBuilder(Core core, CoreListener coreListener) {
		return new AddCorePageBuilder(core, coreListener);
	}

	public static PageBuilder AssignEditCorePageBuilder(Core core, CoreListener coreListener) {
		return new EditCorePageBuilder(core, coreListener);
	}
	
	
}
