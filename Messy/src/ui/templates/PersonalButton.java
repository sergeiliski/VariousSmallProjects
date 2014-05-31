package ui.templates;

import java.awt.Font;

import javax.swing.JButton;

public class PersonalButton extends JButton {

	private static final long serialVersionUID = -3895040462368858894L;

	public PersonalButton(String text) {
		this.setText(text);
		this.setFont(new Font("Sylfaen", 1, 14));
	}
}