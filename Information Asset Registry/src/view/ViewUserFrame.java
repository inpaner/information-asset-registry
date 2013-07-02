package view;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JComboBox;

import model.bean.Asset;
import model.bean.Classification;
import model.bean.Confidentiality;
import model.bean.Custodian;
import model.bean.Log;
import model.bean.RateableAttribute;
import model.bean.RegException;
import model.bean.Type;
import model.bean.User;
import view.eventhandling.AssetEvent;
import view.eventhandling.AssetListener;
import view.eventhandling.ControlListener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.Vector;

import javax.swing.BoxLayout;

public class ViewUserFrame extends View implements ActionListener {

	private JPanel contentPane;
	private JTextField txtIdentifierValue;
	private JTextField txtAssetNameValue;
	private JTextField txtOwnerNameValue;

	private ControlListener logListener;

	private JLabel lblUsernameError;
	private JLabel lblPasswordError;
	private JLabel lblPassword2Error;
	private JLabel lblUserGroupError;
	private JLabel lblNotification;

	private JComboBox<String> comboBoxUserGroup;
	private JPanel infoPanel;
	private JLabel lblRegisterANew;
	private JPanel panel;
	private ControlListener controlListener;

	/**
	 * Create the frame.
	 */
	public ViewUserFrame() {
		setResizable(false);
		setTitle("Asset management system : Register a new user");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmLogout = new JMenuItem("Logout");
		mnFile.add(mntmLogout);

		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		JMenuItem mntmAboutTheDevelopers = new JMenuItem("About the developers");
		mnHelp.add(mntmAboutTheDevelopers);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 675, 0 };
		gbl_contentPane.rowHeights = new int[] { 30, 428, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 1.0, 1.0,
				Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		infoPanel = new JPanel();
		GridBagConstraints gbc_infoPanel = new GridBagConstraints();
		gbc_infoPanel.fill = GridBagConstraints.BOTH;
		gbc_infoPanel.gridx = 0;
		gbc_infoPanel.gridy = 0;
		contentPane.add(infoPanel, gbc_infoPanel);
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

		lblRegisterANew = new JLabel();
		lblRegisterANew
				.setText("Register a new user to manage the information asset registry.");
		infoPanel.add(lblRegisterANew);

		JPanel mainPanel = new JPanel();
		GridBagConstraints gbc_mainPanel = new GridBagConstraints();
		gbc_mainPanel.fill = GridBagConstraints.BOTH;
		gbc_mainPanel.gridx = 0;
		gbc_mainPanel.gridy = 1;
		contentPane.add(mainPanel, gbc_mainPanel);
		GridBagLayout gbl_mainPanel = new GridBagLayout();
		gbl_mainPanel.columnWidths = new int[] { 0, 315, 212, 0 };
		gbl_mainPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 30, 0 };
		gbl_mainPanel.columnWeights = new double[] { 0.0, 1.0, 1.0,
				Double.MIN_VALUE };
		gbl_mainPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		mainPanel.setLayout(gbl_mainPanel);

		Insets setting = new Insets(0, 0, 10, 10);

		JLabel lblUsername = new JLabel("Username *");
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.insets = setting;
		gbc_lblUsername.anchor = GridBagConstraints.EAST;
		gbc_lblUsername.gridx = 0;
		gbc_lblUsername.gridy = 0;
		mainPanel.add(lblUsername, gbc_lblUsername);

		txtIdentifierValue = new JTextField();
		txtIdentifierValue.setEditable(false);
		txtIdentifierValue.setText("Username value");
		GridBagConstraints gbc_txtIdentifierValue = new GridBagConstraints();
		gbc_txtIdentifierValue.anchor = GridBagConstraints.NORTH;
		gbc_txtIdentifierValue.insets = setting;
		gbc_txtIdentifierValue.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIdentifierValue.gridx = 1;
		gbc_txtIdentifierValue.gridy = 0;
		mainPanel.add(txtIdentifierValue, gbc_txtIdentifierValue);
		txtIdentifierValue.setColumns(10);

		lblUsernameError = new JLabel("Username error");
		lblUsernameError.setForeground(Color.RED);
		GridBagConstraints gbc_lblUsernameError = new GridBagConstraints();
		gbc_lblUsernameError.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblUsernameError.insets = setting;
		gbc_lblUsernameError.gridx = 2;
		gbc_lblUsernameError.gridy = 0;
		mainPanel.add(lblUsernameError, gbc_lblUsernameError);

		JLabel lblPassword = new JLabel("Password *");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.insets = setting;
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 1;
		mainPanel.add(lblPassword, gbc_lblPassword);

		txtAssetNameValue = new JTextField();
		txtAssetNameValue.setText("Password value");
		GridBagConstraints gbc_txtAssetNameValue = new GridBagConstraints();
		gbc_txtAssetNameValue.anchor = GridBagConstraints.NORTH;
		gbc_txtAssetNameValue.insets = setting;
		gbc_txtAssetNameValue.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAssetNameValue.gridx = 1;
		gbc_txtAssetNameValue.gridy = 1;
		mainPanel.add(txtAssetNameValue, gbc_txtAssetNameValue);
		txtAssetNameValue.setColumns(10);

