package util;

import javax.swing.JOptionPane;

public class OutputUtil {

	public static void showErrorMessage(String message, String title) {
		JOptionPane.showMessageDialog(null, message, "Error: " + title, 0, null);
	}

	public static void showMessage(String message, String title) {
		JOptionPane.showMessageDialog(null, message, title, 1, null);
	}

	public static void showWarningMessage(String message, String title) {
		JOptionPane.showMessageDialog(null, message, "Warning: " + title, 2, null);
	}

	public static void showConfirmMessage(String message, String title) {
		JOptionPane.showMessageDialog(null, message, "Confirm: " + title, 3, null);
	}

}
