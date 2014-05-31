package ui.templates;

import java.awt.Font;

import javax.swing.JLabel;

public class PersonalLabel extends JLabel {

	private static final long serialVersionUID = -1692804806582980109L;

	public PersonalLabel(String text) {
		this.setText(text);
		this.setFont(new Font("Sylfaen", 1, 14));
	}
}
