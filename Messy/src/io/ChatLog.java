package io;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import core.Message;
import exceptions.ForbiddenActionException;

public class ChatLog extends Log {
	private boolean logging = true;

	public ChatLog(Calendar date, String name, File logDirectory) throws IOException {
		super(date, name, logDirectory);
	}

	public void addMessage(Message message) {
		if (logging) {
			this.writeToLogFile(message.getTime() + "  " + message.getSender() + ": \t" + message.getMessage());
		} else {
			throw new ForbiddenActionException("Logging is disabled");
		}
	}

	public void allowLogging(boolean logging) {
		this.logging = logging;
	}

	public boolean getLoggingMode() {
		return logging;
	}
}
