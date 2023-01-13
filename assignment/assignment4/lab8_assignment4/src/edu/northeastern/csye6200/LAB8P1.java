package edu.northeastern.csye6200;

import java.util.Random;
import java.util.Scanner;

public class LAB8P1 {
	public static void main(String[] args) {
		// TODO: write your code here
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of rows: ");
		int rows = input.nextInt();
		System.out.print("Enter the number of columns: ");
		int columns = input.nextInt();
		System.out.println();
		input.close();
		
		System.out.println("The array content is:");
		Random rnd = new Random();
		int seed = 1331; //Optional: set seed to create repeatable results
		rnd.setSeed(seed);
		int[][] matrix = new int[rows][columns];
		for (int r = 0; r < rows; r++)
			for (int c = 0; c < columns; c++)
				matrix[r][c] = rnd.nextInt(10);
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < columns; c++) {
				System.out.print(matrix[r][c]);
				System.out.print(' ');
			}
			System.out.println();
		}
		System.out.println();
		
		int largestRow = 0;
		int indexOfLargestRow = 0;
		for (int r = 0; r < rows; r++) {
			if (sumRow(matrix[r]) > largestRow) {
				largestRow = sumRow(matrix[r]);
				indexOfLargestRow = r;
			}
		}
		System.out.printf("The index of the largest row: %d\n", indexOfLargestRow);
		
		int largestCol = 0;
		int indexOfLargestCol = 0;
		for (int c = 0; c < columns; c++) {
			if (sumColumn(matrix, c) > largestCol) {
				largestCol = sumColumn(matrix, c);
				indexOfLargestCol = c;
			}
		}
		System.out.printf("The index of the largest column: %d\n", indexOfLargestCol);
	}

	public static int sumRow(int row[]) {
		// TODO: write your code here
		int sum = 0;
		for (int value:row) sum += value;
		return sum;
	}

	public static int sumColumn(int matrix[][], int column) {
		// TODO: write your code here
		int sum = 0;
		int numberOfRows = matrix.length;
		for (int r = 0; r < numberOfRows; r++) sum += matrix[r][column];
		return sum;
	}
}
