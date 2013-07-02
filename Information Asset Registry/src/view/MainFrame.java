package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.FlowLayout;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;

import model.bean.Asset;
import model.bean.User;
import view.eventhandling.AssetEvent;
import view.eventhandling.AssetListener;
import view.eventhandling.LogListener;
import view.eventhandling.LogoutListener;

import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.BoxLayout;

import java.awt.Component;
import java.awt.BorderLayout;

public class MainFrame extends View implements ActionListener {

	private JPanel contentPane;
	private JTable tableData;
	private JTextField txtSearchPanel;
	private AssetListener assetListener;
	private LogListener logListener;
	private LogoutListener logoutListener;
	private DefaultTableModel tableModel;
	
	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setResizable(false);
		setTitle("Asset management system");
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
		gbl_contentPane.rowHeights = new int[] { 17, 458, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);
        mntmLogout.addActionListener(this);

		txtSearchPanel = new JTextField();
		txtSearchPanel.setText("Search here");
		GridBagConstraints gbc_txtSearchPanel = new GridBagConstraints();
		gbc_txtSearchPanel.insets = new Insets(0, 0, 5, 0);
		gbc_txtSearchPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSearchPanel.gridx = 0;
		gbc_txtSearchPanel.gridy = 0;
		contentPane.add(txtSearchPanel, gbc_txtSearchPanel);
		txtSearchPanel.setColumns(10);

		JPanel mainPanel = new JPanel();
		GridBagConstraints gbc_mainPanel = new GridBagConstraints();
		gbc_mainPanel.insets = new Insets(0, 0, 5, 0);
		gbc_mainPanel.fill = GridBagConstraints.BOTH;
		gbc_mainPanel.gridx = 0;
		gbc_mainPanel.gridy = 1;
		contentPane.add(mainPanel, gbc_mainPanel);

