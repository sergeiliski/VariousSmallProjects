package io;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import util.TimeUtil;

public class EventLog extends Log {

	public EventLog(Calendar date, String name, File logDirectory) throws IOException {
		super(date, name, logDirectory);
	}

	public void addErrorMessage(String message) {
		this.writeToLogFile(TimeUtil.getCurrentTime() + ": ERROR\t" + message);
	}

	public void addWarningMessage(String message) {
		this.writeToLogFile(TimeUtil.getCurrentTime() + ": WARNING\t" + message);
	}

	public void addNotificationMessage(String message) {
		this.writeToLogFile(TimeUtil.getCurrentTime() + ": NOTIF\t" + message);
	}

	public void addConfirmMessage(String message) {
		this.writeToLogFile(TimeUtil.getCurrentTime() + ": CONFIRM\t" + message);
	}
}
