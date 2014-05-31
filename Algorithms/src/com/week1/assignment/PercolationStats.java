package com.week1.assignment;

import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;
import edu.princeton.cs.introcs.Stopwatch;

public class PercolationStats {
	private Percolation perc;
	private int size;
	private double[] times;
	private static boolean testmode = false;

	public static void main(String[] args) {
		/*
		 * Use the standardStart method to retrieve info from one particular
		 * bord size.
		 * Uses commandline arguments.
		 * 
		 * Use the testMode method to retrieve an overview from each bord
		 * ranging from 1x1 to 5000x5000. Each bord gets executed 500 times.
		 */

		// standardStart(args);
		testMode();
	}

	private static void standardStart(String[] args) {
		int n = Integer.parseInt(args[0]), t = Integer.parseInt(args[1]);
		new PercolationStats(n, t);
	}

	private static void testMode() {
		StdOut.println("Sizes:\t\t\t| Mean\t\t| Stddev\t| exec time (seconds)");
		for (int i = 1; i < 5000; i++) {
			testmode = true;
			new PercolationStats(i, 500);
		}
	}

	public PercolationStats(int n, int t) {
		if (n > 0 && t > 0) {
			int count = 0, turns = 0;
			times = new double[t];
			size = n;
			if (!testmode) {
				StdOut.printf("%s%d%s%d\n", "Size of the N x N field is: ", size, " x ", size);
			}
			Stopwatch sw = new Stopwatch();
			while (t > 0) {
				perc = new Percolation(n);
				while (!(perc.percolates())) {
					boolean found = false;
					while (!(found)) {
						int randCol = StdRandom.uniform(size) + 1;
						int randRow = StdRandom.uniform(size) + 1;
						if (perc.isOpen(randRow, randCol)) {
							perc.open(randRow, randCol);
							found = true;
							turns++;
						}
					}
				}
				times[count] = turns;
				turns = 0;
				count++;
				t--;
			}
			double time = sw.elapsedTime();

			if (testmode) {
				processTestData(time);
			} else {
				processData(time);
			}
		} else {
			throw new IllegalArgumentException();
		}
	}

	private void processData(double time) {
		StdOut.println("End of the program!");
		StdOut.println("Percolates: " + perc.percolates());
		StdOut.println("Mean of " + times.length + " executions: " + mean());
		StdOut.println("Stdev of previous sequence: " + stddev());
		StdOut.println("95% Confidence interval: [" + confidenceLo() + "], [" + confidenceHi() + "]");
		StdOut.println("Program execution time (seconds): " + time);
		StdOut.println("Absolute mean of execution times: " + meanAbsolute());
		StdOut.println("\n");
	}

	private void processTestData(double time) {
		if (size < 100) {
			StdOut.println(size + " x " + size + "\t\t\t| " + mean() + "\t\t| " + stddev() + "\t\t| " + time);
		} else if (size < 1000) {
			StdOut.println(size + " x " + size + "\t\t| " + mean() + "\t\t| " + stddev() + "\t\t| " + time);
		} else if (size < 10000) {
			StdOut.println(size + " x " + size + "\t| " + mean() + "\t\t| " + stddev() + "\t\t| " + time);
		}
	}

	public double mean() {
		return (StdStats.mean(times) / (size * size));
	}

	public double stddev() {
		return (StdStats.stddev(times) / (size * size));
	}

	public double confidenceLo() {
		return mean() - stddev();
	}

	public double confidenceHi() {
		return mean() + stddev();
	}

	private double meanAbsolute() {
		return StdStats.mean(times);
	}
}
