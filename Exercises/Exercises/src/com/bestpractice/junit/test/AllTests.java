package com.bestpractice.junit.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CustomerTest.class, CalculatorTestAdd.class, CalculatorTestSubtract.class })
public class AllTests {

}
