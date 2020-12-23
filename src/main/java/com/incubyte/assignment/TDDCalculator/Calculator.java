package com.incubyte.assignment.TDDCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

public class Calculator {

	private static String NEWLINE_CHAR = "\\n";
	private static String DEFAULT_DELIMITER = ",|\\n";
	private static String NEGATIVES_NOT_ALLOWED = "negatives not allowed";
	private static String EMPTY_STRING = "";
	private static String SQUARE_BRACKETS = "\\[|\\]";
	private static String CHANGE_DELIMITER_IDENTIFIER = "//";
	private static String OR_OPERATOR = "|";

	public static int add(String input) throws Exception {
		int sum = 0;
		String strOfNums = null;
		String delimiters = null;

		if (!StringUtils.isEmpty(input)) {
			int[] arrOfNums;
			if (isDelimiterChanged(input)) {

				String[] parts = input.split(NEWLINE_CHAR, 2);

				strOfNums = parts[1];
				delimiters = getDelimiters(parts[0]);

			} else {

				strOfNums = input;
				delimiters = DEFAULT_DELIMITER;
			}

			arrOfNums = getArrOfNums(strOfNums, delimiters);

			disallowNegatives(arrOfNums);

			sum = sumOfNums(arrOfNums);

		}
		return sum;
	}

	private static int[] getArrOfNums(String strOfNums, String delimiter) {
		String[] strArrOfNums = strOfNums.split(delimiter);
		int[] intArrOfNums = Arrays.stream(strArrOfNums).mapToInt(Integer::parseInt).toArray();

		return intArrOfNums;
	}

	private static void disallowNegatives(int[] arrOfNums) throws Exception {
		List<Integer> negatives = getListOfNegatives(arrOfNums);

		if (!negatives.isEmpty()) {
			throw new Exception(NEGATIVES_NOT_ALLOWED + negatives.toString());
		}
	}

	private static List<Integer> getListOfNegatives(int[] arrOfNums) {
		List<Integer> negatives = new ArrayList<>();
		Arrays.stream(arrOfNums).forEach(num -> {
			if (num < 0)
				negatives.add(num);
		});

		return negatives;
	}

	private static String getDelimiters(String strOfDelimiters) {
		String delimiters = null;
		List<String> listOfDelimiters = getListOfDelimiters(strOfDelimiters);

		for (String d : listOfDelimiters) {
			delimiters = StringUtils.isEmpty(delimiters) ? Pattern.quote(d)
					: String.join(OR_OPERATOR, delimiters, Pattern.quote(d));
		}

		return delimiters;
	}

	private static List<String> getListOfDelimiters(String strOfDelimiters) {
		ArrayList<String> arrayListOfDelimiters = new ArrayList<>(
				Arrays.asList(strOfDelimiters.substring(2).split(SQUARE_BRACKETS)));
		arrayListOfDelimiters.removeAll(Arrays.asList(EMPTY_STRING, null));

		return arrayListOfDelimiters;
	}

	private static boolean isDelimiterChanged(String input) {
		return input.startsWith(CHANGE_DELIMITER_IDENTIFIER);
	}

	private static int sumOfNums(int[] intArray) {

		int sum = 0;

		for (int i : intArray) {
			sum = i > 1000 ? sum : sum + i;
		}

		return sum;
	}
}
