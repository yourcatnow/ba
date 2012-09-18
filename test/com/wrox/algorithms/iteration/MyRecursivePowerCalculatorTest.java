package com.wrox.algorithms.iteration;


/**
 * Chapter 2, Problem 3
 * @author David Nelson
 *
 */
public class MyRecursivePowerCalculatorTest extends AbstractPowerCalculatorTestCase {

	@Override
	protected PowerCalculator createCalculator() {
		return MyRecursivePowerCalculator.INSTANCE;
	}

}
