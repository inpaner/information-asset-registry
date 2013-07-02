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
import view.eventhandling.AssetEvent;
import view.eventhandling.AssetListener;
import view.eventhandling.ControlListener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.Vector;

import javax.swing.BoxLayout;

public class ViewAssetFrame extends View implements ActionListener {
    private Asset asset;
    
	private JPanel contentPane;
	private JTextField txtIdentifierValue;
	private JTextField txtAssetNameValue;
	private JTextField txtOwnerNameValue;
	private JTextField txtCustodianNameValue;
	private JTextField txtDateAcquiredValue;
	private JTextField txtRetentionPeriodValue;
	private JTextField txtMaintenancePeriodValue;

	private AssetListener assetListener;
	private ControlListener logListener;

	private JLabel lblIdentifierError;
	private JLabel lblAssetNameError;
	private JLabel lblOwnerNameError;
	private JLabel lblCustodianNameError;
	private JLabel lblTypeOfAssetError;
	private JLabel lblDateAcquiredError;
	private JLabel lblRetentionPeriodError;
	private JLabel lblMaintenancePeriodError;
	private JLabel lblNotification;
	private JComboBox<String> comboBoxTypeOfClassification;

	private JComboBox<String> comboBoxTypeOfAsset;
	private JLabel lblConfidentialityValue;
	private JLabel lblIntegrityValue;
	private JLabel lblAvailability;

	private JComboBox<Integer> comboBoxFinancial;
	private JComboBox<Integer> comboBoxConfidentiality;
	private JComboBox<Integer> comboBoxIntegrity;
	private JComboBox<Integer> comboBoxAvailability;
	private JLabel lblStorage;
	private JTextField txtStorage;
	private JLabel lblStorageError;
	private JPanel infoPanel;
	private JLabel label;
	private JPanel panel;
	private ControlListener controlListener;

