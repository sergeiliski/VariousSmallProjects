package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import io.EventLog;
import io.LogHandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import util.TimeUtil;

public class EventLogTest {

	private EventLog eventLog;
	private File dir = new File("C:\\ChatClient\\Logs\\Tests");
	private File filePath;

	@Before
	public void setUp() throws Exception {
		LogHandler.getInstance().setLoggingDirectory(dir);
	}

	@After
	public void tearDown() throws Exception {
		dir = null;
		eventLog = null;
	}

	private void createManipulatedLog() throws IOException {
		Calendar cal = new GregorianCalendar(2013, 00, 01, 13, 13, 13);
		eventLog = new EventLog(cal, "EVENTLOG", dir);
		filePath = new File(dir + "\\" + "01-01-2013_13.13.13-EVENTLOG.txt");
	}

	@Test
	public void CreateEventLog() throws IOException {
		createManipulatedLog();
		assertTrue(filePath.exists());
	}

	@Test
	public void addErrorMessage() throws IOException {
		createManipulatedLog();
		eventLog.addErrorMessage("An error has occurred");
		checkFile(TimeUtil.getCurrentTime() + ": ERROR\t" + "An error has occurred");
	}

	@Test
	public void addWarningMessage() throws IOException {
		createManipulatedLog();
		eventLog.addWarningMessage("A warning has been thrown");
		checkFile(TimeUtil.getCurrentTime() + ": WARNING\t" + "A warning has been thrown");
	}

	@Test
	public void addNotificationMessage() throws IOException {
		createManipulatedLog();
		eventLog.addNotificationMessage("This is a notification");
		checkFile(TimeUtil.getCurrentTime() + ": NOTIF\t" + "This is a notification");
	}

	@Test
	public void addConfirmationMessage() throws IOException {
		createManipulatedLog();
		eventLog.addConfirmMessage("This is a confirmation");
		checkFile(TimeUtil.getCurrentTime() + ": CONFIRM\t" + "This is a confirmation");
	}

	private void checkFile(String expected) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String line = reader.readLine();
		assertEquals(expected, line);
	}
}
