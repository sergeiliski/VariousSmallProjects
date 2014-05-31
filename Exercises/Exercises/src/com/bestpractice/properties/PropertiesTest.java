package com.bestpractice.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesTest {
	private Properties table;

	public PropertiesTest() {
		table = new Properties();

		table.setProperty("color", "blue");
		table.setProperty("width", "200");

		System.out.println("After setting properties:");
		listProperties();

		table.setProperty("color", "red");

		System.out.println("After replacing properties:");
		listProperties();

		saveProperties();
		table.clear();

		System.out.println("After clearing properties");
		listProperties();
		loadProperties();

		Object value = table.getProperty("color");

		if (value != null) {
			System.out.printf("Property color's value is %s\n", value);
		} else {
			System.out.println("Property color is not in table");
		}
	}

	private void saveProperties() {
		FileOutputStream output;
		try {
			output = new FileOutputStream("props.dat");
			table.store(output, "Sample properties");

			output.close();
			System.out.println("After saving properties");
			listProperties();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void loadProperties() {
		try {
			FileInputStream input = new FileInputStream("props.dat");
			table.load(input);

			input.close();

			System.out.println("After loading properties:");
			listProperties();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void listProperties() {
		Set<Object> keys = table.keySet();

		for (Object key : keys) {
			System.out.printf("%s\t%s\n", key, table.getProperty((String) key));
		}

		System.out.println();
	}
}
