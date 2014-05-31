package com.week1.assignment;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.introcs.StdOut;

public class Percolation {
	private int amountRows, n, amountCols;
	private boolean[][] site;
	private WeightedQuickUnionUF wquf;

	public Percolation(int n) {
		this.n = n;
		amountCols = n + 1;
		amountRows = n + 2;
		createSite(n);
		wquf = new WeightedQuickUnionUF(amountCols * amountRows);
	}

	public void open(int i, int j) {
		if (validIndices(i, j)) {
			site[i][j] = false;
			checkUnions(i, j);
			// drawSite();
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	public boolean isOpen(int i, int j) {
		if (validIndices(i, j)) {
			// StdOut.println("DEBUG >> " + i + " " + j + " " + site[i][j]);
			return site[i][j];
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	public boolean isFull(int i, int j) {
		if (validIndices(i, j)) {
			return site[i][j] == false && semiPercolation(i, j);
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	private boolean semiPercolation(int i, int j) {
		for (int k = 0; k < amountRows; k++) {
			if (wquf.connected(getPos(i, j), getPos(0, k))) {
				return true;
			}
		}
		return false;
	}

	public boolean percolates() {
		return wquf.connected(0, (amountCols * n) + 1);
	}

	// False = closed
	// True = open
	// Percolated: series of false values
	private void createSite(int n) {
		site = new boolean[amountRows][amountCols];
		for (int i = 1; i < amountRows; i++) {
			for (int k = 1; k < amountCols; k++) {
				site[i][k] = true;
				if (i == (amountRows - 1)) {
					site[i][k] = false;
				}
			}
		}
		site[0][0] = false;
	}

	private boolean validIndices(int i, int j) {
		return (((i >= 1 && i < amountRows - 1) && (j >= 1 && j < amountCols)));
	}

	private void checkUnions(int row, int col) {
		int currPos = getPos(row, col);
		if (row == 1) {
			wquf.union(currPos, getPos(0, 0));
		} else if (row == n) {
			wquf.union(currPos, (amountCols * n) + 1);
		}

		if (row != 1) {
			if (!(site[row - 1][col])) {
				wquf.union(currPos, getPos(row - 1, col));
			}
		}

		if (row != amountRows - 1) {
			if (!(site[row + 1][col])) {
				wquf.union(currPos, getPos(row + 1, col));
			}
		}

		if (col != 1) {
			if (!(site[row][col - 1])) {
				wquf.union(currPos, getPos(row, col - 1));
			}
		}

		if (col != amountCols - 1) {
			if (!(site[row][col + 1])) {
				wquf.union(currPos, getPos(row, col + 1));
			}
		}
	}

	private int getPos(int row, int col) {
		return ((row * amountCols) - 1) + col + 1;
	}

	private void drawSite() {
		for (int i = 0; i < amountRows; i++) {
			for (int k = 0; k < amountCols; k++) {
				StdOut.print(site[i][k] + "\t");
			}
			StdOut.println();
		}
		StdOut.println("\n\n");
	}
}
