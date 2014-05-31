package com.exams.frontend.exam2009.question3;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class ExamenMarathon {

	private ArrayBlockingQueue<String> vragen;
	private Random generator = new Random();
	private boolean aantal_vragen_zijn_uitgedeeld;

	public ExamenMarathon(int grootte_buffer) {
		vragen = new ArrayBlockingQueue<String>(grootte_buffer);
	}

	public void vragenZijnOp() {
		aantal_vragen_zijn_uitgedeeld = true;
	}

	public void deelVraagUit(String vraag) {
		try {
			vragen.put(vraag);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String geefVraag() {
		try {
			String vraag = vragen.take();
			return vraag;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return null;
	}
}
