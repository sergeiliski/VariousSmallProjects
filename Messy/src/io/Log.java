package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import util.OutputUtil;

public abstract class Log {

	private Calendar cal;
	private String partnerName;
	private File logDirectory, logFile;
	private BufferedWriter bWriter;

	public Log(Calendar date, String name, File logDirectory) throws IOException {
		this.cal = date;
		this.partnerName = name;
		this.logDirectory = logDirectory;
		createLogFileOnDisk();
	}

	private void createLogFileOnDisk() throws IOException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH.mm.ss");
		dateFormat.setCalendar(cal);

		logFile = new File(logDirectory.getAbsolutePath() + "\\" + dateFormat.format(cal.getTime()) + "-" + partnerName + ".txt");
		logFile.createNewFile();

		bWriter = new BufferedWriter(new FileWriter(logFile));
	}

	protected void writeToLogFile(String message) {
		try {
			bWriter.write(message);
			bWriter.newLine();
			bWriter.flush();
		} catch (IOException e) {
			OutputUtil.showErrorMessage("Couldn't write to logfile", "IO error");
		}
	}

	public void closeLogFile() throws IOException {
		bWriter.close();
	}
}
