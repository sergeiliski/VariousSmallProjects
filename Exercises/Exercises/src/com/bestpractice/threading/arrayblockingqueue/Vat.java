package com.bestpractice.threading.arrayblockingqueue;

public class Vat implements Runnable {
	private Tafel tafel;
	private int inhoud;

	public Vat(int emmers, Tafel tafel) {
		inhoud = emmers;
		this.tafel = tafel;
	}

	@Override
	public void run() {
		while (inhoud > 0) {
			inhoud--;
			tafel.vulEmmer();
		}
		System.out.println("Het vat is leeg");
		tafel.setVatIsLeeg();
	}
}
