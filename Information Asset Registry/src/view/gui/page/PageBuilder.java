package view.gui.page;

import view.eventhandling.LoginListener;

public abstract class PageBuilder {
	public abstract Page BuildPage();

	public static PageBuilder AssignLoginBuilder(LoginListener loginListener) {
		return new LoginPageBuilder(loginListener);
	}
	
	
}
