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
public class CalculatorTestSubtract {

	private double expected, valueOne, valueTwo;

	public CalculatorTestSubtract(double expected, double valueOne, double valueTwo) {
		this.expected = expected;
		this.valueOne = valueOne;
		this.valueTwo = valueTwo;
	}

	@Parameters
	public static Collection<Integer[]> getTestParametersSubtract() {
		return Arrays.asList(new Integer[][] {
				{ -1, 0, 1 },
				{ 3, 5, 2 },
				{ 0, -1, -1 },
		});
	}

	@Test
	public void testSubtract() {
		Calculator calc = new Calculator();
		assertEquals(expected, calc.subtract(valueOne, valueTwo), 0);
	}

}
