package ui;

import javax.swing.JTextPane;

public class PersonalTextPane extends JTextPane {

	public PersonalTextPane() {

	}

	public void updateLog(String entry) {
		String log = this.getText();
		this.setText(log + "\n" + entry);
	}

	public void clear() {
		this.setText("");
	}
}
