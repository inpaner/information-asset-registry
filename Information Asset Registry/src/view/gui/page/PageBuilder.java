package view.gui.page;
import javax.swing.JPanel;

import model.RegException;
import model.User;
import view.eventhandling.AssetListener;
import view.eventhandling.LoginListener;
import view.gui.content.Content;

public abstract class PageBuilder {
	protected Page PageReference;
	
	public final Page Build() throws RegException{
		PageReference = new Page();
		BuildHeader(PageReference.getHeader());
		PageReference.setContent( CreateContent() );
		BuildFooter(PageReference.getFooter());
		
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
	public abstract void BuildHeader(JPanel header);
	
	/**
	 * This method requires the user to create a new Content
	 * object. 
	 */
	public abstract Content CreateContent();
	
	/**
	 * This method passes the panel for the footer of
	 * the page. You may add buttons here using the ButtonFactory.
	 * @param footer
	 */
	public abstract void BuildFooter(JPanel footer);

	public static PageBuilder AssignLoginBuilder(User user, LoginListener loginListener) {
		return new LoginPageBuilder(user, loginListener);
	}

	public static PageBuilder AssignAssetListPageBuilder(AssetListener assetListener) {
		return new AssetListPageBuilder(assetListener);
	}
	
	
}
