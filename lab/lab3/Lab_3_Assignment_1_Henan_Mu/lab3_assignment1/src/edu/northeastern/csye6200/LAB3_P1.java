package edu.northeastern.csye6200;

import java.util.Scanner;

public class LAB3_P1 {
	public static void main(String[] args) {
		// TODO: write your code here
	    Scanner my_sc = new Scanner(System.in);
	    System.out.print("Enter a credit card number as a long integer: ");
	    String cardNumberString = my_sc.nextLine();
		long cardNumberLong = Long.parseLong(cardNumberString);
		if (isValid(cardNumberLong)) {
			System.out.println(cardNumberString + " is valid");
		}
		else {
			System.out.println(cardNumberString + " is invalid");
		}
	    my_sc.close();
	}

	/** Return true if the card number is valid */
	public static boolean isValid(long number) {
		// TODO: write your code here
		if (getSize(number) >= 13 && getSize(number) <= 16) {
			if (prefixMatched(number, 4) || prefixMatched(number, 5) || prefixMatched(number, 6) || prefixMatched(number, 37)) {
				int check = sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);
				if (check % 10 == 0) return true;
			}
		}
		return false;
	}

	/** Get the result from Step 2 */
	public static int sumOfDoubleEvenPlace(long number) {
		// TODO: write your code here
		int resutl = 0;
		number /= 10;
		while (number > 0) {
			resutl += getDigit(2 * ((int)number % 10));
			number /= 100;
		}
		return resutl;
	}

	/**
	 * Return this number if it is a single digit, otherwise, return the sum of
	 * the two digits
	 */
	public static int getDigit(int number) {
		// TODO: write your code here
		if (number < 10) return number;
		else return ((number % 10) + (number / 10));
	}

	/** Return sum of odd place digits in number */
	public static int sumOfOddPlace(long number) {
		// TODO: write your code here
		int resutl = 0;
		while (number > 10) {
			resutl += number % 10;
			number /= 100;
		}
		return resutl;
	}

	/** Return true if the digit d is a prefix for number */
	public static boolean prefixMatched(long number, int d) {
		// TODO: write your code here
		while (number > 0) {
			if (number == d) return true;
			number /= 10;
		}
		return false;
	}

	/** Return the number of digits in d */
	public static int getSize(long d) {
		// TODO: write your code here
		int size = 0;
		while (d > 0) {
			size++;
			d /= 10;
		}
		return size;
	}

	/**
	 * Return the first k number of digits from number. If the number of digits
	 * in number is less than k, return number.
	 */
	public static long getPrefix(long number, int k) {
		// TODO: write your code here
		int size = getSize(number);
		if (size <= k) return number;
		else {
			int numberBeRemoved = size - k;
			for (int i = 0; i < numberBeRemoved; i++) number /= 10;
			return number;
		}
	}
}
