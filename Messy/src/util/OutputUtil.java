package util;

import io.LogHandler;

import javax.swing.JOptionPane;

public class OutputUtil {

	public static void showErrorMessage(String message, String title) {
		JOptionPane.showMessageDialog(null, message, "Error: " + title, 0, null);
		LogHandler.getInstance().writeErrorToEventLog(message);
	}

	public static void showMessage(String message, String title) {
		JOptionPane.showMessageDialog(null, message, title, 1, null);
		LogHandler.getInstance().writeNotificationToEventLog(message);
	}

	public static void showWarningMessage(String message, String title) {
		JOptionPane.showMessageDialog(null, message, "Warning: " + title, 2, null);
		LogHandler.getInstance().writeWarningToEventLog(message);
	}

	public static void showConfirmMessage(String message, String title) {
		JOptionPane.showMessageDialog(null, message, "Confirm: " + title, 3, null);
		LogHandler.getInstance().writeConfirmationToEventLog(message);
	}
}
