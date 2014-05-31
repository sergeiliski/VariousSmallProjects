package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import io.LogHandler;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import core.Message;
import exceptions.ForbiddenActionException;

public class LogHandlerTest {

	private File directory;

	@Before
	public void setUp() throws Exception {
		directory = new File("C:\\ChatClient\\Logs\\Tests");
		LogHandler.getInstance().setLoggingDirectory(directory);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void setLoggingDirectory() {
		assertEquals(directory.getAbsolutePath(), LogHandler.getInstance().getLoggingDirectory().getAbsolutePath());
		assertTrue(directory.exists());
	}

	@Test(expected = ForbiddenActionException.class)
	public void writeWithoutPermission() throws ForbiddenActionException, IOException {
		LogHandler.getInstance().createNewChatlog("Jack");
		LogHandler.getInstance().allowLogging(false);
		LogHandler.getInstance().writeToChatLog(new Message("Steven", "CANT WORK"));
	}
}
