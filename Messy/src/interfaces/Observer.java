package interfaces;

import core.Message;

public interface Observer {
	public void newOutgoingMessage(Message message);

	public void newIncomingMessage(Message message);
}
