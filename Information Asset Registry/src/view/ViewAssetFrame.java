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
import model.bean.RateableAttribute;
import model.bean.Type;
import view.eventhandling.AssetEvent;
import view.eventhandling.AssetListener;
import view.eventhandling.LogListener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.Vector;

import javax.swing.BoxLayout;

public class ViewAssetFrame extends View implements ActionListener {

	private JPanel contentPane;
	private JTextField txtIdentifierValue;
	private JTextField txtAssetNameValue;
	private JTextField txtOwnerNameValue;
	private JTextField txtCustodianNameValue;
	private JTextField txtDateAcquiredValue;
	private JTextField txtRetentionPeriodValue;
	private JTextField txtMaintenancePeriodValue;

	private AssetListener assetListener;
	private LogListener logListener;

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
	private JPanel donePanel;

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
		gbl_contentPane.rowHeights = new int[] { 31, 428, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		infoPanel = new JPanel();
		GridBagConstraints gbc_infoPanel = new GridBagConstraints();
		gbc_infoPanel.insets = new Insets(0, 0, 5, 0);
		gbc_infoPanel.fill = GridBagConstraints.BOTH;
		gbc_infoPanel.gridx = 0;
		gbc_infoPanel.gridy = 0;
		contentPane.add(infoPanel, gbc_infoPanel);
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

		label = new JLabel();
		label.setText("Current asset: IDENTIFIER - NAME");
		infoPanel.add(label);

		lblNotification = new JLabel(
				"Please be informed that your actions are logged as Darren Sapalo.");
		infoPanel.add(lblNotification);
		lblNotification.setFont(lblNotification.getFont().deriveFont(
				lblNotification.getFont().getStyle() | Font.ITALIC));

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

		JLabel lblIdentifier = new JLabel("Identifier");
		lblIdentifier.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblIdentifier = new GridBagConstraints();
		gbc_lblIdentifier.insets = new Insets(0, 0, 20, 20);
		gbc_lblIdentifier.anchor = GridBagConstraints.EAST;
		gbc_lblIdentifier.gridx = 0;
		gbc_lblIdentifier.gridy = 0;
		mainPanel.add(lblIdentifier, gbc_lblIdentifier);

		txtIdentifierValue = new JTextField();
		txtIdentifierValue.setEditable(false);
		txtIdentifierValue.setText("Identifier value");
		GridBagConstraints gbc_txtIdentifierValue = new GridBagConstraints();
		gbc_txtIdentifierValue.anchor = GridBagConstraints.NORTH;
		gbc_txtIdentifierValue.insets = new Insets(0, 0, 5, 5);
		gbc_txtIdentifierValue.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIdentifierValue.gridx = 1;
		gbc_txtIdentifierValue.gridy = 0;
		mainPanel.add(txtIdentifierValue, gbc_txtIdentifierValue);
		txtIdentifierValue.setColumns(10);

		lblIdentifierError = new JLabel("identifier error");
		lblIdentifierError.setForeground(Color.RED);
		GridBagConstraints gbc_lblIdentifierError = new GridBagConstraints();
		gbc_lblIdentifierError.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblIdentifierError.insets = new Insets(0, 0, 5, 0);
		gbc_lblIdentifierError.gridx = 2;
		gbc_lblIdentifierError.gridy = 0;
		mainPanel.add(lblIdentifierError, gbc_lblIdentifierError);

		JLabel lblNameOfAsset = new JLabel("Name of asset");
		lblNameOfAsset.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNameOfAsset = new GridBagConstraints();
		gbc_lblNameOfAsset.anchor = GridBagConstraints.EAST;
		gbc_lblNameOfAsset.insets = new Insets(0, 0, 20, 20);
		gbc_lblNameOfAsset.gridx = 0;
		gbc_lblNameOfAsset.gridy = 1;
		mainPanel.add(lblNameOfAsset, gbc_lblNameOfAsset);

		txtAssetNameValue = new JTextField();
		txtAssetNameValue.setText("Asset name value");
		GridBagConstraints gbc_txtAssetNameValue = new GridBagConstraints();
		gbc_txtAssetNameValue.anchor = GridBagConstraints.NORTH;
		gbc_txtAssetNameValue.insets = new Insets(0, 0, 5, 5);
		gbc_txtAssetNameValue.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAssetNameValue.gridx = 1;
		gbc_txtAssetNameValue.gridy = 1;
		mainPanel.add(txtAssetNameValue, gbc_txtAssetNameValue);
		txtAssetNameValue.setColumns(10);

		lblAssetNameError = new JLabel("asset name error");
		lblAssetNameError.setForeground(Color.RED);
		GridBagConstraints gbc_lblAssetNameError = new GridBagConstraints();
		gbc_lblAssetNameError.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblAssetNameError.insets = new Insets(0, 0, 5, 0);
		gbc_lblAssetNameError.gridx = 2;
		gbc_lblAssetNameError.gridy = 1;
		mainPanel.add(lblAssetNameError, gbc_lblAssetNameError);

		JLabel lblNameOfOwner = new JLabel("Name of owner");
		lblNameOfOwner.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNameOfOwner = new GridBagConstraints();
		gbc_lblNameOfOwner.anchor = GridBagConstraints.EAST;
		gbc_lblNameOfOwner.insets = new Insets(0, 0, 20, 20);
		gbc_lblNameOfOwner.gridx = 0;
		gbc_lblNameOfOwner.gridy = 2;
		mainPanel.add(lblNameOfOwner, gbc_lblNameOfOwner);

		txtOwnerNameValue = new JTextField();
		txtOwnerNameValue.setText("Owner name value");
		GridBagConstraints gbc_txtOwnerNameValue = new GridBagConstraints();
		gbc_txtOwnerNameValue.anchor = GridBagConstraints.NORTH;
		gbc_txtOwnerNameValue.insets = new Insets(0, 0, 5, 5);
		gbc_txtOwnerNameValue.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtOwnerNameValue.gridx = 1;
		gbc_txtOwnerNameValue.gridy = 2;
		mainPanel.add(txtOwnerNameValue, gbc_txtOwnerNameValue);
		txtOwnerNameValue.setColumns(10);

		lblOwnerNameError = new JLabel("owner name error");
		lblOwnerNameError.setForeground(Color.RED);
		GridBagConstraints gbc_lblOwnerNameError = new GridBagConstraints();
		gbc_lblOwnerNameError.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblOwnerNameError.insets = new Insets(0, 0, 5, 0);
		gbc_lblOwnerNameError.gridx = 2;
		gbc_lblOwnerNameError.gridy = 2;
		mainPanel.add(lblOwnerNameError, gbc_lblOwnerNameError);

		JLabel lblNameOfCustodian = new JLabel("Name of custodian");
		lblNameOfCustodian.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNameOfCustodian = new GridBagConstraints();
		gbc_lblNameOfCustodian.anchor = GridBagConstraints.EAST;
		gbc_lblNameOfCustodian.insets = new Insets(0, 0, 20, 20);
		gbc_lblNameOfCustodian.gridx = 0;
		gbc_lblNameOfCustodian.gridy = 3;
		mainPanel.add(lblNameOfCustodian, gbc_lblNameOfCustodian);

		txtCustodianNameValue = new JTextField();
		txtCustodianNameValue.setText("Custodian name value");
		GridBagConstraints gbc_txtCustodianNameValue = new GridBagConstraints();
		gbc_txtCustodianNameValue.anchor = GridBagConstraints.NORTH;
		gbc_txtCustodianNameValue.insets = new Insets(0, 0, 5, 5);
		gbc_txtCustodianNameValue.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCustodianNameValue.gridx = 1;
		gbc_txtCustodianNameValue.gridy = 3;
		mainPanel.add(txtCustodianNameValue, gbc_txtCustodianNameValue);
		txtCustodianNameValue.setColumns(10);

		lblCustodianNameError = new JLabel("custodian name error");
		lblCustodianNameError.setForeground(Color.RED);
		GridBagConstraints gbc_lblCustodianNameError = new GridBagConstraints();
		gbc_lblCustodianNameError.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblCustodianNameError.insets = new Insets(0, 0, 5, 0);
		gbc_lblCustodianNameError.gridx = 2;
		gbc_lblCustodianNameError.gridy = 3;
		mainPanel.add(lblCustodianNameError, gbc_lblCustodianNameError);

		JLabel lblTypeOfAsset = new JLabel("Type of asset");
		lblTypeOfAsset.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblTypeOfAsset = new GridBagConstraints();
		gbc_lblTypeOfAsset.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblTypeOfAsset.insets = new Insets(0, 0, 20, 20);
		gbc_lblTypeOfAsset.gridx = 0;
		gbc_lblTypeOfAsset.gridy = 4;
		mainPanel.add(lblTypeOfAsset, gbc_lblTypeOfAsset);

		comboBoxTypeOfAsset = new JComboBox();
		GridBagConstraints gbc_comboBoxTypeOfAsset = new GridBagConstraints();
		gbc_comboBoxTypeOfAsset.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxTypeOfAsset.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxTypeOfAsset.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxTypeOfAsset.gridx = 1;
		gbc_comboBoxTypeOfAsset.gridy = 4;
		mainPanel.add(comboBoxTypeOfAsset, gbc_comboBoxTypeOfAsset);

		lblTypeOfAssetError = new JLabel("type of asset error");
		lblTypeOfAssetError.setForeground(Color.RED);
		GridBagConstraints gbc_lblTypeOfAssetError = new GridBagConstraints();
		gbc_lblTypeOfAssetError.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblTypeOfAssetError.insets = new Insets(0, 0, 5, 0);
		gbc_lblTypeOfAssetError.gridx = 2;
		gbc_lblTypeOfAssetError.gridy = 4;
		mainPanel.add(lblTypeOfAssetError, gbc_lblTypeOfAssetError);

		JLabel lblDateAcquired = new JLabel("Date acquired");
		lblDateAcquired.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblDateAcquired = new GridBagConstraints();
		gbc_lblDateAcquired.anchor = GridBagConstraints.EAST;
		gbc_lblDateAcquired.insets = new Insets(0, 0, 20, 20);
		gbc_lblDateAcquired.gridx = 0;
		gbc_lblDateAcquired.gridy = 5;
		mainPanel.add(lblDateAcquired, gbc_lblDateAcquired);

		txtDateAcquiredValue = new JTextField();
		txtDateAcquiredValue.setText("Date acquired value");
		GridBagConstraints gbc_txtDateAcquiredValue = new GridBagConstraints();
		gbc_txtDateAcquiredValue.anchor = GridBagConstraints.NORTH;
		gbc_txtDateAcquiredValue.insets = new Insets(0, 0, 5, 5);
		gbc_txtDateAcquiredValue.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDateAcquiredValue.gridx = 1;
		gbc_txtDateAcquiredValue.gridy = 5;
		mainPanel.add(txtDateAcquiredValue, gbc_txtDateAcquiredValue);
		txtDateAcquiredValue.setColumns(10);

		lblDateAcquiredError = new JLabel("date acquired error");
		lblDateAcquiredError.setForeground(Color.RED);
		GridBagConstraints gbc_lblDateAcquiredError = new GridBagConstraints();
		gbc_lblDateAcquiredError.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblDateAcquiredError.insets = new Insets(0, 0, 5, 0);
		gbc_lblDateAcquiredError.gridx = 2;
		gbc_lblDateAcquiredError.gridy = 5;
		mainPanel.add(lblDateAcquiredError, gbc_lblDateAcquiredError);

		JLabel lblRetentionPeriod = new JLabel("Retention period");
		lblRetentionPeriod.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblRetentionPeriod = new GridBagConstraints();
		gbc_lblRetentionPeriod.anchor = GridBagConstraints.EAST;
		gbc_lblRetentionPeriod.insets = new Insets(0, 0, 20, 20);
		gbc_lblRetentionPeriod.gridx = 0;
		gbc_lblRetentionPeriod.gridy = 6;
		mainPanel.add(lblRetentionPeriod, gbc_lblRetentionPeriod);

		txtRetentionPeriodValue = new JTextField();
		txtRetentionPeriodValue.setText("Retention period value");
		GridBagConstraints gbc_txtRetentionPeriodValue = new GridBagConstraints();
		gbc_txtRetentionPeriodValue.anchor = GridBagConstraints.NORTH;
		gbc_txtRetentionPeriodValue.insets = new Insets(0, 0, 5, 5);
		gbc_txtRetentionPeriodValue.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRetentionPeriodValue.gridx = 1;
		gbc_txtRetentionPeriodValue.gridy = 6;
		mainPanel.add(txtRetentionPeriodValue, gbc_txtRetentionPeriodValue);
		txtRetentionPeriodValue.setColumns(10);

		lblRetentionPeriodError = new JLabel("retention period error");
		lblRetentionPeriodError.setForeground(Color.RED);
		GridBagConstraints gbc_lblRetentionPeriodError = new GridBagConstraints();
		gbc_lblRetentionPeriodError.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblRetentionPeriodError.insets = new Insets(0, 0, 5, 0);
		gbc_lblRetentionPeriodError.gridx = 2;
		gbc_lblRetentionPeriodError.gridy = 6;
		mainPanel.add(lblRetentionPeriodError, gbc_lblRetentionPeriodError);

		JLabel lblMaintenancePeriod = new JLabel("Maintenance period");
		GridBagConstraints gbc_lblMaintenancePeriod = new GridBagConstraints();
		gbc_lblMaintenancePeriod.anchor = GridBagConstraints.EAST;
		gbc_lblMaintenancePeriod.insets = new Insets(0, 0, 20, 20);
		gbc_lblMaintenancePeriod.gridx = 0;
		gbc_lblMaintenancePeriod.gridy = 7;
		mainPanel.add(lblMaintenancePeriod, gbc_lblMaintenancePeriod);

		txtMaintenancePeriodValue = new JTextField();
		txtMaintenancePeriodValue.setText("Maintenance period value");
		GridBagConstraints gbc_txtMaintenancePeriodValue = new GridBagConstraints();
		gbc_txtMaintenancePeriodValue.anchor = GridBagConstraints.NORTH;
		gbc_txtMaintenancePeriodValue.insets = new Insets(0, 0, 5, 5);
		gbc_txtMaintenancePeriodValue.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMaintenancePeriodValue.gridx = 1;
		gbc_txtMaintenancePeriodValue.gridy = 7;
		mainPanel.add(txtMaintenancePeriodValue, gbc_txtMaintenancePeriodValue);
		txtMaintenancePeriodValue.setColumns(10);

		lblMaintenancePeriodError = new JLabel("maintenance period error");
		lblMaintenancePeriodError.setForeground(Color.RED);
		GridBagConstraints gbc_lblMaintenancePeriodError = new GridBagConstraints();
		gbc_lblMaintenancePeriodError.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblMaintenancePeriodError.insets = new Insets(0, 0, 5, 0);
		gbc_lblMaintenancePeriodError.gridx = 2;
		gbc_lblMaintenancePeriodError.gridy = 7;
		mainPanel.add(lblMaintenancePeriodError, gbc_lblMaintenancePeriodError);

		lblStorage = new JLabel("Storage");
		GridBagConstraints gbc_lblStorage = new GridBagConstraints();
		gbc_lblStorage.anchor = GridBagConstraints.EAST;
		gbc_lblStorage.insets = new Insets(0, 0, 20, 20);
		gbc_lblStorage.gridx = 0;
		gbc_lblStorage.gridy = 8;
		mainPanel.add(lblStorage, gbc_lblStorage);

		txtStorage = new JTextField();
		txtStorage.setText("Storage value");
		txtStorage.setColumns(10);
		GridBagConstraints gbc_txtStorage = new GridBagConstraints();
		gbc_txtStorage.anchor = GridBagConstraints.NORTH;
		gbc_txtStorage.insets = new Insets(0, 0, 5, 5);
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
		gbc_lblFinancialValue.insets = new Insets(0, 0, 20, 20);
		gbc_lblFinancialValue.gridx = 0;
		gbc_lblFinancialValue.gridy = 9;
		mainPanel.add(lblFinancialValue, gbc_lblFinancialValue);

		comboBoxFinancial = new JComboBox();
		GridBagConstraints gbc_comboBoxFinancial = new GridBagConstraints();
		gbc_comboBoxFinancial.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxFinancial.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxFinancial.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxFinancial.gridx = 1;
		gbc_comboBoxFinancial.gridy = 9;
		mainPanel.add(comboBoxFinancial, gbc_comboBoxFinancial);

		lblConfidentialityValue = new JLabel("Confidentiality value");
		GridBagConstraints gbc_lblConfidentialityValue = new GridBagConstraints();
		gbc_lblConfidentialityValue.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblConfidentialityValue.insets = new Insets(0, 0, 20, 20);
		gbc_lblConfidentialityValue.gridx = 0;
		gbc_lblConfidentialityValue.gridy = 10;
		mainPanel.add(lblConfidentialityValue, gbc_lblConfidentialityValue);

		comboBoxConfidentiality = new JComboBox();
		GridBagConstraints gbc_comboBoxConfidentiality = new GridBagConstraints();
		gbc_comboBoxConfidentiality.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxConfidentiality.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxConfidentiality.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxConfidentiality.gridx = 1;
		gbc_comboBoxConfidentiality.gridy = 10;
		mainPanel.add(comboBoxConfidentiality, gbc_comboBoxConfidentiality);

		lblIntegrityValue = new JLabel("Integrity value");
		GridBagConstraints gbc_lblIntegrityValue = new GridBagConstraints();
		gbc_lblIntegrityValue.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblIntegrityValue.insets = new Insets(0, 0, 20, 20);
		gbc_lblIntegrityValue.gridx = 0;
		gbc_lblIntegrityValue.gridy = 11;
		mainPanel.add(lblIntegrityValue, gbc_lblIntegrityValue);

		comboBoxIntegrity = new JComboBox();
		GridBagConstraints gbc_comboBoxIntegrity = new GridBagConstraints();
		gbc_comboBoxIntegrity.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxIntegrity.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxIntegrity.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxIntegrity.gridx = 1;
		gbc_comboBoxIntegrity.gridy = 11;
		mainPanel.add(comboBoxIntegrity, gbc_comboBoxIntegrity);

		lblAvailability = new JLabel("Availability value");
		GridBagConstraints gbc_lblAvailability = new GridBagConstraints();
		gbc_lblAvailability.anchor = GridBagConstraints.EAST;
		gbc_lblAvailability.insets = new Insets(0, 0, 20, 20);
		gbc_lblAvailability.gridx = 0;
		gbc_lblAvailability.gridy = 12;
		mainPanel.add(lblAvailability, gbc_lblAvailability);

		comboBoxAvailability = new JComboBox();
		GridBagConstraints gbc_comboBoxAvailability = new GridBagConstraints();
		gbc_comboBoxAvailability.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxAvailability.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxAvailability.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxAvailability.gridx = 1;
		gbc_comboBoxAvailability.gridy = 12;
		mainPanel.add(comboBoxAvailability, gbc_comboBoxAvailability);

		JLabel lblClassification = new JLabel("Classification");
		GridBagConstraints gbc_lblClassification = new GridBagConstraints();
		gbc_lblClassification.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblClassification.insets = new Insets(0, 0, 20, 20);
		gbc_lblClassification.gridx = 0;
		gbc_lblClassification.gridy = 13;
		mainPanel.add(lblClassification, gbc_lblClassification);

		comboBoxTypeOfClassification = new JComboBox();
		GridBagConstraints gbc_comboBoxTypeOfClassification = new GridBagConstraints();
		gbc_comboBoxTypeOfClassification.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxTypeOfClassification.insets = new Insets(0, 0, 0, 5);
		gbc_comboBoxTypeOfClassification.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxTypeOfClassification.gridx = 1;
		gbc_comboBoxTypeOfClassification.gridy = 13;
		mainPanel.add(comboBoxTypeOfClassification,
				gbc_comboBoxTypeOfClassification);

		donePanel = new JPanel();
		GridBagConstraints gbc_donePanel = new GridBagConstraints();
		gbc_donePanel.fill = GridBagConstraints.BOTH;
		gbc_donePanel.gridx = 2;
		gbc_donePanel.gridy = 13;
		mainPanel.add(donePanel, gbc_donePanel);
		donePanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		JButton btnCancel = new JButton("Cancel");
		donePanel.add(btnCancel);
		btnCancel.setFocusable(false);
		btnCancel.addActionListener(this);
		btnCancel.setActionCommand("back");

		JButton btnSave = new JButton("Save");
		donePanel.add(btnSave);
		btnSave.setFocusable(false);
		btnSave.setActionCommand("save");
		btnSave.addActionListener(this);
	}

