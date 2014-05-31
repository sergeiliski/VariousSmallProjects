package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ PreferenceHandlerTest.class, LogHandlerTest.class, ChatLogTest.class, EventLogTest.class })
public class AllTests {
	// Execute the preferenceHandler first to avoid errors
	// PH creates the main dir C:\ChatClient which all other tests use.
}
