package interfaces;

import core.Message;

public interface Subject {
	public void addObserver(Observer observer);

	public void removeObserver(Observer observer);

	public void setNewIncomingMessage(Message message);

	public void setNewOutgoingMessage(Message message);
}
