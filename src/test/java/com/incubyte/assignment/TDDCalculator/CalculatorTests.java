package com.incubyte.assignment.TDDCalculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTests {

	@Test
	public void addEmptyString() throws Exception {
		int sum = Calculator.add("");
		assertEquals(0, sum);
	}

	@Test
	public void addOneNum() throws Exception {
		int sum = Calculator.add("1");
		assertEquals(1, sum);
	}

	@Test
	public void addTwoNums() throws Exception {
		int sum = Calculator.add("1,2");
		assertEquals(3, sum);
	}

	@Test
	public void addNNums() throws Exception {
		int sum = Calculator.add("1,2,4,6");
		assertEquals(13, sum);
	}

	@Test
	public void addAndHandleNewLines() throws Exception {
		int sum = Calculator.add("1\n2,3");
		assertEquals(6, sum);
	}

	@Test
	public void changeDelimiterAndAdd() throws Exception {
		int sum = Calculator.add("//;\n1;2");
		assertEquals(3, sum);
	}

	@Test(expected = Exception.class)
	public void negativesNotAllowed() throws Exception {
		Calculator.add("//;\n-1;2");
	}
	
	@Test
	public void ignoreLargeNums() throws Exception {
		int sum = Calculator.add("//;\n1001;2");
		assertEquals(2, sum);
	}
}