	/**
	 * Create the frame.
	 */
	public ViewAssetFrame() {
		setResizable(false);
		setTitle("Asset management system : Identifier - Asset Name");
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
		gbl_contentPane.rowWeights = new double[] { 1.0, 0.0, 1.0,
				Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		infoPanel = new JPanel();
		GridBagConstraints gbc_infoPanel = new GridBagConstraints();
		gbc_infoPanel.fill = GridBagConstraints.BOTH;
		gbc_infoPanel.gridx = 0;
		gbc_infoPanel.gridy = 0;
		contentPane.add(infoPanel, gbc_infoPanel);
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

		label = new JLabel();
		label.setText("Current asset: IDENTIFIER - NAME");
		infoPanel.add(label);

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

		JLabel lblIdentifier = new JLabel("Identifier *");
		lblIdentifier.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblIdentifier = new GridBagConstraints();
		gbc_lblIdentifier.insets = setting;
		gbc_lblIdentifier.anchor = GridBagConstraints.EAST;
		gbc_lblIdentifier.gridx = 0;
		gbc_lblIdentifier.gridy = 0;
		mainPanel.add(lblIdentifier, gbc_lblIdentifier);

		txtIdentifierValue = new JTextField();
		txtIdentifierValue.setEditable(false);
		txtIdentifierValue.setText("Identifier value");
		GridBagConstraints gbc_txtIdentifierValue = new GridBagConstraints();
		gbc_txtIdentifierValue.anchor = GridBagConstraints.NORTH;
		gbc_txtIdentifierValue.insets = setting;
		gbc_txtIdentifierValue.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIdentifierValue.gridx = 1;
		gbc_txtIdentifierValue.gridy = 0;
		mainPanel.add(txtIdentifierValue, gbc_txtIdentifierValue);
		txtIdentifierValue.setColumns(10);

		lblIdentifierError = new JLabel("identifier error");
		lblIdentifierError.setForeground(Color.RED);
		GridBagConstraints gbc_lblIdentifierError = new GridBagConstraints();
		gbc_lblIdentifierError.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblIdentifierError.insets = setting;
		gbc_lblIdentifierError.gridx = 2;
		gbc_lblIdentifierError.gridy = 0;
		mainPanel.add(lblIdentifierError, gbc_lblIdentifierError);

		JLabel lblNameOfAsset = new JLabel("Name of asset *");
		lblNameOfAsset.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNameOfAsset = new GridBagConstraints();
		gbc_lblNameOfAsset.anchor = GridBagConstraints.EAST;
		gbc_lblNameOfAsset.insets = setting;
		gbc_lblNameOfAsset.gridx = 0;
		gbc_lblNameOfAsset.gridy = 1;
		mainPanel.add(lblNameOfAsset, gbc_lblNameOfAsset);

		txtAssetNameValue = new JTextField();
		txtAssetNameValue.setText("Asset name value");
		GridBagConstraints gbc_txtAssetNameValue = new GridBagConstraints();
		gbc_txtAssetNameValue.anchor = GridBagConstraints.NORTH;
		gbc_txtAssetNameValue.insets = setting;
		gbc_txtAssetNameValue.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAssetNameValue.gridx = 1;
		gbc_txtAssetNameValue.gridy = 1;
		mainPanel.add(txtAssetNameValue, gbc_txtAssetNameValue);
		txtAssetNameValue.setColumns(10);

		lblAssetNameError = new JLabel("asset name error");
		lblAssetNameError.setForeground(Color.RED);
		GridBagConstraints gbc_lblAssetNameError = new GridBagConstraints();
		gbc_lblAssetNameError.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblAssetNameError.insets = setting;
		gbc_lblAssetNameError.gridx = 2;
		gbc_lblAssetNameError.gridy = 1;
		mainPanel.add(lblAssetNameError, gbc_lblAssetNameError);

		JLabel lblNameOfOwner = new JLabel("Name of owner *");
		lblNameOfOwner.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNameOfOwner = new GridBagConstraints();
		gbc_lblNameOfOwner.anchor = GridBagConstraints.EAST;
		gbc_lblNameOfOwner.insets = setting;
		gbc_lblNameOfOwner.gridx = 0;
		gbc_lblNameOfOwner.gridy = 2;
		mainPanel.add(lblNameOfOwner, gbc_lblNameOfOwner);

		txtOwnerNameValue = new JTextField();
		txtOwnerNameValue.setText("Owner name value");
		GridBagConstraints gbc_txtOwnerNameValue = new GridBagConstraints();
		gbc_txtOwnerNameValue.anchor = GridBagConstraints.NORTH;
		gbc_txtOwnerNameValue.insets = setting;
		gbc_txtOwnerNameValue.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtOwnerNameValue.gridx = 1;
		gbc_txtOwnerNameValue.gridy = 2;
		mainPanel.add(txtOwnerNameValue, gbc_txtOwnerNameValue);
		txtOwnerNameValue.setColumns(10);

		lblOwnerNameError = new JLabel("owner name error");
		lblOwnerNameError.setForeground(Color.RED);
		GridBagConstraints gbc_lblOwnerNameError = new GridBagConstraints();
		gbc_lblOwnerNameError.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblOwnerNameError.insets = setting;
		gbc_lblOwnerNameError.gridx = 2;
		gbc_lblOwnerNameError.gridy = 2;
		mainPanel.add(lblOwnerNameError, gbc_lblOwnerNameError);

		JLabel lblNameOfCustodian = new JLabel("Name of custodian *");
		lblNameOfCustodian.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNameOfCustodian = new GridBagConstraints();
		gbc_lblNameOfCustodian.anchor = GridBagConstraints.EAST;
		gbc_lblNameOfCustodian.insets = setting;
		gbc_lblNameOfCustodian.gridx = 0;
		gbc_lblNameOfCustodian.gridy = 3;
		mainPanel.add(lblNameOfCustodian, gbc_lblNameOfCustodian);

		txtCustodianNameValue = new JTextField();
		txtCustodianNameValue.setText("Custodian name value");
		GridBagConstraints gbc_txtCustodianNameValue = new GridBagConstraints();
		gbc_txtCustodianNameValue.anchor = GridBagConstraints.NORTH;
		gbc_txtCustodianNameValue.insets = setting;
		gbc_txtCustodianNameValue.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCustodianNameValue.gridx = 1;
		gbc_txtCustodianNameValue.gridy = 3;
		mainPanel.add(txtCustodianNameValue, gbc_txtCustodianNameValue);
		txtCustodianNameValue.setColumns(10);

		lblCustodianNameError = new JLabel("custodian name error");
		lblCustodianNameError.setForeground(Color.RED);
		GridBagConstraints gbc_lblCustodianNameError = new GridBagConstraints();
		gbc_lblCustodianNameError.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblCustodianNameError.insets = setting;
		gbc_lblCustodianNameError.gridx = 2;
		gbc_lblCustodianNameError.gridy = 3;
		mainPanel.add(lblCustodianNameError, gbc_lblCustodianNameError);

		JLabel lblTypeOfAsset = new JLabel("Type of asset");
		lblTypeOfAsset.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblTypeOfAsset = new GridBagConstraints();
		gbc_lblTypeOfAsset.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblTypeOfAsset.insets = setting;
		gbc_lblTypeOfAsset.gridx = 0;
		gbc_lblTypeOfAsset.gridy = 4;
		mainPanel.add(lblTypeOfAsset, gbc_lblTypeOfAsset);

		comboBoxTypeOfAsset = new JComboBox();
		GridBagConstraints gbc_comboBoxTypeOfAsset = new GridBagConstraints();
		gbc_comboBoxTypeOfAsset.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxTypeOfAsset.insets = setting;
		gbc_comboBoxTypeOfAsset.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxTypeOfAsset.gridx = 1;
		gbc_comboBoxTypeOfAsset.gridy = 4;
		mainPanel.add(comboBoxTypeOfAsset, gbc_comboBoxTypeOfAsset);

		lblTypeOfAssetError = new JLabel("type of asset error");
		lblTypeOfAssetError.setForeground(Color.RED);
		GridBagConstraints gbc_lblTypeOfAssetError = new GridBagConstraints();
		gbc_lblTypeOfAssetError.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblTypeOfAssetError.insets = setting;
		gbc_lblTypeOfAssetError.gridx = 2;
		gbc_lblTypeOfAssetError.gridy = 4;
		mainPanel.add(lblTypeOfAssetError, gbc_lblTypeOfAssetError);

		JLabel lblDateAcquired = new JLabel("Date acquired *");
		lblDateAcquired.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblDateAcquired = new GridBagConstraints();
		gbc_lblDateAcquired.anchor = GridBagConstraints.EAST;
		gbc_lblDateAcquired.insets = setting;
		gbc_lblDateAcquired.gridx = 0;
		gbc_lblDateAcquired.gridy = 5;
		mainPanel.add(lblDateAcquired, gbc_lblDateAcquired);

		txtDateAcquiredValue = new JTextField();
		txtDateAcquiredValue.setText("Date acquired value");
		GridBagConstraints gbc_txtDateAcquiredValue = new GridBagConstraints();
		gbc_txtDateAcquiredValue.anchor = GridBagConstraints.NORTH;
		gbc_txtDateAcquiredValue.insets = setting;
		gbc_txtDateAcquiredValue.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDateAcquiredValue.gridx = 1;
		gbc_txtDateAcquiredValue.gridy = 5;
		mainPanel.add(txtDateAcquiredValue, gbc_txtDateAcquiredValue);
		txtDateAcquiredValue.setColumns(10);

		lblDateAcquiredError = new JLabel("date acquired error");
		lblDateAcquiredError.setForeground(Color.RED);
		GridBagConstraints gbc_lblDateAcquiredError = new GridBagConstraints();
		gbc_lblDateAcquiredError.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblDateAcquiredError.insets = setting;
		gbc_lblDateAcquiredError.gridx = 2;
		gbc_lblDateAcquiredError.gridy = 5;
		mainPanel.add(lblDateAcquiredError, gbc_lblDateAcquiredError);

		JLabel lblRetentionPeriod = new JLabel("Retention period *");
		lblRetentionPeriod.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblRetentionPeriod = new GridBagConstraints();
		gbc_lblRetentionPeriod.anchor = GridBagConstraints.EAST;
		gbc_lblRetentionPeriod.insets = setting;
		gbc_lblRetentionPeriod.gridx = 0;
		gbc_lblRetentionPeriod.gridy = 6;
		mainPanel.add(lblRetentionPeriod, gbc_lblRetentionPeriod);

		txtRetentionPeriodValue = new JTextField();
		txtRetentionPeriodValue.setText("Retention period value");
		GridBagConstraints gbc_txtRetentionPeriodValue = new GridBagConstraints();
		gbc_txtRetentionPeriodValue.anchor = GridBagConstraints.NORTH;
		gbc_txtRetentionPeriodValue.insets = setting;
		gbc_txtRetentionPeriodValue.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRetentionPeriodValue.gridx = 1;
		gbc_txtRetentionPeriodValue.gridy = 6;
		mainPanel.add(txtRetentionPeriodValue, gbc_txtRetentionPeriodValue);
		txtRetentionPeriodValue.setColumns(10);

		lblRetentionPeriodError = new JLabel("retention period error");
		lblRetentionPeriodError.setForeground(Color.RED);
		GridBagConstraints gbc_lblRetentionPeriodError = new GridBagConstraints();
		gbc_lblRetentionPeriodError.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblRetentionPeriodError.insets = setting;
		gbc_lblRetentionPeriodError.gridx = 2;
		gbc_lblRetentionPeriodError.gridy = 6;
		mainPanel.add(lblRetentionPeriodError, gbc_lblRetentionPeriodError);

		JLabel lblMaintenancePeriod = new JLabel("Maintenance period");
		GridBagConstraints gbc_lblMaintenancePeriod = new GridBagConstraints();
		gbc_lblMaintenancePeriod.anchor = GridBagConstraints.EAST;
		gbc_lblMaintenancePeriod.insets = setting;
		gbc_lblMaintenancePeriod.gridx = 0;
		gbc_lblMaintenancePeriod.gridy = 7;
		mainPanel.add(lblMaintenancePeriod, gbc_lblMaintenancePeriod);

		txtMaintenancePeriodValue = new JTextField();
		txtMaintenancePeriodValue.setText("Maintenance period value");
		GridBagConstraints gbc_txtMaintenancePeriodValue = new GridBagConstraints();
		gbc_txtMaintenancePeriodValue.anchor = GridBagConstraints.NORTH;
		gbc_txtMaintenancePeriodValue.insets = setting;
		gbc_txtMaintenancePeriodValue.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMaintenancePeriodValue.gridx = 1;
		gbc_txtMaintenancePeriodValue.gridy = 7;
		mainPanel.add(txtMaintenancePeriodValue, gbc_txtMaintenancePeriodValue);
		txtMaintenancePeriodValue.setColumns(10);

		lblMaintenancePeriodError = new JLabel("maintenance period error");
		lblMaintenancePeriodError.setForeground(Color.RED);
		GridBagConstraints gbc_lblMaintenancePeriodError = new GridBagConstraints();
		gbc_lblMaintenancePeriodError.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblMaintenancePeriodError.insets = setting;
		gbc_lblMaintenancePeriodError.gridx = 2;
		gbc_lblMaintenancePeriodError.gridy = 7;
		mainPanel.add(lblMaintenancePeriodError, gbc_lblMaintenancePeriodError);

		lblStorage = new JLabel("Storage *");
		GridBagConstraints gbc_lblStorage = new GridBagConstraints();
		gbc_lblStorage.anchor = GridBagConstraints.EAST;
		gbc_lblStorage.insets = setting;
		gbc_lblStorage.gridx = 0;
		gbc_lblStorage.gridy = 8;
		mainPanel.add(lblStorage, gbc_lblStorage);

		txtStorage = new JTextField();
		txtStorage.setText("Storage value");
		txtStorage.setColumns(10);
		GridBagConstraints gbc_txtStorage = new GridBagConstraints();
		gbc_txtStorage.anchor = GridBagConstraints.NORTH;
		gbc_txtStorage.insets = setting;
		gbc_txtStorage.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtStorage.gridx = 1;
		gbc_txtStorage.gridy = 8;
		mainPanel.add(txtStorage, gbc_txtStorage);

		lblStorageError = new JLabel("storage error");
		lblStorageError.setForeground(Color.RED);
		GridBagConstraints gbc_lblStorageError = new GridBagConstraints();
		gbc_lblStorageError.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblStorageError.insets = new Insets(0, 0, 5, 0);
		gbc_lblStorageError.gridx = 2;
		gbc_lblStorageError.gridy = 8;
		mainPanel.add(lblStorageError, gbc_lblStorageError);

		JLabel lblFinancialValue = new JLabel("Financial value");
		GridBagConstraints gbc_lblFinancialValue = new GridBagConstraints();
		gbc_lblFinancialValue.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblFinancialValue.insets = setting;
		gbc_lblFinancialValue.gridx = 0;
		gbc_lblFinancialValue.gridy = 9;
		mainPanel.add(lblFinancialValue, gbc_lblFinancialValue);

		comboBoxFinancial = new JComboBox<Integer>();
		GridBagConstraints gbc_comboBoxFinancial = new GridBagConstraints();
		gbc_comboBoxFinancial.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxFinancial.insets = setting;
		gbc_comboBoxFinancial.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxFinancial.gridx = 1;
		gbc_comboBoxFinancial.gridy = 9;
		mainPanel.add(comboBoxFinancial, gbc_comboBoxFinancial);

		lblConfidentialityValue = new JLabel("Confidentiality value");
		GridBagConstraints gbc_lblConfidentialityValue = new GridBagConstraints();
		gbc_lblConfidentialityValue.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblConfidentialityValue.insets = setting;
		gbc_lblConfidentialityValue.gridx = 0;
		gbc_lblConfidentialityValue.gridy = 10;
		mainPanel.add(lblConfidentialityValue, gbc_lblConfidentialityValue);

		comboBoxConfidentiality = new JComboBox<Integer>();
		GridBagConstraints gbc_comboBoxConfidentiality = new GridBagConstraints();
		gbc_comboBoxConfidentiality.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxConfidentiality.insets = setting;
		gbc_comboBoxConfidentiality.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxConfidentiality.gridx = 1;
		gbc_comboBoxConfidentiality.gridy = 10;
		mainPanel.add(comboBoxConfidentiality, gbc_comboBoxConfidentiality);

		lblIntegrityValue = new JLabel("Integrity value");
		GridBagConstraints gbc_lblIntegrityValue = new GridBagConstraints();
		gbc_lblIntegrityValue.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblIntegrityValue.insets = setting;
		gbc_lblIntegrityValue.gridx = 0;
		gbc_lblIntegrityValue.gridy = 11;
		mainPanel.add(lblIntegrityValue, gbc_lblIntegrityValue);

		comboBoxIntegrity = new JComboBox<Integer>();
		GridBagConstraints gbc_comboBoxIntegrity = new GridBagConstraints();
		gbc_comboBoxIntegrity.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxIntegrity.insets = setting;
		gbc_comboBoxIntegrity.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxIntegrity.gridx = 1;
		gbc_comboBoxIntegrity.gridy = 11;
		mainPanel.add(comboBoxIntegrity, gbc_comboBoxIntegrity);

		lblAvailability = new JLabel("Availability value");
		GridBagConstraints gbc_lblAvailability = new GridBagConstraints();
		gbc_lblAvailability.anchor = GridBagConstraints.EAST;
		gbc_lblAvailability.insets = setting;
		gbc_lblAvailability.gridx = 0;
		gbc_lblAvailability.gridy = 12;
		mainPanel.add(lblAvailability, gbc_lblAvailability);

		comboBoxAvailability = new JComboBox<Integer>();
		GridBagConstraints gbc_comboBoxAvailability = new GridBagConstraints();
		gbc_comboBoxAvailability.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxAvailability.insets = setting;
		gbc_comboBoxAvailability.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxAvailability.gridx = 1;
		gbc_comboBoxAvailability.gridy = 12;
		mainPanel.add(comboBoxAvailability, gbc_comboBoxAvailability);

		JLabel lblClassification = new JLabel("Classification");
		GridBagConstraints gbc_lblClassification = new GridBagConstraints();
		gbc_lblClassification.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblClassification.insets = setting;
		gbc_lblClassification.gridx = 0;
		gbc_lblClassification.gridy = 13;
		mainPanel.add(lblClassification, gbc_lblClassification);

		comboBoxTypeOfClassification = new JComboBox<String>();
		GridBagConstraints gbc_comboBoxTypeOfClassification = new GridBagConstraints();
		gbc_comboBoxTypeOfClassification.insets = new Insets(0, 0, 10, 10);
		gbc_comboBoxTypeOfClassification.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxTypeOfClassification.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxTypeOfClassification.gridx = 1;
		gbc_comboBoxTypeOfClassification.gridy = 13;
		mainPanel.add(comboBoxTypeOfClassification,
				gbc_comboBoxTypeOfClassification);

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

		JButton btnSave = new JButton("Save");
		panel.add(btnSave);
		btnSave.setFocusable(false);
		btnSave.setActionCommand("save");
		btnSave.addActionListener(this);
	}

	public void setAssetListener(AssetListener assetListener) {
		this.assetListener = assetListener;
	}

	private void eraseAllErrors() {
		lblIdentifierError.setText("");
		lblAssetNameError.setText("");
		lblOwnerNameError.setText("");
		lblCustodianNameError.setText("");
		lblTypeOfAssetError.setText("");
		lblDateAcquiredError.setText("");
		lblRetentionPeriodError.setText("");
		lblMaintenancePeriodError.setText("");
		lblStorageError.setText("");
	}

	private void cleanForm() {
		txtIdentifierValue.setText("");
		txtAssetNameValue.setText("");
		txtOwnerNameValue.setText("");
		txtCustodianNameValue.setText("");
		txtDateAcquiredValue.setText("");
		txtRetentionPeriodValue.setText("");
		txtMaintenancePeriodValue.setText("");
		txtStorage.setText("");
	}

	public void loadChoices() {
		loadTypes();
		loadValues();
		loadClassification();

	}

	private void loadValues() {
		Vector<Integer> validValues = RateableAttribute.validValues();
		comboBoxConfidentiality.removeAllItems();
		comboBoxIntegrity.removeAllItems();
		comboBoxAvailability.removeAllItems();
		comboBoxFinancial.removeAllItems();
		for (Integer value : validValues) {
		    comboBoxConfidentiality.addItem(value);
            comboBoxIntegrity.addItem(value);
            comboBoxAvailability.addItem(value);
            comboBoxFinancial.addItem(value);
		}
	}

	private void loadTypes() {
		comboBoxTypeOfAsset.removeAllItems();
		Vector<String> validValues = model.bean.Type.validValues();
		for (String value : validValues) {
		    comboBoxTypeOfAsset.addItem(value);
		}
	}

	private void loadClassification() {
		comboBoxTypeOfClassification.removeAllItems();
		Vector<String> validValues = Classification.validValues();
	      for (String value : validValues) {
	            comboBoxTypeOfClassification.addItem(value);
	        }
	}

	public void initializeNewAssetForm() {
	    this.asset = new Asset();
	    txtIdentifierValue.setEditable(true);
	    label.setText("Creating a new asset");
    	// Begin new form, erase all errors
    	eraseAllErrors();
    
    	// Begin new form, erase all form inputs
    	cleanForm();
    
    	// Load choices
    	loadChoices();
    
    }

    public void initializeUpdateAssetForm(Asset asset) {
		this.asset = asset;
		label.setText("Updating asset: [" + asset.identifier() + "] " + asset.name() );
	    txtIdentifierValue.setEditable(true);
		eraseAllErrors();
		loadChoices();

		
		
		// Assign values to the text fields
		String identifier = asset.identifier().toString();
		txtIdentifierValue.setText(identifier);

		String name = asset.name().toString();
		txtAssetNameValue.setText(name);

		String owner = asset.owner().toString();
		txtOwnerNameValue.setText(owner);

		String custodian = asset.custodian().toString();
		txtCustodianNameValue.setText(custodian);

		String date = asset.dateAcquired().toString();
		txtDateAcquiredValue.setText(date);

		String retention = asset.retentionPeriod().toString();
		txtRetentionPeriodValue.setText(retention);

		String maintenance = "HEHE WALA PA"; // TODO We are missing maintenance
												// period text field on asset
												// object
		txtMaintenancePeriodValue.setText(maintenance);

		String storage = asset.storage().toString();
		txtStorage.setText(storage);
	}

	public void setLogListener(ControlListener listener) {
		this.logListener = listener;

	}

	public void actionPerformed(ActionEvent e) {
		if (assetListener != null) {
			if (e.getActionCommand().equals("back")) {
				assetListener.goToMain();

			} else if (e.getActionCommand().equals("save")) {
				if (hasErrors(asset) == false) {
					AssetEvent event = new AssetEvent(asset);
					assetListener.savedAsset(event);
					lblNotification.setText("Asset successfully saved.");
				}
			}
		}
	}

	private boolean hasErrors(Asset asset) {
		boolean hasErrors = false;

		int availability = (int) comboBoxAvailability.getSelectedItem();
		asset.setAvailability(availability);

		String classification = comboBoxTypeOfClassification.getSelectedItem()
				.toString();
		asset.setClassification(classification);

		int confidentiality = (int) comboBoxConfidentiality.getSelectedItem();
		asset.setConfidentiality(confidentiality);

		String custodian = txtCustodianNameValue.getText();
		asset.setCustodian(custodian);

		int financial = (int) comboBoxFinancial.getSelectedItem();
		asset.setFinancial(financial);

		String identifier = txtIdentifierValue.getText();
		asset.setIdentifier(identifier);

		int integrity = (int) comboBoxIntegrity.getSelectedItem();
		asset.setIntegrity(integrity);
		
		System.out.println("here");
		String name = txtAssetNameValue.getText();
		asset.setName(name);

		String owner = txtOwnerNameValue.getText();
		asset.setOwner(owner);

		String dateAcquired = txtDateAcquiredValue.getText();
		try {
			asset.setDateAcquired(dateAcquired);
		} catch (RegException e) {
			hasErrors = true;
			lblDateAcquiredError.setText(e.getMessage());
		}

		String retentionPeriod = txtRetentionPeriodValue.getText();
		try {
			asset.setRetentionPeriod(retentionPeriod);
		} catch (RegException e) {
			hasErrors = true;
			lblRetentionPeriodError.setText(e.getMessage());
		}

		String storage = txtStorage.getText();
		asset.setStorage(storage);

		String type = comboBoxTypeOfAsset.getSelectedItem().toString();
		asset.setType(type);

		if (txtStorage.getText().isEmpty()) {
			hasErrors = true;
			lblStorageError.setText("Required field");
		}
		if (txtAssetNameValue.getText().isEmpty()) {
			hasErrors = true;
			lblAssetNameError.setText("Required field");
		}

		if (txtOwnerNameValue.getText().isEmpty()) {
			hasErrors = true;
			lblOwnerNameError.setText("Required field");
		}

		if (txtIdentifierValue.getText().isEmpty()) {
			hasErrors = true;
			lblIdentifierError.setText("Required field");
		}

		if (txtCustodianNameValue.getText().isEmpty()) {
			hasErrors = true;
			lblCustodianNameError.setText("Required field");
		}

		return hasErrors;
	}

	public void setControlListener(ControlListener controlListener) {
		this.controlListener = controlListener;
	}
}
