package edu.northeastern.csye6200;

import java.util.Scanner;

public class LAB3_P2 {
	public static void main(String[] args) {
		// TODO: write your code here
	    Scanner my_sc = new Scanner(System.in);
	    System.out.print("Enter the number of values: ");
	    int size = my_sc.nextInt();
	    int[] values = new int[size];
	    System.out.print("Enter the number: ");
	    for (int i = 0; i < size; i++) {
	    	values[i] = my_sc.nextInt();
	    }
		if (isConsecutiveFour(values)) {
			System.out.println("The list has consecutive fours");
		} else {

			System.out.println("The list has no consecutive fours");
		}
		my_sc.close();
	}

	public static boolean isConsecutiveFour(int[] values) {
		// TODO: write your code here
		int size = values.length;
		if (size < 4) return false;
		int prior = values[0];
		int numberOfConsecutive = 1;
		for (int i = 1; i < size; i++) {
			if (prior == values[i]) {
				numberOfConsecutive++;
				prior = values[i];
				if (numberOfConsecutive == 4) return true;
			} else {
				numberOfConsecutive = 1;
				prior = values[i];
			}
		}
		return false;
	}

}