		lblPasswordError = new JLabel("password error");
		lblPasswordError.setForeground(Color.RED);
		GridBagConstraints gbc_lblPasswordError = new GridBagConstraints();
		gbc_lblPasswordError.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblPasswordError.insets = setting;
		gbc_lblPasswordError.gridx = 2;
		gbc_lblPasswordError.gridy = 1;
		mainPanel.add(lblPasswordError, gbc_lblPasswordError);

		JLabel lblPassword2 = new JLabel("Password again *");
		lblPassword2.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblPassword2 = new GridBagConstraints();
		gbc_lblPassword2.anchor = GridBagConstraints.EAST;
		gbc_lblPassword2.insets = setting;
		gbc_lblPassword2.gridx = 0;
		gbc_lblPassword2.gridy = 2;
		mainPanel.add(lblPassword2, gbc_lblPassword2);

		txtOwnerNameValue = new JTextField();
		txtOwnerNameValue.setText("Password value again");
		GridBagConstraints gbc_txtOwnerNameValue = new GridBagConstraints();
		gbc_txtOwnerNameValue.anchor = GridBagConstraints.NORTH;
		gbc_txtOwnerNameValue.insets = setting;
		gbc_txtOwnerNameValue.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtOwnerNameValue.gridx = 1;
		gbc_txtOwnerNameValue.gridy = 2;
		mainPanel.add(txtOwnerNameValue, gbc_txtOwnerNameValue);
		txtOwnerNameValue.setColumns(10);

		lblPassword2Error = new JLabel("password 2 error");
		lblPassword2Error.setForeground(Color.RED);
		GridBagConstraints gbc_lblPassword2Error = new GridBagConstraints();
		gbc_lblPassword2Error.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblPassword2Error.insets = setting;
		gbc_lblPassword2Error.gridx = 2;
		gbc_lblPassword2Error.gridy = 2;
		mainPanel.add(lblPassword2Error, gbc_lblPassword2Error);

		JLabel lblUserGroup = new JLabel("User group *");
		lblUserGroup.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblUserGroup = new GridBagConstraints();
		gbc_lblUserGroup.anchor = GridBagConstraints.EAST;
		gbc_lblUserGroup.insets = setting;
		gbc_lblUserGroup.gridx = 0;
		gbc_lblUserGroup.gridy = 3;
		mainPanel.add(lblUserGroup, gbc_lblUserGroup);

		comboBoxUserGroup = new JComboBox();
		GridBagConstraints gbc_comboBoxUserGroup = new GridBagConstraints();
		gbc_comboBoxUserGroup.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxUserGroup.insets = setting;
		gbc_comboBoxUserGroup.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxUserGroup.gridx = 1;
		gbc_comboBoxUserGroup.gridy = 3;
		mainPanel.add(comboBoxUserGroup, gbc_comboBoxUserGroup);

		lblUserGroupError = new JLabel("user group error");
		lblUserGroupError.setForeground(Color.RED);
		GridBagConstraints gbc_lblUserGroupError = new GridBagConstraints();
		gbc_lblUserGroupError.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblUserGroupError.insets = setting;
		gbc_lblUserGroupError.gridx = 2;
		gbc_lblUserGroupError.gridy = 3;
		mainPanel.add(lblUserGroupError, gbc_lblUserGroupError);

		panel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		contentPane.add(panel, gbc_panel);

		lblNotification = new JLabel(
				"Please be informed that your actions are logged as Darren Sapalo.");
		panel.add(lblNotification);
		lblNotification.setFont(lblNotification.getFont().deriveFont(
				lblNotification.getFont().getStyle() | Font.ITALIC));

		JButton btnCancel = new JButton("Cancel");
		panel.add(btnCancel);
		btnCancel.setFocusable(false);
		btnCancel.addActionListener(this);
		btnCancel.setActionCommand("back");

		JButton btnSave = new JButton("Add user - not yet implemented");
		btnSave.setEnabled(false);
		panel.add(btnSave);
		btnSave.setFocusable(false);
		btnSave.setActionCommand("save");
		btnSave.addActionListener(this);
	}

	public void InitializeNewUserForm() {
		txtIdentifierValue.setEditable(true);

		// Begin new form, erase all errors
		eraseAllErrors();

		// Begin new form, erase all form inputs
		cleanForm();

		// Load choices
		loadUserGroups();

	}

	private void eraseAllErrors() {
		lblUsernameError.setText("");
		lblPasswordError.setText("");
		lblPassword2Error.setText("");
		lblUserGroupError.setText("");
	}

	private void cleanForm() {
		txtIdentifierValue.setText("");
		txtAssetNameValue.setText("");
		txtOwnerNameValue.setText("");
	}

	public void loadUserGroups() {

	}

	public void setLogListener(ControlListener listener) {
		this.logListener = listener;

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("back")) {
			controlListener.GoToMain();
		} else if (e.getActionCommand().equals("save")) {

		}
	}

	private boolean HasErrors(User user) {
		boolean hasErrors = false;

		return hasErrors;
	}

	public void setControlListener(ControlListener controlListener) {
		this.controlListener = controlListener;
	}
}
