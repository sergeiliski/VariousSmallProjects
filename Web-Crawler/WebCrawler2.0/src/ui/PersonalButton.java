package ui;

import java.awt.Font;

import javax.swing.JButton;

public class PersonalButton extends JButton {

	public PersonalButton(String text) {
		this.setText(text);
		this.setFont(new Font("Sylfaen", 1, 14));
	}
}
