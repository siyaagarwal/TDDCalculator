package com.incubyte.assignment.TDDCalculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.incubyte.assignment.TDDCalculator.Calculator;

public class CalculatorTests {

	@Test
	public void addEmptyString() {
		int sum = Calculator.add("");
		assertEquals(0, sum);
	}

	@Test
	public void addOneNum() {
		int sum = Calculator.add("1");
		assertEquals(1, sum);
	}

	@Test
	public void addTwoNums() {
		int sum = Calculator.add("1,2");
		assertEquals(3, sum);
	}

}
