package view;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
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

import view.eventhandling.AssetListener;
import view.eventhandling.LogListener;

import java.awt.Color;

public class ViewAssetFrame extends View {

    private JPanel contentPane;
    private JLabel txtCurrentItem;
    private JTextField txtIdentifierValue;
    private JTextField txtAssetNameValue;
    private JTextField txtOwnerNameValue;
    private JTextField txtCustodianNameValue;
    private JTextField txtDateAcquiredValue;
    private JTextField txtRetentionPeriodValue;
    private JTextField txtMaintenancePeriodValue;

    private AssetListener assetListener;
    private LogListener logListener;

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
        gbl_contentPane.rowHeights = new int[] { 31, 428, 23, 32, 0 };
        gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
        gbl_contentPane.rowWeights = new double[] { 0.0, 1.0, 0.0, 1.0,
                Double.MIN_VALUE };
        contentPane.setLayout(gbl_contentPane);

        txtCurrentItem = new JLabel();
        txtCurrentItem.setText("Current asset: IDENTIFIER - NAME");
        GridBagConstraints gbc_txtCurrentItem = new GridBagConstraints();
        gbc_txtCurrentItem.insets = new Insets(0, 0, 5, 0);
        gbc_txtCurrentItem.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtCurrentItem.gridx = 0;
        gbc_txtCurrentItem.gridy = 0;
        contentPane.add(txtCurrentItem, gbc_txtCurrentItem);

        JPanel mainPanel = new JPanel();
        GridBagConstraints gbc_mainPanel = new GridBagConstraints();
        gbc_mainPanel.insets = new Insets(0, 0, 5, 0);
        gbc_mainPanel.fill = GridBagConstraints.BOTH;
        gbc_mainPanel.gridx = 0;
        gbc_mainPanel.gridy = 1;
        contentPane.add(mainPanel, gbc_mainPanel);
        GridBagLayout gbl_mainPanel = new GridBagLayout();
        gbl_mainPanel.columnWidths = new int[] { 0, 315, 212, 0 };
        gbl_mainPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        gbl_mainPanel.columnWeights = new double[] { 0.0, 1.0, 0.0,
                Double.MIN_VALUE };
        gbl_mainPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
                0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
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

        JLabel lblIdentifierError = new JLabel("identifier error");
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

        JLabel lblAssetNameError = new JLabel("asset name error");
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

        JLabel lblOwnerNameError = new JLabel("owner name error");
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

        JLabel lblCustodianNameError = new JLabel("custodian name error");
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

        JComboBox comboBoxTypeOfAsset = new JComboBox();
        GridBagConstraints gbc_comboBoxTypeOfAsset = new GridBagConstraints();
        gbc_comboBoxTypeOfAsset.anchor = GridBagConstraints.NORTH;
        gbc_comboBoxTypeOfAsset.insets = new Insets(0, 0, 5, 5);
        gbc_comboBoxTypeOfAsset.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxTypeOfAsset.gridx = 1;
        gbc_comboBoxTypeOfAsset.gridy = 4;
        mainPanel.add(comboBoxTypeOfAsset, gbc_comboBoxTypeOfAsset);

        JLabel lblTypeOfAssetError = new JLabel("type of asset error");
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

        JLabel lblDateAcquiredError = new JLabel("date acquired error");
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

        JLabel lblRetentionPeriodError = new JLabel("retention period error");
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

        JLabel lblMaintenancePeriodError = new JLabel(
                "maintenance period error");
        lblMaintenancePeriodError.setForeground(Color.RED);
        GridBagConstraints gbc_lblMaintenancePeriodError = new GridBagConstraints();
        gbc_lblMaintenancePeriodError.anchor = GridBagConstraints.NORTHWEST;
        gbc_lblMaintenancePeriodError.insets = new Insets(0, 0, 5, 0);
        gbc_lblMaintenancePeriodError.gridx = 2;
        gbc_lblMaintenancePeriodError.gridy = 7;
        mainPanel.add(lblMaintenancePeriodError, gbc_lblMaintenancePeriodError);

        JLabel lblValue = new JLabel("Value");
        GridBagConstraints gbc_lblValue = new GridBagConstraints();
        gbc_lblValue.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblValue.insets = new Insets(0, 0, 20, 20);
        gbc_lblValue.gridx = 0;
        gbc_lblValue.gridy = 8;
        mainPanel.add(lblValue, gbc_lblValue);

