package com.bestpractice.threading.arrayblockingqueue;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Tafel implements Buffer {
	private Random generator = new Random();
	private boolean vatLeeg = false;
	private ArrayBlockingQueue<Boolean> emmer;

	public Tafel(int aantalEmmers) {
		emmer = new ArrayBlockingQueue<Boolean>(aantalEmmers);
	}

	@Override
	public void vulEmmer() {
		try {
			if (!vatLeeg) {
				System.out.println("Emmer gevuld");
				emmer.put(true);
			}
			Thread.sleep(generator.nextInt(1000) + 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean pakEmmer() {
		boolean emmerGenomen = false;
		Boolean value;

		try {
			while (!vatLeeg && !emmerGenomen) {
				value = emmer.poll(50L, TimeUnit.MILLISECONDS);
				if (value != null) {
					emmerGenomen = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return !vatLeeg;
	}

	public void setVatIsLeeg() {
		vatLeeg = true;
	}
}
