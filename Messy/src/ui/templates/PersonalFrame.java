package ui.templates;

import io.PreferenceHandler;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.WindowConstants;

import util.OutputUtil;

public class PersonalFrame extends javax.swing.JFrame {
	private static final long serialVersionUID = 6532951331701719147L;

	{
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected ImageIcon createImageIcon(String image) {
		return new ImageIcon(getClass().getResource("..\\..\\img\\" + image));
	}

	public PersonalFrame() {
		this.setVisible(true);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		loadPreferences();
	}

	private void loadPreferences() {
		try {
			PreferenceHandler.getInstance().loadPreferenceHandler();
		} catch (IOException e) {
			OutputUtil.showErrorMessage("Unable to load preferences", "General error");
		}
	}

	public void closeWindow() {
		WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

		setVisible(false);
		dispose();
	}

	public void closeApplication() {
		System.exit(0);
	}

	public void setTitleImage(String image) {
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("..\\..\\img\\" + image)));
	}
}
