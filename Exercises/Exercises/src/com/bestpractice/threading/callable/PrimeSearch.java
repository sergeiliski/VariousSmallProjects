package com.bestpractice.threading.callable;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.Callable;

public class PrimeSearch implements Callable<BigInteger> {
	private static Random random = new Random();
	private int n;

	public PrimeSearch(int bitSize) {
		n = bitSize;
	}

	@Override
	public BigInteger call() {
		return BigInteger.probablePrime(n, random);
	}
}
