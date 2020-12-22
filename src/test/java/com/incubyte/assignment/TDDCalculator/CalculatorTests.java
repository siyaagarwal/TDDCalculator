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

	@Test
	public void addNNums() {
		int sum = Calculator.add("1,2,4,6");
		assertEquals(13, sum);
	}
	
	@Test
	public void addAndHandleNewLines() {
		int sum = Calculator.add("1\n2,3");
		assertEquals(6, sum);
	}
	
	@Test
	public void changeDelimiterAndAdd() {
		int sum = Calculator.add("//;\n1;2");
		assertEquals(3, sum);
	}
}
