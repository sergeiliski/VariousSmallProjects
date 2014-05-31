package com.week1.analysis;

public class StartUp {
	public static void main(String[] args) {
		threeSumBrute();
		binarySearch();
	}

	private static void threeSumBrute() {
		int[] a = new int[1000];
		int[] b = new int[3000];
		int[] c = new int[5000];
		int[] d = new int[10000];

		for (int i = -5000; i < 5000; i++) {
			if (i > -500 && i < 500) {
				a[i + 500] = i;
			}

			if (i > -1500 && i < 1500) {
				b[i + 1500] = i;
			}

			if (i > -2500 && i < 2500) {
				c[i + 2500] = i;
			}

			d[i + 5000] = i;
		}

		StopWatch stopwatch = new StopWatch();
		System.out.println("Array A: 1000 items");
		System.out.println(ThreeSum.bruteForce(a));
		System.out.println(stopwatch.elapsedTime());

		StopWatch stopwatch2 = new StopWatch();
		System.out.println("\nArray B: 3000 items");
		System.out.println(ThreeSum.bruteForce(b));
		System.out.println(stopwatch2.elapsedTime());

		StopWatch stopwatch3 = new StopWatch();
		System.out.println("\nArray C: 5000 items");
		System.out.println(ThreeSum.bruteForce(c));
		System.out.println(stopwatch3.elapsedTime());

		StopWatch stopwatch4 = new StopWatch();
		System.out.println("\nArray D: 10000 items");
		System.out.println(ThreeSum.bruteForce(d));
		System.out.println(stopwatch4.elapsedTime());
	}

	private static void binarySearch() {
		int[] a = new int[1000];
		int[] b = new int[5000];
		int[] c = new int[10000];
		int[] d = new int[100000];

		for (int i = 0; i < 100000; i++) {
			if (i < 1000) {
				a[i] = i;
			}

			if (i < 5000) {
				b[i] = i;
			}

			if (i < 10000) {
				c[i] = i;
			}

			d[i] = i;
		}

		StopWatch stp1 = new StopWatch();
		System.out.println("BinarySearch, 1000 times");
		System.out.println(BinarySearch.search(a, 677));
		System.out.println(stp1.elapsedTime());

		StopWatch stp2 = new StopWatch();
		System.out.println("\nBinarySearch, 5000 times");
		System.out.println(BinarySearch.search(b, 2654));
		System.out.println(stp2.elapsedTime());

		StopWatch stp3 = new StopWatch();
		System.out.println("\nBinarySearch, 10000 times");
		System.out.println(BinarySearch.search(c, 512));
		System.out.println(stp3.elapsedTime());

		StopWatch stp4 = new StopWatch();
		System.out.println("\nBinarySearch, 100000 times");
		System.out.println(BinarySearch.search(d, 86952));
		System.out.println(stp4.elapsedTime());
	}
}