	public void setAssetListener(AssetListener assetListener) {
		this.assetListener = assetListener;
	}

	public void InitializeNewAssetForm() {
		txtIdentifierValue.setEditable(true);

		// Begin new form, erase all errors
		lblIdentifierError.setText("");
		lblAssetNameError.setText("");
		lblOwnerNameError.setText("");
		lblCustodianNameError.setText("");
		lblTypeOfAssetError.setText("");
		lblDateAcquiredError.setText("");
		lblRetentionPeriodError.setText("");
		lblMaintenancePeriodError.setText("");
		lblNotification.setText("");

		// Begin new form, erase all form inputs
		txtIdentifierValue.setText("");
		txtAssetNameValue.setText("");
		txtOwnerNameValue.setText("");
		txtCustodianNameValue.setText("");
		txtDateAcquiredValue.setText("");
		txtRetentionPeriodValue.setText("");
		txtMaintenancePeriodValue.setText("");

		// Load choices
		LoadChoices();

	}

	public void LoadChoices() {
		LoadTypes();
		LoadValues();
		LoadClassification();

	}

	private void LoadValues() {
		Vector<Integer> validValues = RateableAttribute.validValues();
		for (int i = 0; i < validValues.size(); i++) {
			comboBoxConfidentiality.addItem(validValues.elementAt(i));
			comboBoxIntegrity.addItem(validValues.elementAt(i));
			comboBoxAvailability.addItem(validValues.elementAt(i));
			comboBoxFinancial.addItem(validValues.elementAt(i));
		}
	}

