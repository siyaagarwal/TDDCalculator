package com.incubyte.assignment.TDDCalculator;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

public class Calculator {

	public static int add(String numbers) {
		int sum = 0;
		if (!StringUtils.isEmpty(numbers)) {
			int[] intArray = Arrays.stream(numbers.split(",")).mapToInt(Integer::parseInt).toArray();
			for (int i : intArray) {
				sum = sum + i;
			}
		}
		return sum;
	}

}
