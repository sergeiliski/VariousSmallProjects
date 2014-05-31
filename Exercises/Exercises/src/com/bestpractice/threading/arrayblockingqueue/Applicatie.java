package com.bestpractice.threading.arrayblockingqueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Applicatie {
	private Vat vat;
	private Kind[] kinderen;

	public static void main(String[] args) {
		new Applicatie();
	}

	public Applicatie() {
		Tafel tafel = new Tafel(2);
		vat = new Vat(9, tafel);
		kinderen = new Kind[3];

		for (int i = 0; i < kinderen.length; i++) {
			kinderen[i] = new Kind(tafel, new Zwembad(4), "Kind " + (i + 1));
		}

		ExecutorService application = Executors.newFixedThreadPool(4);
		try {
			application.execute(kinderen[0]);
			application.execute(kinderen[1]);
			application.execute(kinderen[2]);
			application.execute(vat);
		} catch (Exception e) {
			e.printStackTrace();
		}
		application.shutdown();
	}
}
