package ui.application;

import io.LogHandler;
import io.PreferenceHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import ui.templates.PersonalButton;
import ui.templates.PersonalFrame;
import ui.templates.PersonalLabel;
import ui.templates.PersonalTextField;
import util.OutputUtil;
import core.Connection;

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
public class GuiPreferences extends PersonalFrame {
	private static final long serialVersionUID = 1L;
	private static final int PADDINGBOTY = 110; // Starting Y coordinate of the
												// save & reset button
	private static final int PADDINGLEFTX = 40; // Starting X coordinate of the
												// left side
	private static final int PADDINGTOPY = 12; // Starting Y coordinate of the
												// top row

	private JTabbedPane tabbedPane;
	private JLabel lblLanguage;
	private PersonalTextField txtPort;
	private PersonalLabel lblPort;
	private PersonalButton btnSaveLogging;
	private PersonalButton btnRevertLogging;
	private JCheckBox chckLogging;
	private PersonalLabel lblToggleLogging;
	private PersonalLabel lblLogPath;
	private PersonalTextField txtHost;
	private PersonalTextField txtUsername;
	private PersonalLabel lblUsername;
	private PersonalTextField txtLocalPort;
	private PersonalLabel lblLocalPort;
	private PersonalButton btnRevertConnection;
	private PersonalButton btnSaveConnection;
	private PersonalButton btnRevertGeneral;
	private PersonalButton btnLogPath;
	private PersonalButton btnSaveGeneral;
	private PersonalButton btnFactoryReset;
	private PersonalLabel lblHost;
	private JComboBox cmbLanguage;
	private JPanel pnlMain, pnlConnection, pnlLogging;
	private ImageIcon saveIcon, revertIcon, connectionIcon, loggingIcon, settingsIcon;

	private File directory;

	public GuiPreferences() {
		super();
		initGUI();
	}