        JComboBox comboBoxTypeOfValue = new JComboBox();
        GridBagConstraints gbc_comboBoxTypeOfValue = new GridBagConstraints();
        gbc_comboBoxTypeOfValue.anchor = GridBagConstraints.NORTH;
        gbc_comboBoxTypeOfValue.insets = new Insets(0, 0, 5, 5);
        gbc_comboBoxTypeOfValue.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxTypeOfValue.gridx = 1;
        gbc_comboBoxTypeOfValue.gridy = 8;
        mainPanel.add(comboBoxTypeOfValue, gbc_comboBoxTypeOfValue);

        JLabel lblValueValueError = new JLabel("value value error");
        lblValueValueError.setForeground(Color.RED);
        GridBagConstraints gbc_lblValueValueError = new GridBagConstraints();
        gbc_lblValueValueError.anchor = GridBagConstraints.NORTHWEST;
        gbc_lblValueValueError.insets = new Insets(0, 0, 5, 0);
        gbc_lblValueValueError.gridx = 2;
        gbc_lblValueValueError.gridy = 8;
        mainPanel.add(lblValueValueError, gbc_lblValueValueError);

        JLabel lblClassification = new JLabel("Classification");
        GridBagConstraints gbc_lblClassification = new GridBagConstraints();
        gbc_lblClassification.anchor = GridBagConstraints.NORTHEAST;
        gbc_lblClassification.insets = new Insets(0, 0, 20, 20);
        gbc_lblClassification.gridx = 0;
        gbc_lblClassification.gridy = 9;
        mainPanel.add(lblClassification, gbc_lblClassification);

        JComboBox comboBoxTypeOfClassification = new JComboBox();
        GridBagConstraints gbc_comboBoxTypeOfClassification = new GridBagConstraints();
        gbc_comboBoxTypeOfClassification.anchor = GridBagConstraints.NORTH;
        gbc_comboBoxTypeOfClassification.insets = new Insets(0, 0, 0, 5);
        gbc_comboBoxTypeOfClassification.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxTypeOfClassification.gridx = 1;
        gbc_comboBoxTypeOfClassification.gridy = 9;
        mainPanel.add(comboBoxTypeOfClassification,
                gbc_comboBoxTypeOfClassification);

        JLabel lblClassficationError = new JLabel("classfication error");
        lblClassficationError.setForeground(Color.RED);
        GridBagConstraints gbc_lblClassficationError = new GridBagConstraints();
        gbc_lblClassficationError.anchor = GridBagConstraints.NORTHWEST;
        gbc_lblClassficationError.gridx = 2;
        gbc_lblClassficationError.gridy = 9;
        mainPanel.add(lblClassficationError, gbc_lblClassficationError);

        JLabel lblWarnings = new JLabel(
                "There was a problem with the form. You can only input 7 letter asset names and the owner must be a valid employee.");
        GridBagConstraints gbc_lblWarnings = new GridBagConstraints();
        gbc_lblWarnings.anchor = GridBagConstraints.EAST;
        gbc_lblWarnings.insets = new Insets(0, 0, 5, 0);
        gbc_lblWarnings.gridx = 0;
        gbc_lblWarnings.gridy = 2;
        contentPane.add(lblWarnings, gbc_lblWarnings);
        lblWarnings.setHorizontalAlignment(SwingConstants.LEFT);

        JPanel panel = new JPanel();
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.anchor = GridBagConstraints.EAST;
        gbc_panel.fill = GridBagConstraints.VERTICAL;
        gbc_panel.gridx = 0;
        gbc_panel.gridy = 3;
        contentPane.add(panel, gbc_panel);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblNotification = new JLabel(
                "Please be informed that your actions are logged as Darren Sapalo.");
        panel.add(lblNotification);
        lblNotification.setFont(lblNotification.getFont().deriveFont(
                lblNotification.getFont().getStyle() | Font.ITALIC));

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setFocusable(false);
        panel.add(btnCancel);

        JButton btnSave = new JButton("Save");
        btnSave.setFocusable(false);
        panel.add(btnSave);
    }

    public void setAssetListener(AssetListener assetListener) {
        this.assetListener = assetListener;
    }

    public void InitializeNewAssetForm() {
        txtIdentifierValue.setEditable(true);
    }

    public void InitializeUpdateAssetForm() {
        txtIdentifierValue.setEditable(false);

    }
    public void setLogListener(LogListener listener) {
        this.logListener = listener;

    }
}
