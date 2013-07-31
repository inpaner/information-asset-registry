package view.gui.page;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import view.eventhandling.LoginListener;
import view.gui.ButtonFactory;
import view.gui.LabelFactory;
import view.gui.content.Content;
import view.gui.content.contentbuilder.ContentBuilder;

public class LoginPageBuilder extends PageBuilder implements ActionListener, KeyListener{
	private LoginListener loginListener;
	
	public LoginPageBuilder(LoginListener loginListener) {
	this.loginListener = loginListener;
	}


	public void BuildHeader(JPanel header) {
		header.add( LabelFactory.CreateHeader("Login page") );
	}



	@Override
	public Content CreateContent() {
		// TODO Auto-generated method stub
		return ContentBuilder.BuildLoginForm();
	}
	
	public void BuildFooter(JPanel footer) {
		JButton login = ButtonFactory.CreateButton("Login");
		login.addActionListener(this);
		footer.add(login);
	}
	
	

	public void keyPressed(KeyEvent e) {
		
	}

	public void keyReleased(KeyEvent e) {
		
	}

	public void keyTyped(KeyEvent e) {
		
	}
	
	public void actionPerformed(ActionEvent e) {
		/*
		ContentReference.
		String username = txtUsername.getText();
		char[] password = pwdLogin.getPassword();

		if (loginListener != null) {
			LoginEvent event = new LoginEvent(username, password);
			loginListener.loginPerformed(event);
		}
		*/
	}


	
	// Listeners will be moved to page creation instead of the view
/*
	private void initializeListeners() {
		btnLogin.addActionListener(this);
	}

	@Override


	public void displayError(Exception e) {
		String errormessage = e.getMessage();
		lblErrorMessage.setVisible(true);
		lblErrorMessage.setText(errormessage);
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER)
			actionPerformed(null);
	}

	public void keyTyped(KeyEvent e) {
	}
*/
	
}
