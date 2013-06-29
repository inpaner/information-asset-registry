package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.BoxLayout;
import javax.swing.SpringLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;

public class MainFrame extends View {

	private JPanel contentPane;
	private JTable tableData;
	private JTextField txtSearchPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		tableData.setModel(new DefaultTableModel(
				new Object[][] {
						{ "Identifier", "Name", "Owner", "Custodian",
								"Date acquired" },
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
						"Identifier", "Name", "Owner", "Custodian",
						"Date acquired" }) {
			Class[] columnTypes = new Class[] { String.class, Object.class,
					Object.class, Object.class, Object.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, true, true,
					true, true };

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		tableData.getColumnModel().getColumn(0).setPreferredWidth(100);
		tableData.getColumnModel().getColumn(0).setMaxWidth(100);
		tableData.getColumnModel().getColumn(1).setPreferredWidth(180);
		tableData.getColumnModel().getColumn(1).setMaxWidth(180);
		tableData.getColumnModel().getColumn(2).setPreferredWidth(150);
		tableData.getColumnModel().getColumn(2).setMaxWidth(150);
		tableData.getColumnModel().getColumn(3).setPreferredWidth(150);
		tableData.getColumnModel().getColumn(3).setMaxWidth(150);
		tableData.getColumnModel().getColumn(4).setPreferredWidth(150);
		tableData.getColumnModel().getColumn(4).setMaxWidth(150);
		mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel choices = new JPanel();
		mainPanel.add(choices);

		JButton btnNewButton = new JButton("New asset");
		btnNewButton.setFocusable(false);
		choices.add(btnNewButton);

		JButton btnUpdateAsset = new JButton("Update asset");
		btnUpdateAsset.setFocusable(false);
		choices.add(btnUpdateAsset);

		JButton btnDeleteSelected = new JButton("Delete asset/s");
		btnDeleteSelected.setFocusable(false);
		choices.add(btnDeleteSelected);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		tableData
				.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		mainPanel.add(tableData);

		JPanel informationPanel = new JPanel();
		GridBagConstraints gbc_informationPanel = new GridBagConstraints();
		gbc_informationPanel.anchor = GridBagConstraints.SOUTHWEST;
		gbc_informationPanel.gridx = 0;
		gbc_informationPanel.gridy = 2;
		contentPane.add(informationPanel, gbc_informationPanel);

		JLabel lblYouHaveSelected = new JLabel();
		lblYouHaveSelected.setLabelFor(tableData);
		lblYouHaveSelected
				.setText("You have selected (15) rows, which is more rows than the current elements in the database.");
		lblYouHaveSelected.setFont(UIManager.getFont("Label.font"));
		lblYouHaveSelected.setBackground(SystemColor.menu);
		informationPanel.add(lblYouHaveSelected);
	}
}
