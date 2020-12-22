package com.incubyte.assignment.TDDCalculator;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

public class Calculator {

	public static int add(String numbers) {
		int sum = 0;
		if (!StringUtils.isEmpty(numbers)) {
			String delimiter=",|\\n";
			if(numbers.startsWith("//")) {
				String[] parts=numbers.split("\\n",2);
				numbers=parts[1];
				delimiter=parts[0].substring(2);
			}
			int[] intArray = Arrays.stream(numbers.split(delimiter)).mapToInt(Integer::parseInt).toArray();
			for (int i : intArray) {
				sum = sum + i;
			}
		}
		return sum;
	}

}
