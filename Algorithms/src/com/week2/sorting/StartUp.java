package com.week2.sorting;

import java.util.Random;

import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.introcs.StdStats;

public class StartUp {
	public static void main(String[] args) {
		displayTest();
		// displayBenchmark();
	}

	private static void displayArray(Comparable[] x) {
		for (int i = 0; i < x.length; i++) {
			System.out.print(x[i] + " ");
		}
		System.out.println();
	}

	private static void displayTest() {
		Integer[] a = { 86, 73, 72, 79, 42, 46, 48, 27, 38, 74 };
		// displayArray(a);

		// SelectionSort.sort(a);
		// InsertionSort.sort(a);
		ShellSort.sort(a);

		// displayArray(a);
	}

	private static void displayBenchmark() {
		final int amountOfTests = 10000;
		double[] resultsSelection = new double[amountOfTests];
		double[] resultsInsertion = new double[amountOfTests];
		double[] resultsShell = new double[amountOfTests];

		System.out.println("Iteration\t|\tSelection sort\t|\tInsertion sort\t|\tShell sort");

		for (int i = 0; i < amountOfTests; i++) {
			Integer[] a = getRandomArray();
			Integer[] b = a.clone();
			Integer[] c = a.clone();

			Stopwatch swSel = new Stopwatch();
			SelectionSort.sort(a);
			resultsSelection[i] = swSel.elapsedTime();

			Stopwatch swIns = new Stopwatch();
			InsertionSort.sort(b);
			resultsInsertion[i] = swIns.elapsedTime();

			Stopwatch swShe = new Stopwatch();
			ShellSort.sort(c);
			resultsShell[i] = swShe.elapsedTime();

			System.out.println(i + "\t\t|\t" + resultsSelection[i] + "\t\t|\t" + resultsInsertion[i] + "\t\t|\t" + resultsShell[i]);
		}

		System.out.println("Type of sort\t|\tMean time (s)\t|\t# Elements\t|\t# Tests");
		System.out.println("Selection sort\t|\t" + mean(resultsSelection) + "\t|\t15000\t|\t10000");
		System.out.println("Insertion sort\t|\t" + mean(resultsInsertion) + "\t|\t15000\t|\t10000");
		System.out.println("Shell sort\t|\t" + mean(resultsShell) + "\t|\t15000\t|\t10000");
	}

	private static Integer[] getRandomArray() {
		Random random = new Random();
		Integer[] a = new Integer[15000];

		for (int i = 0; i < a.length; i++) {
			a[i] = random.nextInt(a.length);
		}

		return a;
	}

	private static double mean(double[] a) {
		return StdStats.mean(a);
	}
}
