package com.week1.unionfind;

public class QuickUnionWeightedPathCompression {
	private int[] id, sz;
	private int count;

	public QuickUnionWeightedPathCompression(int n) {
		count = n;
		id = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
			sz[i] = i;
		}
	}

	private int root(int i) {
		while (i != id[i]) {
			id[i] = id[id[i]];
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

		if (sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += i;
		} else {
			id[j] = i;
			sz[i] += j;
		}

		count--;
	}

	public int getCount() {
		return count;
	}
}