	private void LoadTypes() {
		Vector<String> validValues = model.bean.Type.validValues();
		for (int i = 0; i < validValues.size(); i++)
			comboBoxTypeOfAsset.addItem(validValues.elementAt(i));
	}

	private void LoadClassification() {
		Vector<String> validValues = Classification.validValues();
		for (int i = 0; i < validValues.size(); i++)
			comboBoxTypeOfClassification.addItem(validValues.elementAt(i));
	}

	public void InitializeUpdateAssetForm(Asset asset) {
		txtIdentifierValue.setEditable(false);

	}

	public void setLogListener(LogListener listener) {
		this.logListener = listener;

	}

	public void actionPerformed(ActionEvent e) {
		if (assetListener != null) {
			if (e.getActionCommand().equals("back")) {
				assetListener.ReturnToMain();

			} else if (e.getActionCommand().equals("save")) {

				if (HasErrors() == false) {
					Asset asset = new Asset();

					int availability = comboBoxAvailability.getSelectedIndex();
					asset.setAvailability(availability);

					String classification = comboBoxTypeOfClassification
							.getSelectedItem().toString();
					asset.setClassification(classification);

					int confidentiality = (int) comboBoxConfidentiality
							.getSelectedItem();
					asset.setConfidentiality(confidentiality);

					String custodian = txtCustodianNameValue.getText();
					asset.setCustodian(custodian);

					Timestamp date;
					asset.setDateAcquired(date);	// TODO currently unset. Have to parse user's input text into time stamp

					int financial = (int) comboBoxFinancial.getSelectedItem();
					asset.setFinancial(financial);

					String identifier = txtIdentifierValue.getText();
					asset.setIdentifier(identifier);

					int integrity = (int) comboBoxIntegrity.getSelectedItem();
					asset.setIntegrity(integrity);

					String name = txtAssetNameValue.getText();
					asset.setName(name);

					String owner = txtOwnerNameValue.getText();
					asset.setOwner(owner);

					Timestamp retention;
					asset.setRetentionPeriod(retention);

					String storage = txtStorage.getText();
					asset.setStorage(storage);

					String type = comboBoxTypeOfAsset.getSelectedItem().toString();
					asset.setType(type);
					
					AssetEvent event = new AssetEvent(asset);
					assetListener.NewAssetHandling(event);
					assetListener.ReturnToMain();
				}
			}
		}
	}

	private boolean HasErrors() {
		// TODO Auto-generated method stub
		return false;
	}
}
