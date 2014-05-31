package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PreferenceHandler {

	private static PreferenceHandler handler;
	private Properties properties;
	private File propertyFile = new File("config.properties");
	private File directory = new File("C:\\ChatClient");
	private File propertyFilePath = new File(directory + "\\" + propertyFile);
	private FileOutputStream output;

	private PreferenceHandler() throws IOException {

	}

	public static PreferenceHandler getInstance() throws IOException {
		if (handler == null) {
			handler = new PreferenceHandler();
		}

		return handler;
	}

	public void loadPreferenceHandler() throws IOException {
		properties = new Properties();
		createDirectory();
		loadPreferences();
	}

	private void createDirectory() throws IOException {
		if (!(directory.exists())) {
			directory.mkdir();
		}
	}

	private void loadPreferences() throws IOException {
		if (!(propertyFilePath.exists())) {
			loadDefaultPreferences();
			savePreferences();
		} else {
			FileInputStream propertyStream = new FileInputStream(propertyFilePath);
			properties.load(propertyStream);
			propertyStream.close();
		}
	}

	public void loadDefaultPreferences() throws IOException {
		properties.setProperty("TARGET_HOST", "Jeroen-LAPTOP");
		properties.setProperty("TARGET_PORT", "6666");
		properties.setProperty("LOCAL_PORT", "6666");
		properties.setProperty("LANGUAGE", "EN");
		properties.setProperty("USERNAME", "You");
		properties.setProperty("VERSION", "Messy v2.1");
		properties.setProperty("VERSIONLONG", "Messy version 2.1");
		properties.setProperty("LOGPATH", "C:\\ChatClient\\Logs");
		properties.setProperty("LOGGING", "1");
	}

	public String getPreference(String key) {
		return properties.getProperty(key);
	}

	public void setPreference(String key, String value) throws IOException {
		properties.setProperty(key, value);
	}

	public void savePreferences() throws IOException {
		if (output != null) {
			output.close();
		}
		propertyFilePath.delete();
		output = new FileOutputStream(propertyFilePath);

		properties.store(output, null);
	}

	public void closeConnection() throws IOException {
		if (output != null) {
			output.close();
		}
	}
}
