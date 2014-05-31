package io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import util.OutputUtil;
import core.Message;

public class LogHandler {

	private File logDirectory;
	private ChatLog chatLog;
	private EventLog eventLog;

	private static LogHandler handler;

	private LogHandler() {
	}

	public static LogHandler getInstance() {
		if (handler == null) {
			handler = new LogHandler();
		}

		return handler;
	}

	public void setLoggingDirectory(File directory) {
		this.logDirectory = directory;
		if (!(logDirectory.exists())) {
			logDirectory.mkdirs();
		}
	}

	public File getLoggingDirectory() {
		return logDirectory;
	}

	public ArrayList<File> getExistingLogs() {
		ArrayList<File> logList = new ArrayList<File>();

		for (File currentLog : logDirectory.listFiles()) {
			if (currentLog.isFile()) {
				logList.add(currentLog);
			}
		}

		return logList;
	}

	public void createNewChatlog(String partnerName) {
		try {
			chatLog = new ChatLog(new GregorianCalendar(), partnerName, logDirectory);
		} catch (IOException e) {
			OutputUtil.showErrorMessage("Unable to create chatlog file!", "IO error");
		}
	}

	public void createNewEventLog() {
		try {
			eventLog = new EventLog(new GregorianCalendar(), "Eventlog", logDirectory);
		} catch (IOException e) {
			OutputUtil.showErrorMessage("Unable to create eventlog file!", "IO error");
		}
	}

	public void writeToChatLog(Message message) {
		if (chatLog != null) {
			chatLog.addMessage(message);
		}
	}

	public void writeErrorToEventLog(String message) {
		if (eventLog != null) {
			eventLog.addErrorMessage(message);
		}
	}

	public void writeWarningToEventLog(String message) {
		if (eventLog != null) {
			eventLog.addWarningMessage(message);
		}
	}

	public void writeNotificationToEventLog(String message) {
		if (eventLog != null) {
			eventLog.addNotificationMessage(message);
		}
	}

	public void writeConfirmationToEventLog(String message) {
		if (eventLog != null) {
			eventLog.addConfirmMessage(message);
		}
	}

	public void allowLogging(boolean logging) {
		if (chatLog != null) {
			chatLog.allowLogging(logging);
		}
	}

	public boolean getLoggingMode() {
		return chatLog.getLoggingMode();
	}

	public void stopLogging() throws IOException {
		chatLog.closeLogFile();
	}
}