		tableData = new JTable();
		tableData.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
				null, null));
		tableModel = new DefaultTableModel(new Object[][] {
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null }, }, new String[] {
				"Identifier", "Name", "Owner", "Custodian", "Date acquired" }) {
			Class[] columnTypes = new Class[] { String.class, Object.class,
					Object.class, Object.class, Object.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			
			 public boolean isCellEditable(int row, int col)
		        { return false; }
		};
		
		tableData.setModel(tableModel);
		tableData.getColumnModel().getColumn(0).setPreferredWidth(130);
		tableData.getColumnModel().getColumn(0).setMinWidth(130);
		tableData.getColumnModel().getColumn(0).setMaxWidth(130);
		tableData.getColumnModel().getColumn(1).setPreferredWidth(200);
		tableData.getColumnModel().getColumn(1).setMinWidth(200);
		tableData.getColumnModel().getColumn(1).setMaxWidth(200);
		tableData.getColumnModel().getColumn(2).setPreferredWidth(150);
		tableData.getColumnModel().getColumn(2).setMinWidth(150);
		tableData.getColumnModel().getColumn(2).setMaxWidth(150);
		tableData.getColumnModel().getColumn(3).setPreferredWidth(150);
		tableData.getColumnModel().getColumn(3).setMinWidth(150);
		tableData.getColumnModel().getColumn(3).setMaxWidth(150);
		tableData.getColumnModel().getColumn(4).setPreferredWidth(150);
		tableData.getColumnModel().getColumn(4).setMinWidth(150);
		tableData.getColumnModel().getColumn(4).setMaxWidth(150);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		JPanel choices = new JPanel();
		mainPanel.add(choices);

		JButton btnNewButton = new JButton("New asset");
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(this);
		btnNewButton.setActionCommand("new");
		choices.add(btnNewButton);

		JButton btnUpdateAsset = new JButton("Update asset");
		btnUpdateAsset.setActionCommand("update");
		btnUpdateAsset.setFocusable(false);
		btnUpdateAsset.addActionListener(this);
		choices.add(btnUpdateAsset);

		JButton btnDeleteSelected = new JButton("Delete asset/s");
		btnDeleteSelected.setActionCommand("delete");
		btnDeleteSelected.setFocusable(false);
		btnDeleteSelected.addActionListener(this);
		choices.add(btnDeleteSelected);

		JButton btnLogs = new JButton("View logs");
		choices.add(btnLogs);
		btnLogs.setFocusable(false);
		btnLogs.setActionCommand("logs");
		btnLogs.addActionListener(this);
		
		tableData
				.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		// mainPanel.add(tableData);

		JPanel informationPanel = new JPanel();
		GridBagConstraints gbc_informationPanel = new GridBagConstraints();
		gbc_informationPanel.anchor = GridBagConstraints.SOUTHWEST;
		gbc_informationPanel.gridx = 0;
		gbc_informationPanel.gridy = 2;
		contentPane.add(informationPanel, gbc_informationPanel);

		JLabel lblYouHaveSelected = new JLabel();
		lblYouHaveSelected.setLabelFor(tableData);

		JScrollPane scrollPane = new JScrollPane(tableData);
		scrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		mainPanel.add(scrollPane);
		lblYouHaveSelected
				.setText("You have selected (15) rows, which is more rows than the current elements in the database.");
		lblYouHaveSelected.setFont(UIManager.getFont("Label.font"));
		lblYouHaveSelected.setBackground(SystemColor.menu);
		informationPanel.add(lblYouHaveSelected);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (assetListener != null) {
			String action = e.getActionCommand();
			if (action.equals("new")) {
				Asset asset = null;
				AssetEvent assetEvent = new AssetEvent(asset);
				assetListener.MoveToNewAssetHandling(assetEvent);
			} else if (action.equals("update")) {
				Asset asset = getSelectedAsset();
				AssetEvent assetEvent = new AssetEvent(asset);
				assetListener.MoveToUpdateAssetHandling(assetEvent);
			} else if (action.equals("delete")) {
				ArrayList<Asset> assets = getSelectedAssets();
				AssetEvent assetEvent = new AssetEvent(assets);
				assetListener.DeleteAssetHandling(assetEvent);
			} else if (action.equals("logs")) {
				assetListener.ViewLogsHandling();

				// Does not need to log that the user is viewing the logs...
				// AssetEvent assetEvent = new AssetEvent(assets);
				// assetListener.DeleteAssetHandling(assetEvent);
			}
		}
        
        if (logoutListener != null) {
        	String action = e.getActionCommand();
        	if (action.equals("Logout")) {
        		logoutListener.logout();
        	}
        }

	}

	private ArrayList<Asset> getSelectedAssets() {
		// TODO get the selected assets from the table. Can select more than
		// one.
		return null;
	}

	private Asset getSelectedAsset() {
		// TODO get the selected asset from the table. Should only select one.
		return null;
	}
	
	public void initialize(){
		LoadAssets();
	}

	private void LoadAssets() {
		Vector<Asset> assets = Asset.getAll();
		String[][] tableData = new String[assets.size()][5];
		
		// Clean up table
		while (tableModel.getRowCount() > 0)
			tableModel.removeRow(0);
		
		// Fill up table
		int i = 0;
		for (Asset a : assets){
			tableData[i][0] = a.identifier().toString();
			tableData[i][1] = a.name().toString();
			tableData[i][2] = a.owner().toString();
			tableData[i][3] = a.custodian().toString();
			tableData[i][4] = a.dateAcquired().toString();
			tableModel.addRow(tableData[i]);
			i++;
		}
	}

	public void setAssetListener(AssetListener assetListener) {
		this.assetListener = assetListener;
	}

    public void setLogoutListener(LogoutListener logoutListener) {
    	this.logoutListener = logoutListener;
    }
    
	public void setLogListener(LogListener listener) {
		this.logListener = listener;

	}
}