	private void initGUI() {
		try {
			{
				tabbedPane = new JTabbedPane();
				getContentPane().add(tabbedPane);
				tabbedPane.setBounds(0, 0, 481, 218);
				tabbedPane.setTabPlacement(SwingConstants.TOP);
				loadButtonImages();
				createGeneralTab();
				createConnectionTab();
				createLoggingTab();
				tabbedPane.setSelectedIndex(1);
			}
			pack();
			frameSettings();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void frameSettings() {
		this.setTitleImage("key.jpg");
		this.setSize(497, 256);
		this.setLocationRelativeTo(null);
		this.setTitle("Settings and Preferences");
	}

	private void loadButtonImages() {
		saveIcon = createImageIcon("save.png");
		revertIcon = createImageIcon("revert.png");
		settingsIcon = createImageIcon("settings.png");
		connectionIcon = createImageIcon("connection.gif");
		loggingIcon = createImageIcon("log.png");
	}

	private void createGeneralTab() {
		pnlMain = new JPanel();

		tabbedPane.addTab("General", settingsIcon, pnlMain, "General settings");
		pnlMain.setLayout(null);
		pnlMain.setPreferredSize(new java.awt.Dimension(516, 245));
		{
			lblLanguage = new PersonalLabel("Language:");
			pnlMain.add(lblLanguage);
			lblLanguage.setBounds(PADDINGLEFTX, PADDINGTOPY, 161, 16);
		}
		{
			ComboBoxModel cmbLanguageModel =
					new DefaultComboBoxModel(
							new String[] { "English", "Nederlands", "Français" });
			cmbLanguage = new JComboBox();
			cmbLanguage.setModel(cmbLanguageModel);
			cmbLanguage.setBounds(235, PADDINGTOPY, 207, 23);
			pnlMain.add(cmbLanguage);

		}
		{
			btnFactoryReset = new PersonalButton("Reset to default settings");
			btnFactoryReset.setIcon(null);
			pnlMain.add(btnFactoryReset);
			btnFactoryReset.setBounds(235, 79, 207, 24);
			btnFactoryReset.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent evt) {
					btnFactoryResetActionPerformed(evt);
				}
			});
		}
		{
			btnSaveGeneral = new PersonalButton("Save changes");
			btnSaveGeneral.setIcon(saveIcon);
			pnlMain.add(btnSaveGeneral);
			btnSaveGeneral.setBounds(PADDINGLEFTX, PADDINGBOTY, 178, 57);
			btnSaveGeneral.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent evt) {
					btnSaveGeneralActionPerformed(evt);
				}
			});
		}
		{
			btnRevertGeneral = new PersonalButton("Reset");
			btnRevertGeneral.setIcon(revertIcon);
			pnlMain.add(btnRevertGeneral);
			btnRevertGeneral.setBounds(264, 109, 178, 57);
			btnRevertGeneral.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent evt) {
					btnRevertGeneralActionPerformed(evt);
				}
			});
		}
		{
			lblUsername = new PersonalLabel("Username:");
			pnlMain.add(lblUsername);
			lblUsername.setBounds(40, 45, 161, 16);
		}
		{
			txtUsername = new PersonalTextField();
			pnlMain.add(txtUsername);
			try {
				txtUsername.setText(PreferenceHandler.getInstance().getPreference("USERNAME"));
			} catch (IOException e) {
				OutputUtil.showErrorMessage("Couldn't load USERNAME", "Preference error");
			}
			txtUsername.setBounds(235, 45, 207, 23);
		}
	}

	private void createConnectionTab() {
		pnlConnection = new JPanel();
		tabbedPane.addTab("Connection Preferences", connectionIcon, pnlConnection, "Connection settings");
		pnlConnection.setLayout(null);
		pnlConnection.setPreferredSize(new java.awt.Dimension(628, 340));
		{
			txtPort = new PersonalTextField();
			pnlConnection.add(txtPort);
			try {
				txtPort.setText(PreferenceHandler.getInstance().getPreference("TARGET_PORT"));
			} catch (IOException e) {
				OutputUtil.showErrorMessage("Unable to retrieve TARGET_PORT", "TARGET_PORT");
			}
			txtPort.setBounds(319, 45, 65, 23);
		}
		{
			lblPort = new PersonalLabel("Target port:");
			pnlConnection.add(lblPort);
			lblPort.setBounds(40, 45, 174, 16);
		}
		{
			txtHost = new PersonalTextField();
			pnlConnection.add(txtHost);
			try {
				txtHost.setText(PreferenceHandler.getInstance().getPreference("TARGET_HOST"));
			} catch (IOException e) {
				OutputUtil.showErrorMessage("Unable to retrieve TARGET_HOST", "TARGET_HOST");
			}
			txtHost.setBounds(243, PADDINGTOPY, 141, 23);
		}
		{
			lblHost = new PersonalLabel("Target hostname:");
			pnlConnection.add(lblHost);
			lblHost.setBounds(40, PADDINGTOPY, 174, 22);
		}
		{
			btnRevertConnection = new PersonalButton("Reset");
			btnRevertConnection.setIcon(revertIcon);
			pnlConnection.add(btnRevertConnection);
			btnRevertConnection.setBounds(btnRevertGeneral.getBounds().x,
					btnRevertGeneral.getBounds().y,
					btnRevertGeneral.getBounds().width,
					btnRevertGeneral.getBounds().height);
			btnRevertConnection.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent evt) {
					btnRevertConnectionActionPerformed(evt);
				}
			});
		}
		{
			btnSaveConnection = new PersonalButton("Save changes");
			btnSaveConnection.setIcon(saveIcon);
			pnlConnection.add(btnSaveConnection);
			btnSaveConnection.setBounds(PADDINGLEFTX,
					PADDINGBOTY,
					btnSaveGeneral.getBounds().width,
					btnSaveGeneral.getBounds().height);
			btnSaveConnection.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent evt) {
					btnSaveConnectionActionPerformed(evt);
				}
			});
		}
		{
			lblLocalPort = new PersonalLabel("Local port:");
			pnlConnection.add(lblLocalPort);
			lblLocalPort.setBounds(40, 75, 174, 16);
		}
		{
			txtLocalPort = new PersonalTextField();
			pnlConnection.add(txtLocalPort);
			try {
				txtLocalPort.setText(PreferenceHandler.getInstance().getPreference("LOCAL_PORT"));
			} catch (IOException e) {
				OutputUtil.showErrorMessage("Couldn't retrieve LOCAL_PORT!", "Preference IO error");
			}
			txtLocalPort.setBounds(319, 74, 65, 23);
		}
	}

	private void createLoggingTab() {
		pnlLogging = new JPanel();
		tabbedPane.addTab("Logging settings", loggingIcon, pnlLogging, "Logging preferences");
		pnlLogging.setLayout(null);
		{
			lblLogPath = new PersonalLabel("Logs:");
			pnlLogging.add(lblLogPath);
			lblLogPath.setBounds(PADDINGLEFTX, PADDINGTOPY, 159, 16);
		}
		{
			lblToggleLogging = new PersonalLabel("Enable logging:");
			pnlLogging.add(lblToggleLogging);
			lblToggleLogging.setBounds(PADDINGLEFTX, 56, 139, 16);
		}
		{
			chckLogging = new JCheckBox();
			pnlLogging.add(chckLogging);
			try {
				if (PreferenceHandler.getInstance().getPreference("LOGGING").equals("1")) {
					chckLogging.setSelected(true);
					chckLogging.setText("Enabled");
				} else {
					chckLogging.setSelected(false);
					chckLogging.setText("Disabled");
				}
			} catch (IOException e) {
				OutputUtil.showErrorMessage("Unable to retrieve LOGGING", "LOGGING");
			}

			chckLogging.setBounds(197, 56, 276, 23);
		}
		{
			btnRevertLogging = new PersonalButton("Reset");
			btnRevertLogging.setIcon(revertIcon);
			pnlLogging.add(btnRevertLogging);
			btnRevertLogging.setBounds(btnRevertGeneral.getBounds().x,
					btnRevertGeneral.getBounds().y,
					btnRevertGeneral.getBounds().width,
					btnRevertGeneral.getBounds().height);
			btnRevertLogging.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent evt) {
					btnRevertLoggingActionPerformed(evt);
				}
			});
		}
		{
			btnSaveLogging = new PersonalButton("Save changes");
			btnSaveLogging.setIcon(saveIcon);
			pnlLogging.add(btnSaveLogging);
			btnSaveLogging.setBounds(PADDINGLEFTX,
					PADDINGBOTY,
					btnSaveGeneral.getBounds().width,
					btnSaveGeneral.getBounds().height);
			btnSaveLogging.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent evt) {
					btnSaveLoggingActionPerformed(evt);
				}
			});
		}
		{
			try {
				btnLogPath = new PersonalButton(PreferenceHandler.getInstance().getPreference("LOGPATH"));
			} catch (IOException e) {
				OutputUtil.showErrorMessage("Unable to retrieve LOGPATH setting", "LOGPATH");
			}
			pnlLogging.add(btnLogPath);
			btnLogPath.setBounds(197, PADDINGTOPY, 267, 31);
			btnLogPath.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent evt) {
					btnLogPathActionPerformed(evt);
				}
			});
		}
	}

	private void saveAllTabs() {
		saveGeneralTab();
		saveConnectionTab();
		saveLoggingTab();
		this.closeWindow();
	}

	private void saveGeneralTab() {
		String language = cmbLanguage.getSelectedItem().toString();
		String username = txtUsername.getText().trim();

		Connection.getInstance().setUsername(username);

		try {
			PreferenceHandler.getInstance().setPreference("LANGUAGE", language);
			PreferenceHandler.getInstance().setPreference("USERNAME", username);
			PreferenceHandler.getInstance().savePreferences();
		} catch (IOException e) {
			OutputUtil.showErrorMessage("Unable to save general tab to preferences file!", "Preference error");
		}
	}

	private void saveConnectionTab() {
		String targetHost = txtHost.getText().trim();
		int targetPort = Integer.parseInt(txtPort.getText().trim());
		int localPort = Integer.parseInt(txtLocalPort.getText().trim());
		Connection.getInstance().setTargetPreferences(targetHost, targetPort);

		try {
			PreferenceHandler.getInstance().setPreference("TARGET_HOST", targetHost);
			PreferenceHandler.getInstance().setPreference("TARGET_PORT", Integer.toString(targetPort));
			PreferenceHandler.getInstance().setPreference("LOCAL_PORT", Integer.toString(localPort));
			PreferenceHandler.getInstance().savePreferences();
		} catch (IOException e) {
			OutputUtil.showErrorMessage("Unable to save connection tab to preferences file!", "Preferences Error");
		}
	}

	private void saveLoggingTab() {
		try {
			if (directory != null) {
				LogHandler.getInstance().setLoggingDirectory(directory);
				PreferenceHandler.getInstance().setPreference("LOGPATH", directory.getAbsolutePath());
			}

			String logPref;
			if (chckLogging.isSelected()) {
				logPref = "1";
				chckLogging.setText("Enabled");
			} else {
				logPref = "0";
				chckLogging.setText("Disabled");
			}

			PreferenceHandler.getInstance().setPreference("LOGGING", logPref);
			PreferenceHandler.getInstance().savePreferences();
		} catch (IOException e) {
			OutputUtil.showErrorMessage("Unable to save logging tab to preferences file!", "Preferences Error");
		}

		LogHandler.getInstance().allowLogging(chckLogging.isSelected());
	}

	private void btnSaveGeneralActionPerformed(ActionEvent evt) {
		saveAllTabs();
	}

	private void btnSaveConnectionActionPerformed(ActionEvent evt) {
		saveAllTabs();
	}

	private void btnSaveLoggingActionPerformed(ActionEvent evt) {
		saveAllTabs();
	}

	private void btnRevertGeneralActionPerformed(ActionEvent evt) {
		try {
			cmbLanguage.setSelectedIndex(0);
			txtUsername.setText(PreferenceHandler.getInstance().getPreference("USERNAME"));
		} catch (IOException e) {
			OutputUtil.showErrorMessage("Unable to revert changes", "Revert failed");
		}
	}

	private void btnRevertConnectionActionPerformed(ActionEvent evt) {
		try {
			txtHost.setText(PreferenceHandler.getInstance().getPreference("TARGET_HOST"));
			txtPort.setText(PreferenceHandler.getInstance().getPreference("TARGET_PORT"));
			txtLocalPort.setText(PreferenceHandler.getInstance().getPreference("LOCAL_PORT"));
		} catch (IOException e) {
			OutputUtil.showErrorMessage("Unable to revert changes", "Revert failed");
		}
	}

	private void btnRevertLoggingActionPerformed(ActionEvent evt) {
		try {
			btnLogPath.setText(PreferenceHandler.getInstance().getPreference("LOGPATH"));
			chckLogging.setSelected(true);
		} catch (IOException e) {
			OutputUtil.showErrorMessage("Unable to revert changes", "Revert failed");
		}
	}

	private void btnLogPathActionPerformed(ActionEvent evt) {
		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnVal = fc.showSaveDialog(null);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			directory = fc.getSelectedFile();
			btnLogPath.setText(directory.getAbsolutePath());
		}
	}

	private void btnFactoryResetActionPerformed(ActionEvent evt) {
		try {
			PreferenceHandler.getInstance().loadDefaultPreferences();
			PreferenceHandler.getInstance().savePreferences();
			this.closeWindow();
		} catch (IOException e) {
			OutputUtil.showErrorMessage("Unable to reset to default settings!", "Preferences Error");
		}
	}
}
