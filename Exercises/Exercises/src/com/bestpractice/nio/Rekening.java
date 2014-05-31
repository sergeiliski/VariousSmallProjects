package com.bestpractice.nio;

import java.nio.ByteBuffer;

public class Rekening {
	public final static int SIZE = sizeBerekenen();
	public final static int NAAMLENGTE = 20;
	private int rekeningNr;
	private String naam;
	private double balans;

	public static int sizeBerekenen() {
		ByteBuffer buffer = ByteBuffer.allocate(100);
		buffer.putInt(0);

		for (int i = 0; i < NAAMLENGTE; i++) {
			buffer.putChar('A');
		}

		buffer.putDouble(0.0);
		return buffer.position();
	}

	public Rekening(int nr, String naam, double balans) {
		setRekeningNr(nr);
		setNaam(naam);
		setBalans(balans);
	}

	public int getRekeningNr() {
		return rekeningNr;
	}

	public void setRekeningNr(int rekeningNr) {
		this.rekeningNr = rekeningNr;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public double getBalans() {
		return balans;
	}

	public void setBalans(double balans) {
		this.balans = balans;
	}

	@Override
	public String toString() {
		return String.format("%d %s %.2f", getRekeningNr(), getNaam(), getBalans());
	}
}
