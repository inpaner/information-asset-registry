package view.gui.page;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.User;
import view.eventhandling.LoginEvent;
import view.eventhandling.LoginListener;
import view.gui.ButtonFactory;
import view.gui.LabelFactory;
import view.gui.content.Content;
import view.gui.content.LoginForm;
import view.gui.content.contentbuilder.ContentBuilder;
import view.gui.content.form.field.Field;

public class LoginPageBuilder extends PageBuilder implements ActionListener, KeyListener{
	private LoginListener loginListener;
	private LoginForm content;
	private User user;
	
	public LoginPageBuilder(User user, LoginListener loginListener) {
		this.user = user;
		this.loginListener = loginListener;
	}

	public void BuildHeader(JPanel header) {
		header.add( LabelFactory.CreateHeader("Login page") );
	}


	public Content CreateContent() {
		content = ContentBuilder.BuildLoginForm(user);
		
		for(Field f : content.getFields())
			f.getInput().getComponent().addKeyListener(this);
		
		return content;
	}
	
	public void BuildFooter(JPanel footer) {
		JButton login = ButtonFactory.CreateButton("Login");
		login.addActionListener(this);
		footer.add(login);
	}
	
	

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER){
			actionPerformed(null);
		}
	}

	public void keyReleased(KeyEvent e) {
		
	}

	public void keyTyped(KeyEvent e) {
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		for(Field f : content.getFields())
			f.ResetErrorHandling();
		
		LoginForm content = (LoginForm)PageReference.getContent();
		content.setFields();
		
		if (loginListener != null) {
			LoginEvent event = new LoginEvent(user);
			loginListener.loginPerformed(event);
		}
		
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
