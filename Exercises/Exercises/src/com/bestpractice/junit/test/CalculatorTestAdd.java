package com.bestpractice.junit.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.bestpractice.junit.domain.Calculator;

@RunWith(value = Parameterized.class)
public class CalculatorTestAdd {

	private double expected, valueOne, valueTwo;

	public CalculatorTestAdd(double expected, double valueOne, double valueTwo) {
		this.expected = expected;
		this.valueOne = valueOne;
		this.valueTwo = valueTwo;
	}

	@Parameters
	public static Collection<Integer[]> getTestParametersAdd() {
		return Arrays.asList(new Integer[][] {
				{ 2, 1, 1 },
				{ 3, 2, 1 },
				{ 4, 3, 1 },
				{ -5, 3, -8 },
				{ 0, 0, 0 },
				{ 0, -1, 1 }
		});
	}

	@Test
	public void testSum() {
		Calculator calc = new Calculator();
		assertEquals(expected, calc.add(valueOne, valueTwo), 0);
	}
}
