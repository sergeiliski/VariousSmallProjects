package com.week1.unionfind;

public class StartUp {
	public static void main(String[] args) {
		quickfind();
		quickunion();
		quickunionweighted();
	}

	private static void quickfind() {
		System.out.println("Standard Quick Find");
		QuickFind qf = new QuickFind(10);
		qf.draw();

		qf.union(2, 4);
		qf.union(5, 4);
		qf.union(2, 7);

		if (qf.connected(5, 7)) {
			System.out.println("5 and 7 are connected!");
		} else {
			System.out.println("Tough luck baby boy");
		}
	}

	private static void quickunion() {
		System.out.println("\nStandard Quick Union");
		QuickUnion qu = new QuickUnion(10);
		qu.draw();

		qu.union(2, 4);
		qu.union(5, 4);
		qu.union(2, 7);

		if (qu.connected(5, 7)) {
			System.out.println("5 and 7 are connected!");
		} else {
			System.out.println("Shit's fucked brah");
		}
	}

	private static void quickunionweighted() {
		System.out.println("\nQuick Union Weighted");
		QuickUnionWeighted quw = new QuickUnionWeighted(10);
		quw.draw();

		quw.union(2, 4);
		quw.union(5, 4);
		quw.union(2, 7);

		if (quw.connected(5, 7)) {
			System.out.println("5 and 7 are connected!");
		} else {
			System.out.println("Shit's fucked brah");
		}
	}
}
