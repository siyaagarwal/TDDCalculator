package com.incubyte.assignment.TDDCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

public class Calculator {

	public static int add(String numbers) throws Exception {
		int sum = 0;
		if (!StringUtils.isEmpty(numbers)) {
			String delimiter=",|\\n";
			if (numbers.startsWith("//")) {
				String[] parts = numbers.split("\\n", 2);
				numbers = parts[1];
				ArrayList<String> delimiters = new ArrayList<>(
						Arrays.stream(parts[0].substring(2).split("\\[|\\]")).collect(Collectors.toList()));
				delimiters.removeAll(Arrays.asList("", null));
				for (String d : delimiters) {
					delimiter = delimiter + "|" + Pattern.quote(d);
				}
			}
			int[] intArray = Arrays.stream(numbers.split(delimiter)).mapToInt(Integer::parseInt).toArray();
			
			List<Integer> negatives = new ArrayList<>();
			Arrays.stream(intArray).forEach(num -> {
				if (num < 0)
					negatives.add(num);
			});
			
			if(!negatives.isEmpty()) {
				throw new Exception("negatives not allowed" + negatives.toString());
			}
			
			for (int i : intArray) {
				sum = i > 1000 ? sum : sum + i;
			}
		}
		return sum;
	}

}
