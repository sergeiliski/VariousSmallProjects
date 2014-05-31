package core;

import java.io.Serializable;

import util.TimeUtil;

public class Message implements Serializable {
	private static final long serialVersionUID = -6717033712561468249L;

	private String message, sender, time;

	public Message(String sender, String message) {
		this.sender = sender;
		this.message = message;

		this.time = TimeUtil.getCurrentTime();
	}

	public String getMessage() {
		return message;
	}

	public String getSender() {
		return sender;
	}

	public String getTime() {
		return time;
	}
}
