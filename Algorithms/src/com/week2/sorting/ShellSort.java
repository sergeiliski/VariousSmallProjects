package com.week2.sorting;

public class ShellSort {
	public static void sort(Comparable[] a) {
		int n = a.length;
		int h = 1;

		while (h < n / 3) {
			h = 3 * h + 1;
		} // 1, 4, 13, 40, 121, 364, ...

		while (h >= 1) {
			for (int i = h; i < n; i++) {
				for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
					displayArray(a);
					exch(a, j, j - h);
				}
			}

			h /= 3;
		}
	}

	private static boolean less(Comparable v, Comparable w) {
		return (v.compareTo(w) < 0);
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	private static void displayArray(Comparable[] x) {
		for (int i = 0; i < x.length; i++) {
			System.out.print(x[i] + " ");
		}
		System.out.println();
	}
}
