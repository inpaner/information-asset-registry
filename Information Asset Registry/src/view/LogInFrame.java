package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import view.eventhandling.LoginEvent;
import view.eventhandling.LoginListener;

import java.awt.Color;

public class LogInFrame extends View implements ActionListener, KeyListener {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField pwdLogin;
	private JLabel lblCompanyLogo;
	private JButton btnLogin;
	private LoginListener loginListener;
	private JLabel lblErrorMessage;

	/**
	 * Create the frame.
	 */
	public LogInFrame() {
		setResizable(false);
		setTitle("Asset management system");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(321, 300);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		JLabel lblUsername = new JLabel("Username");
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		sl_contentPane.putConstraint(SpringLayout.EAST, lblUsername, 0,
				SpringLayout.EAST, lblPassword);
		contentPane.add(lblPassword);

		txtUsername = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblUsername, 3,
				SpringLayout.NORTH, txtUsername);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtUsername, 79,
				SpringLayout.WEST, contentPane);
		txtUsername.setText("darrensapalo");
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);

		pwdLogin = new JPasswordField();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, txtUsername, -11,
				SpringLayout.NORTH, pwdLogin);
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblPassword, 3,
				SpringLayout.NORTH, pwdLogin);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblPassword, -6,
				SpringLayout.WEST, pwdLogin);
		sl_contentPane.putConstraint(SpringLayout.WEST, pwdLogin, 79,
				SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtUsername, 0,
				SpringLayout.EAST, pwdLogin);
		sl_contentPane.putConstraint(SpringLayout.NORTH, pwdLogin, 206,
				SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, pwdLogin, -11,
				SpringLayout.EAST, contentPane);
		pwdLogin.setText("dren");
		contentPane.add(pwdLogin);

		lblCompanyLogo = new JLabel("Small company logo for asset management");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblCompanyLogo, 0,
				SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblCompanyLogo, 8,
				SpringLayout.WEST, contentPane);
		contentPane.add(lblCompanyLogo);

		btnLogin = new JButton("Log in\r\n");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnLogin, -5,
				SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnLogin, -10,
				SpringLayout.EAST, contentPane);
		contentPane.add(btnLogin);

		lblErrorMessage = new JLabel("Error message here");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblErrorMessage, 4,
				SpringLayout.NORTH, btnLogin);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblErrorMessage, 0,
				SpringLayout.WEST, lblUsername);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblErrorMessage, -15,
				SpringLayout.WEST, btnLogin);
		lblErrorMessage.setForeground(Color.RED);
		lblErrorMessage.setVisible(false);
		contentPane.add(lblErrorMessage);

		txtUsername.addKeyListener(this);
		pwdLogin.addKeyListener(this);
		initializeListeners();
		setVisible(true);
	}

	private void initializeListeners() {
		btnLogin.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String username = txtUsername.getText();
		char[] password = pwdLogin.getPassword();

		if (loginListener != null) {
			LoginEvent event = new LoginEvent(username, password);
			loginListener.LoginPerformed(event);
		}
	}

	public void setLoginListener(LoginListener listener) {
		this.loginListener = listener;
	}

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
}
