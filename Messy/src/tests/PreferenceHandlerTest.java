package tests;

import static org.junit.Assert.assertEquals;
import io.PreferenceHandler;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PreferenceHandlerTest {

	@Before
	public void setUp() throws IOException {
		PreferenceHandler.getInstance().loadPreferenceHandler();
	}

	@After
	public void tearDown() throws IOException {
		PreferenceHandler.getInstance().savePreferences();
	}

	@Test
	public void setPreference() throws IOException {
		PreferenceHandler.getInstance().setPreference("TEST", "Value");
		assertEquals("Value", PreferenceHandler.getInstance().getPreference("TEST"));
	}

	@Test
	public void setPreferenceAlreadySet() throws IOException {
		PreferenceHandler.getInstance().setPreference("TESTING", "Value 1");
		PreferenceHandler.getInstance().setPreference("TESTING", "Value 2");
		assertEquals("Value 2", PreferenceHandler.getInstance().getPreference("TESTING"));
	}
}
