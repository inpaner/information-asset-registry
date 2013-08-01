package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;


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

import model.Log;
import view.eventhandling.CoreEvent;
import view.eventhandling.CoreListener;
import view.eventhandling.ControlListener;
import view.eventhandling.LogListener;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ScrollPaneConstants;
import javax.swing.BoxLayout;

public class LogsFrame extends View implements ActionListener {

	private JPanel contentPane;
	private JTable tableData;
	private JTextField txtSearchPanel;
	private CoreListener coreListener;
	private LogListener logListener;
	private DefaultTableModel tableModel;
	private ControlListener controlListener;

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
		mntmLogout.setActionCommand("logout");
		mntmLogout.addActionListener(this);

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
		txtSearchPanel.setText("Search here - Not yet implemented");
		txtSearchPanel.setEnabled(false);
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
		tableModel = new DefaultTableModel(new Object[][] { { null },
				{ null }, { null }, { null }, { null }, { null }, { null },
				{ null }, { null }, { null }, { null }, { null }, { null },
				{ null }, { null }, { null }, { null }, { null }, { null },
				{ null }, { null }, { null }, { null }, { null }, { null }, },
				new String[] { "Log" }) {
			Class[] columnTypes = new Class[] { String.class };
			
			 public boolean isCellEditable(int row, int col)
		        { return false; }
			
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		};
		
		
		
	
		tableData.setModel(tableModel);
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
		if (logListener != null) {
			String action = e.getActionCommand();
			if (action.equals("back")){
				logListener.back(null);
			}
			else if (action.equals("logout")){
			}
		}
	}
	
	public void initialize(){
		ArrayList<Log> logs = Log.getAll();
		String[][] data = new String[logs.size()][1];
		
		// Remove all rows of logs
		while (tableModel.getRowCount() > 0)
			tableModel.removeRow(0);
		
		for (int i = 0; i < data.length; i++){
			data[i][0] = logs.get(i).plaintext();
			tableModel.addRow(data[i]);
		}
	}

	
	public void setAssetListener(CoreListener coreListener) {
		this.coreListener = coreListener;
	}

	public void setLogListener(LogListener listener) {
		this.logListener = listener;

	}

	public void setControlListener(ControlListener controlListener) {
		this.controlListener = controlListener;
	}
}
