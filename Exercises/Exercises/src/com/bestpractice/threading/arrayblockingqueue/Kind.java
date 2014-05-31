package com.bestpractice.threading.arrayblockingqueue;

import java.util.Random;

public class Kind implements Runnable {
	private Tafel tafel;
	private Zwembad zwembad;
	private String naam;
	private Random generator = new Random();
	private static int aantalEmmers = 0;

	public Kind(Tafel tafel, Zwembad zwembad, String naam) {
		this.tafel = tafel;
		this.zwembad = zwembad;
		this.naam = naam;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(generator.nextInt(1000) + 2000);

			while (!zwembad.isVol() && tafel.pakEmmer()) {
				aantalEmmers++;
				System.out.println(naam + " heeft emmer " + aantalEmmers + " genomen");
				zwembad.gietEmmer();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("%s : " + (zwembad.isVol() ? "zwembad vol" : "reeds " + zwembad.getInhoud() + " emmers") + "\n", naam);

	}
}
