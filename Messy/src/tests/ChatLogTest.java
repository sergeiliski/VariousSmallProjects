package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import io.ChatLog;
import io.LogHandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import util.TimeUtil;
import core.Message;

public class ChatLogTest {

	private ChatLog log;
	private File directory;
	private File logFile;

	@Before
	public void setUp() throws Exception {
		directory = new File("C:\\ChatClient\\Logs\\Tests");
		LogHandler.getInstance().setLoggingDirectory(directory);
	}

	private void createStandardLog() throws IOException {
		log = new ChatLog(new GregorianCalendar(), "STANDARDTESTLOG", directory);
	}

	private void createManipulatedLog() throws IOException {
		Calendar cal = new GregorianCalendar(2013, 00, 01, 13, 13, 13);
		log = new ChatLog(cal, "MANIPULATEDTESTLOG", new File("C:\\ChatClient\\Logs\\Tests"));
		logFile = new File(directory + "\\" + "01-01-2013_13.13.13-MANIPULATEDTESTLOG.txt");
	}

	private Message createNewMessage() {
		return new Message("Jim", "This is a standard text message.");
	}

	@After
	public void tearDown() throws Exception {
		log = null;
	}

	@Test(expected = NullPointerException.class)
	public void writeToUnexistingLog() throws IOException {
		log = null;
		log.addMessage(createNewMessage());
	}

	@Test
	public void getLoggingMode() throws IOException {
		createStandardLog();
		log.allowLogging(true);
		assertTrue(log.getLoggingMode());

		log.allowLogging(false);
		assertFalse(log.getLoggingMode());
	}

	@Test
	public void createLog() throws IOException {
		createManipulatedLog();
		assertTrue(logFile.exists());
	}

	@Test
	public void writeSingleMessageToLog() throws IOException {
		createManipulatedLog();
		Message mess = createNewMessage();
		log.addMessage(mess);

		BufferedReader reader = new BufferedReader(new FileReader(logFile));
		String line = reader.readLine();
		assertEquals(TimeUtil.getCurrentTime() + "  " + mess.getSender() + ": \t" + "This is a standard text message.", line);
	}

	@Test
	public void writeMultipleMessagesToLog() throws IOException {
		createManipulatedLog();
		ArrayList<Message> testMessages = new ArrayList<Message>();
		testMessages.add(new Message("Jack", "Message 1"));
		testMessages.add(new Message("Jim", "Message 2"));
		testMessages.add(new Message("Steph", "Message 3"));
		testMessages.add(new Message("Roger", "Message 4"));
		testMessages.add(new Message("Emmely", "Hula hoop"));
		testMessages.add(new Message("Crazy jack", "à9\"'&é\"é"));

		for (Message message : testMessages) {
			log.addMessage(message);
		}

		BufferedReader reader = new BufferedReader(new FileReader(logFile));
		String line;
		int count = 0;

		while ((line = reader.readLine()) != null) {
			Message mess = testMessages.get(count);
			assertEquals(TimeUtil.getCurrentTime() + "  " + mess.getSender() + ": \t" + mess.getMessage(), line);
			count++;
		}
	}
}
