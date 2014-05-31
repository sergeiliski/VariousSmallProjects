package com.week1.unionfind;

public class QuickUnionWeighted {
	private int[] id, sz;
	private int count;

	public QuickUnionWeighted(int n) {
		count = n;
		id = new int[n];
		sz = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
			sz[i] = 1;
		}
	}

	private int root(int i) {
		while (i != id[i]) {
			i = id[i];
		}

		return i;
	}

	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);

		if (i == j) {
			return;
		}

		if (sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}
		count--;

		draw();
	}

	public int getCount() {
		return count;
	}

	public void draw() {
		System.out.print("ID: ");
		for (int i = 0; i < id.length; i++) {
			System.out.print(id[i] + " ");
		}

		System.out.print("\nSZ: ");
		for (int i = 0; i < sz.length; i++) {
			System.out.print(sz[i] + " ");
		}
		System.out.println("\n");
	}
}
