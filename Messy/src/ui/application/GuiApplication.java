package ui.application;

import io.LogHandler;
import io.PreferenceHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

import ui.templates.PersonalButton;
import ui.templates.PersonalFrame;
import ui.templates.PersonalLabel;
import ui.templates.PersonalTextField;
import ui.templates.PersonalTextPane;
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
public class GuiApplication extends PersonalFrame {

	private static final long serialVersionUID = 8820214389557454194L;
	private JMenu mnuFile;
	private PersonalTextField txtMessage;
	private PersonalTextPane txtpChatLog;
	private JMenuItem mnuAbout;
	private JMenu mnuHelp;
	private JMenuItem mnuClose;
	private JMenuItem mnuCloseConnection;
	private JMenuItem mnuPreferences;
	private JMenu mnuSettings;
	private JMenuBar mnuMenu;

	private PersonalButton btnConnect;
	private PersonalLabel lblConnected;
	private PersonalButton btnSend;

	public GuiApplication() {
		super();
		initGUI();
		openConnectionSettings();
		initPreferences();
		runLocalServer();
		startLogging();
	}

	private void initPreferences() {
		try {
			PreferenceHandler.getInstance().loadPreferenceHandler();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void runLocalServer() {
		try {
			int port = Integer.parseInt(PreferenceHandler.getInstance().getPreference("LOCAL_PORT"));
			Connection.getInstance().setLocalPreferences(port);
			Connection.getInstance().startLocalServer();
			displayConnection("Local server started");
		} catch (IOException e) {
			OutputUtil.showErrorMessage("Couldn't start the local server!", "IO Error");
		}
	}

	private void startLogging() {
		try {
			LogHandler.getInstance().setLoggingDirectory(new File(PreferenceHandler.getInstance().getPreference("LOGPATH")));
		} catch (IOException e) {
			OutputUtil.showErrorMessage("Couldn't load LOGPATH", "Preference error");
		}

		LogHandler.getInstance().createNewEventLog();
	}

	private void frameSettings() {
		this.setTitleImage("chat.png");
		try {
			this.setTitle(PreferenceHandler.getInstance().getPreference("VERSION"));
		} catch (IOException e) {
			OutputUtil.showErrorMessage("Couldn't load title version!", "Title version");
		}
		this.setSize(1035, 524);
		this.setLocationRelativeTo(null);
	}

	private void initGUI() {
		try {
			{
				txtpChatLog = new PersonalTextPane();
				getContentPane().add(txtpChatLog);
				txtpChatLog.setBounds(35, 26, 784, 363);
			}
			{
				txtMessage = new PersonalTextField();
				getContentPane().add(txtMessage);
				txtMessage.setBounds(35, 401, 574, 33);
				txtMessage.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent evt) {
						txtMessageKeyPressed(evt);
					}
				});
			}
			{
				btnSend = new PersonalButton("Send");
				btnSend.setIcon(new ImageIcon(getClass().getResource("..\\..\\img\\sendmessage.gif")));
				getContentPane().add(btnSend);
				btnSend.setBounds(644, 401, 175, 33);
				btnSend.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent evt) {
						btnSendActionPerformed(evt);
					}
				});
			}
			{
				lblConnected = new PersonalLabel("");
				getContentPane().add(lblConnected);
				lblConnected.setBounds(846, 90, 155, 28);
			}
			{
				btnConnect = new PersonalButton("Connect");
				getContentPane().add(btnConnect);
				btnConnect.setBounds(846, 321, 155, 68);
				btnConnect.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent evt) {
						btnConnectActionPerformed(evt);
					}
				});
			}

			pack();
			frameSettings();
			{
				mnuMenu = new JMenuBar();
				setJMenuBar(mnuMenu);
				{
					mnuFile = new JMenu();
					mnuMenu.add(mnuFile);
					mnuFile.setText("File");
					{
						mnuClose = new JMenuItem();
						mnuFile.add(mnuClose);
						mnuClose.setText("Close");
						mnuClose.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent evt) {
								mnuCloseActionPerformed(evt);
							}
						});
					}
				}
				{
					mnuSettings = new JMenu();
					mnuMenu.add(mnuSettings);
					mnuSettings.setText("Settings");
					{
						mnuPreferences = new JMenuItem();
						mnuSettings.add(mnuPreferences);
						mnuPreferences.setText("Preferences");
						mnuPreferences.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent evt) {
								mnuSetConnectionActionPerformed(evt);
							}
						});
					}
					{
						mnuCloseConnection = new JMenuItem();
						mnuSettings.add(mnuCloseConnection);
						mnuCloseConnection.setText("Close connection");
						mnuCloseConnection.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent evt) {
								mnuCloseConnectionActionPerformed(evt);
							}
						});
					}
				}
				{
					mnuHelp = new JMenu();
					mnuMenu.add(mnuHelp);
					mnuHelp.setText("Help");
					{
						mnuAbout = new JMenuItem();
						mnuHelp.add(mnuAbout);
						mnuAbout.setText("About");
						mnuAbout.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent evt) {
								mnuAboutActionPerformed(evt);
							}
						});
					}
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void displayConnection(final String conn) {
		SwingUtilities.invokeLater(
				new Runnable() {
					@Override
					public void run() {
						lblConnected.setText(conn);
					}
				});
	}

	private void mnuSetConnectionActionPerformed(ActionEvent evt) {
		openConnectionSettings();
	}

	private void mnuCloseActionPerformed(ActionEvent evt) {
		closeConnections();
		this.closeWindow();
		this.closeApplication();
	}

	private void mnuAboutActionPerformed(ActionEvent evt) {
		String version;
		try {
			version = PreferenceHandler.getInstance().getPreference("VERSIONLONG");
			OutputUtil.showMessage(version, "Client version");
		} catch (IOException e) {
			OutputUtil.showErrorMessage("Couldn't load version!", "Version error");
		}
	}

	private void sendMessage() {
		String message = txtMessage.getText().trim();
		Connection.getInstance().sendMessage(message);
		txtMessage.clear();
	}

	private void btnSendActionPerformed(ActionEvent evt) {
		sendMessage();
	}

	private void txtMessageKeyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			sendMessage();
		}
	}

	private void mnuCloseConnectionActionPerformed(ActionEvent evt) {
		closeConnections();
	}

	private void closeConnections() {
		try {
			Connection.getInstance().closeConnections();
		} catch (IOException e) {
			OutputUtil.showErrorMessage("Couldn't close connections!", "IO Error");
		}
	}

	private void openConnectionSettings() {
		new GuiPreferences();
	}

	private void btnConnectActionPerformed(ActionEvent evt) {
		if (Connection.getInstance().isConnectionSet()) {
			try {
				Connection.getInstance().startClientConnection();
				Connection.getInstance().addObserver(txtpChatLog);
				try {
					Connection.getInstance().setUsername(PreferenceHandler.getInstance().getPreference("USERNAME"));
				} catch (IOException e) {
					OutputUtil.showErrorMessage("Couldn't retrieve username", "Preference error");
				}
				displayConnection("Connected!");
			} catch (IOException e) {
				OutputUtil.showErrorMessage("Couldn't connect to the specified host.", "IO Error");
			}
		} else {
			openConnectionSettings();
		}
	}
}
