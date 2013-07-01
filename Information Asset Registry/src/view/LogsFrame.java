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

import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JScrollBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.BorderLayout;

public class LogsFrame extends View implements ActionListener {

	private JPanel contentPane;
	private JTable tableData;
	private JTextField txtSearchPanel;
	private AssetListener assetListener;
	private LogListener logListener;

	/**
	 * Create the frame.
	 */
	public LogsFrame() {
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
		tableData.setModel(new DefaultTableModel(new Object[][] { { null },
				{ null }, { null }, { null }, { null }, { null }, { null },
				{ null }, { null }, { null }, { null }, { null }, { null },
				{ null }, { null }, { null }, { null }, { null }, { null },
				{ null }, { null }, { null }, { null }, { null }, { null }, },
				new String[] { "Log" }) {
			Class[] columnTypes = new Class[] { String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableData.getColumnModel().getColumn(0).setPreferredWidth(780);
		tableData.getColumnModel().getColumn(0).setMinWidth(780);
		tableData.getColumnModel().getColumn(0).setMaxWidth(780);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		tableData
				.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		// mainPanel.add(tableData);

		JPanel informationPanel = new JPanel();
		GridBagConstraints gbc_informationPanel = new GridBagConstraints();
		gbc_informationPanel.anchor = GridBagConstraints.SOUTHWEST;
		gbc_informationPanel.gridx = 0;
		gbc_informationPanel.gridy = 2;
		contentPane.add(informationPanel, gbc_informationPanel);

		JButton btnBack = new JButton("Back to main menu");
		informationPanel.add(btnBack);
		btnBack.setFocusable(false);
		btnBack.addActionListener(this);
		btnBack.setActionCommand("back");
		

		JScrollPane scrollPane = new JScrollPane(tableData);
		scrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		mainPanel.add(scrollPane);
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
			}else if (action.equals("back")){
				assetListener.ReturnToMain();
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

	public void setAssetListener(AssetListener assetListener) {
		this.assetListener = assetListener;
	}

	public void setLogListener(LogListener listener) {
		this.logListener = listener;

	}
}
