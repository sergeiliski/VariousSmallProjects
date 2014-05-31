package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import util.DataUtils;
import util.OutputUtil;
import domain.Crawler;

/**
 * This code was edited or generated using CloudGarden's Jigloo
 * SWT/Swing GUI Builder, which is free for non-commercial
 * use. If Jigloo is being used commercially (ie, by a corporation,
 * company or business for any purpose whatever) then you
 * should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details.
 * Use of Jigloo implies acceptance of these licensing terms.
 * A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
 * THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
 * LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class GuiApplication extends javax.swing.JFrame {

	{
		try {
			javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Crawler crawler;
	private boolean directorySelected = false;
	private File selectedDirectory;
	private boolean connectionExists = false;
	private ArrayList<String> imageFileTypes = new ArrayList<String>();

	final JFileChooser fc = new JFileChooser();

	private JTable tblResults;
	private JRadioButton rbtnJPG;
	private JButton btnDownload;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private JMenuItem mnuSelectFolder;
	private JMenuItem mnuEmptyFolder;
	private JMenu mnuActions;
	private JMenuItem mnuClose;
	private JMenu mnuFile;
	private JMenuBar mnuBar;
	private JCheckBox chckSmallImages;
	private PersonalTextPane txtpaneLog;
	private JCheckBox chckFileTypes;
	private JButton btnLookUp;
	private JTextField txtUrl;
	private JPanel pnlImageFileTypeSelection;
	private JRadioButton rbtnGIF;
	private JRadioButton rbtnPNG;

	public GuiApplication() {
		super();
		crawler = new Crawler();
		initGUI();
		txtUrl.requestFocus();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			{
				mnuBar = new JMenuBar();
				setJMenuBar(mnuBar);
				{
					mnuFile = new JMenu();
					mnuBar.add(mnuFile);
					mnuFile.setText("File");
					{
						mnuClose = new JMenuItem();
						mnuFile.add(mnuClose);
						mnuClose.setText("Close");
						mnuClose.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								mnuCloseActionPerformed(evt);
							}
						});
					}
				}

				{
					mnuActions = new JMenu();
					mnuBar.add(mnuActions);
					mnuActions.setText("Actions");
					{
						mnuEmptyFolder = new JMenuItem();
						mnuActions.add(mnuEmptyFolder);
						mnuEmptyFolder.setText("Empty folder");
						mnuEmptyFolder.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								mnuEmptyFolderActionPerformed(evt);
							}
						});
					}
					{
						mnuSelectFolder = new JMenuItem();
						mnuActions.add(mnuSelectFolder);
						mnuSelectFolder.setText("Select output folder");
						mnuSelectFolder.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								mnuSelectFolderActionPerformed(evt);
							}
						});
					}
				}
			}
			{
				jScrollPane1 = new JScrollPane();
				getContentPane().add(jScrollPane1);
				jScrollPane1.setBounds(61, 42, 835, 628);
				jScrollPane1.setAutoscrolls(true);
				updateTitledBorder();
				{
					createTableModel(true);
				}
			}
			{
				pnlImageFileTypeSelection = new JPanel();
				getContentPane().add(pnlImageFileTypeSelection);
				pnlImageFileTypeSelection.setBounds(959, 113, 126, 86);
				{
					rbtnJPG = new JRadioButton();
					pnlImageFileTypeSelection.add(rbtnJPG);
					rbtnJPG.setText("JPG Images");
					rbtnJPG.setBounds(607, 78, 126, 20);
					rbtnJPG.setPreferredSize(new java.awt.Dimension(118, 20));
					rbtnJPG.setSelected(true);
				}
				{
					rbtnPNG = new JRadioButton();
					pnlImageFileTypeSelection.add(rbtnPNG);
					rbtnPNG.setText("PNG Images");
					rbtnPNG.setBounds(607, 110, 126, 20);
					rbtnPNG.setPreferredSize(new java.awt.Dimension(118, 20));
					rbtnPNG.setSelected(false);
				}
				{
					rbtnGIF = new JRadioButton();
					pnlImageFileTypeSelection.add(rbtnGIF);
					rbtnGIF.setText("GIF Images");
					rbtnGIF.setBounds(607, 147, 126, 20);
					rbtnGIF.setPreferredSize(new java.awt.Dimension(118, 20));
					rbtnGIF.setSelected(false);
				}
			}
			{
				txtUrl = new PersonalTextField();
				getContentPane().add(txtUrl);
				txtUrl.setBounds(1190, 113, 358, 23);
				txtUrl.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent evt) {
						txtUrlKeyPressed(evt);
					}
				});
			}
			{
				btnLookUp = new PersonalButton("Look up");
				getContentPane().add(btnLookUp);
				btnLookUp.setBounds(1188, 155, 165, 30);
				btnLookUp.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent evt) {
						btnLookUpActionPerformed(evt);
					}
				});
			}
			{
				btnDownload = new PersonalButton("Download");
				getContentPane().add(btnDownload);
				btnDownload.setBounds(1372, 155, 174, 30);
				btnDownload.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent evt) {
						btnDownloadActionPerformed();
					}
				});
			}
			{
				chckFileTypes = new JCheckBox();
				getContentPane().add(chckFileTypes);
				chckFileTypes.setText("Select all");
				chckFileTypes.setBounds(959, 211, 120, 18);
				chckFileTypes.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent evt) {
						chckFileTypesActionPerformed(evt);
					}
				});
			}
			{
				jScrollPane2 = new JScrollPane();
				getContentPane().add(jScrollPane2);
				jScrollPane2.setBounds(959, 294, 635, 376);
				jScrollPane2.setBorder(BorderFactory.createTitledBorder("Logging output: "));
				{
					txtpaneLog = new PersonalTextPane();
					jScrollPane2.setViewportView(txtpaneLog);
					txtpaneLog.setBounds(959, 277, 358, 252);
					txtpaneLog.setFocusable(false);
					txtpaneLog.setPreferredSize(new java.awt.Dimension(634, 210));
				}
			}
			{
				chckSmallImages = new JCheckBox();
				getContentPane().add(chckSmallImages);
				chckSmallImages.setText("Download small images (< 250x250)");
				chckSmallImages.setBounds(1188, 211, 358, 18);
				chckSmallImages.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						chckSmallImagesActionPerformed(evt);
					}
				});
			}
			pack();
			getFrameSettings();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Creates the table view.
	// @Param: True -> A new, empty tabel with standard data is formed
	// @Param: False -> Data is being received from the crawler from the entered
	// URL
	private void createTableModel(boolean emptyTable) {
		String[][] data = null;
		String[] headers = new String[] { "URL", "Title" };
		if (emptyTable == true) {
			data = new String[1][2];
			data[0][0] = "Query URL";
			data[0][1] = "Query data";
		} else if (emptyTable == false) {
			data = DataUtils.convertImageArrayListTo2DArray(crawler.getImages());
			if (!(data.length > 0)) {
				data = new String[1][2];
				data[0][0] = "No";
				data[0][1] = "Data";
			}
		}

		TableModel tblResultsModel = new DefaultTableModel(data, headers);
		tblResults = new JTable();
		jScrollPane1.setViewportView(tblResults);
		tblResults.setModel(tblResultsModel);
		tblResults.setAutoCreateRowSorter(true);
		tblResults.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tblResults.getTableHeader().setFont(new Font("Sylfaen", 3, 16));
		tblResults.getTableHeader().setAutoscrolls(true);
		tblResults.getTableHeader().setReorderingAllowed(false);
		tblResults.getTableHeader().setResizingAllowed(false);
		tblResults.setBounds(61, 42, 461, 394);
	}

	// Sets the frame specific settings
	private void getFrameSettings() {
		Color color = Color.LIGHT_GRAY;
		getContentPane().setBackground(color);

		txtpaneLog.setBackground(getContentPane().getBackground());
		pnlImageFileTypeSelection.setBackground(getContentPane().getBackground());
		this.setSize(1680, 744);
		this.setTitle("Web Crawler 2.0");
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void btnLookUpActionPerformed(ActionEvent evt) {
		createConnection();
	}

	// Selects the allowed filetypes
	private void selectImageFileTypes() {
		if (chckFileTypes.isSelected()) {
			for (Component currentComponent : pnlImageFileTypeSelection.getComponents()) {
				if (currentComponent instanceof JRadioButton) {
					imageFileTypes.add(((JRadioButton) currentComponent).getText());
				}
			}
		} else {
			for (Component currentComponent : pnlImageFileTypeSelection.getComponents()) {
				if (currentComponent instanceof JRadioButton) {
					if (((JRadioButton) currentComponent).isSelected()) {
						imageFileTypes.add(((JRadioButton) currentComponent).getText());
					}
				}
			}
		}

		String types = "";
		for (String type : imageFileTypes) {
			types += type + ", ";
		}
		updateLog("Filetypes chosen: " + types);
		crawler.selectImageFileTypes(imageFileTypes);
	}

	// Initiates the connection in a few steps:
	// Clears the existing preferences
	// Selects the preferred filetypes
	// Initiates connection
	// Updates table model
	private void createConnection() {
		checkNewConsole();
		String url = txtUrl.getText().trim();
		if (url.length() > 0) {

			if (url.startsWith("www")) {
				url = "http://" + url;
			}
			updateLog("Connecting to: " + url);

			crawler.clearExistingPreferences();
			updateLog("Existing preferences have been cleared.");

			selectImageFileTypes();
			try {
				crawler.createConnection(url);
			} catch (IOException e) {
				OutputUtil.showErrorMessage("Couldn't connect to given URL", "Connection failed");
				updateLog("No connection could be established");
			}
			updateLog("Results found: " + crawler.getListSize());
			createTableModel(false);
			updateTitledBorder();
			connectionExists = true;
		} else {
			util.OutputUtil.showErrorMessage("Enter an URL to connect to!", "No URL has been entered");
			createTableModel(true);
		}
	}

	// Clears the console if an active connection exists
	private void checkNewConsole() {
		if (connectionExists) {
			txtpaneLog.clear();
		}
	}

	// Updates the title of the table its border
	private void updateTitledBorder() {
		jScrollPane1.setBorder(BorderFactory.createTitledBorder("Search results: " + crawler.getListSize()));
	}

	private void txtUrlKeyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			createConnection();
		}
	}

	// Downloads the selected data
	// Selects the directory first and downloads the images to that directory
	// next
	private void btnDownloadActionPerformed() {
		if (directorySelected) {
			if (crawler.hasConnection()) {
				crawler.setDirectory(selectedDirectory);
				try {
					crawler.downloadImages();
				} catch (MalformedURLException e) {
					updateLog("An invalid image URL was given");
				} catch (IOException e) {
					updateLog("An unexpected IO exception occurred");
				} catch (Exception e) {
					updateLog("No clue WTF happened this time");
				}
				updateLog("Download finished");
				util.OutputUtil.showMessage("All images have been downloaded!", "Download complete");
			} else {
				util.OutputUtil.showErrorMessage("Connect to an URL first!", "No connection established");
			}
		} else {
			selectDirectory();
			if (directorySelected) {
				btnDownloadActionPerformed();
			}
		}
	}

	private void selectDirectory() {
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnVal = fc.showSaveDialog(null);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			selectedDirectory = fc.getSelectedFile();
			directorySelected = true;
		}

		updateLog("Directory selected: " + selectedDirectory);
	}

	// Allows interaction with the checkbox to select filetypes
	private void chckFileTypesActionPerformed(ActionEvent evt) {
		for (Component currentComponent : pnlImageFileTypeSelection.getComponents()) {
			if (currentComponent instanceof JRadioButton) {
				if (currentComponent.isEnabled()) {
					currentComponent.setEnabled(false);
				} else {
					currentComponent.setEnabled(true);
				}
			}
		}
	}

	private void updateLog(String entry) {
		txtpaneLog.updateLog(entry);
	}

	private void chckSmallImagesActionPerformed(ActionEvent evt) {
		String entry = "Downloading small images: ";
		if (chckSmallImages.isSelected()) {
			crawler.downloadSmallImages(true);
			entry += "enabled";
		} else {
			crawler.downloadSmallImages(false);
			entry += "disabled";
		}
		updateLog(entry);
	}

	private void mnuEmptyFolderActionPerformed(ActionEvent evt) {
		try {
			crawler.emptyFolder();
			updateLog("Current output folder emptied.");
		} catch (IOException e) {
			OutputUtil.showErrorMessage("The currently selected folder couldn't be emptied.", "Couldn't empty folder");
			updateLog("Couldn't empty the folder.");
		} catch (NullPointerException e) {
			OutputUtil.showErrorMessage("No output folder has been selected yet.", "Couldn't empty folder");
			updateLog("No output folder selected. Couldn't empty folder.");
		}
	}

	private void mnuSelectFolderActionPerformed(ActionEvent evt) {
		selectDirectory();
	}

	private void mnuCloseActionPerformed(ActionEvent evt) {
		closeWindow();
	}

	private void closeWindow() {
		WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

		setVisible(false);
		dispose();

		System.exit(0);
	}

}
