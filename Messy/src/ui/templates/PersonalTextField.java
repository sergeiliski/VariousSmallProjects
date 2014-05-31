package ui.templates;

import javax.swing.JTextField;

public class PersonalTextField extends JTextField {

	private static final long serialVersionUID = 8025856466178667309L;

	public PersonalTextField() {
		this.setFont(new java.awt.Font("Sylfaen", 2, 12));
	}

	public void clear() {
		this.setText("");
	}
}
