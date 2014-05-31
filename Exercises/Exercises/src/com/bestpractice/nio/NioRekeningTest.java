package com.bestpractice.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;

public class NioRekeningTest {
	private RandomAccessFile hetBestand;
	private FileChannel channel;
	private ByteBuffer buffer = ByteBuffer.allocate(Rekening.SIZE);

	public static void main(String arg[]) {
		new NioRekeningTest().run();
	}

	public void run() {
		maakTestBestand();
		vraagRecordOp();
	}

	public void maakTestBestand() {
		try {
			hetBestand = new RandomAccessFile("nio.dat", "rw");
			channel = hetBestand.getChannel();
			Rekening[] rekeningen = { new Rekening(1000, "jan", 100.0),
					new Rekening(1001, "piet", 200.0),
					new Rekening(1002, "joris", 150.0),
					new Rekening(1003, "corneel", 0.0) };
			int recNr = 1;
			for (Rekening r : rekeningen) {
				schrijfRecord(r, recNr++);
			}

			hetBestand.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void schrijfRecord(Rekening r, int volgnr) {
		buffer.clear();
		buffer.putInt(r.getRekeningNr());

		StringBuffer hulp = new StringBuffer(r.getNaam());
		hulp.setLength(Rekening.NAAMLENGTE);
		String naam = hulp.toString().replace('\0', ' ');

		for (int i = 0; i < Rekening.NAAMLENGTE; i++) {
			buffer.putChar(naam.charAt(i));
		}

		buffer.putDouble(r.getBalans());
		buffer.flip();

		try {
			channel.position((volgnr - 1) * Rekening.SIZE);
			channel.write(buffer);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void vraagRecordOp() {
		try {
			hetBestand = new RandomAccessFile("nio.dat", "r");
			channel = hetBestand.getChannel();
			System.out.print("Geef record volgnr: ");
			Scanner in = new Scanner(System.in);
			int volgnr = in.nextInt();

			channel.position((volgnr - 1) * Rekening.SIZE);
			buffer.clear();
			channel.read(buffer);
			buffer.flip();

			int nr = buffer.getInt();
			char ar[] = new char[Rekening.NAAMLENGTE];

			for (int i = 0; i < ar.length; i++) {
				ar[i] = buffer.getChar();
			}

			String naam = new String(ar).trim();
			double balans = buffer.getDouble();

			Rekening r = new Rekening(nr, naam, balans);
			System.out.printf("%s\n", r);
			hetBestand.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
