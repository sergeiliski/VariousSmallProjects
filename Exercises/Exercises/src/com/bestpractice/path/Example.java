package com.bestpractice.path;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Example {
	public void showExample() throws URISyntaxException {
		System.out.println("**** 1st method ****\n");

		URL bestandAlsUrl = Example.class.getResource("lala.txt");
		System.out.println(bestandAlsUrl);
		Path bestandAlsPath = Paths.get(bestandAlsUrl.toURI());
		System.out.println(bestandAlsPath);

		System.out.println("\n**** 2nd method ****\n");

		bestandAlsUrl = getClass().getResource("lala.txt");
		System.out.println(bestandAlsUrl);
		bestandAlsPath = Paths.get(bestandAlsUrl.toURI());
		System.out.println(bestandAlsPath);
	}
}
