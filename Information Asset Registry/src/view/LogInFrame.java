package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import model.bean.User;

public class LogInFrame extends View implements ActionListener {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField pwdLogin;
	private JLabel lblNewLabel;
	private JButton btnLogin;
	private LoginListener loginListener;


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
		sl_contentPane.putConstraint(SpringLayout.WEST, lblUsername, 8,
				SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblUsername, -38,
				SpringLayout.SOUTH, contentPane);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblPassword, 0,
				SpringLayout.WEST, lblUsername);
		contentPane.add(lblPassword);

		txtUsername = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, txtUsername, -3,
				SpringLayout.NORTH, lblUsername);
		sl_contentPane.putConstraint(SpringLayout.WEST, txtUsername, 11,
				SpringLayout.EAST, lblUsername);
		sl_contentPane.putConstraint(SpringLayout.EAST, txtUsername, 137,
				SpringLayout.EAST, lblUsername);
		txtUsername.setText("darrensapalo");
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);

		pwdLogin = new JPasswordField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, pwdLogin, -3,
				SpringLayout.NORTH, lblPassword);
		sl_contentPane.putConstraint(SpringLayout.WEST, pwdLogin, 13,
				SpringLayout.EAST, lblPassword);
		sl_contentPane.putConstraint(SpringLayout.EAST, pwdLogin, 0,
				SpringLayout.EAST, txtUsername);
		pwdLogin.setText("dren");
		contentPane.add(pwdLogin);

		lblNewLabel = new JLabel("Small company logo for asset management");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 0,
				SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 0,
				SpringLayout.WEST, lblUsername);
		contentPane.add(lblNewLabel);

		btnLogin = new JButton("Log in\r\n");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblPassword, 4,
				SpringLayout.NORTH, btnLogin);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnLogin, -5,
				SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnLogin, -10,
				SpringLayout.EAST, contentPane);
		contentPane.add(btnLogin);

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
		// TODO There should be a JLabel indicating the type of error.
		
	}
}
