package ui.templates;

import interfaces.Observer;

import javax.swing.JTextPane;
import javax.swing.SwingUtilities;

import core.Message;

public class PersonalTextPane extends JTextPane implements Observer {

	private static final long serialVersionUID = -141980265069027397L;

	private void displayMessage(final PersonalTextPane pane, final String data) {
		SwingUtilities.invokeLater(
				new Runnable() {
					@Override
					public void run() {
						String log = pane.getText();
						pane.setText(log + "\n" + data);
					}
				});
	}

	@Override
	public void newOutgoingMessage(Message message) {
		displayMessage(this, message.getTime() + "   You: " + message.getMessage());
	}

	@Override
	public void newIncomingMessage(Message message) {
		displayMessage(this, message.getTime() + "   " + message.getSender() + ": " + message.getMessage());
	}
}
