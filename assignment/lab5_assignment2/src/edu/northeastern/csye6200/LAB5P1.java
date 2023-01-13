package edu.northeastern.csye6200;

public class LAB5P1 {
	public static void main(String[] args) {
		// TODO: write your code here
		MyInteger n1 = new MyInteger(7);
		System.out.println("n1 is even? " + n1.isEven());
		System.out.println("n1 is prime? " + n1.isPrime());
		System.out.println("15 is prime? " + MyInteger.isPrime(15));
		System.out.println("parseInt(char[]) for { '4', '3', '7', '8' } = " + MyInteger.parseInt(new char[]{'4', '3', '7', '8'}));
		System.out.println("parseInt(String) for \"4378\" = " + MyInteger.parseInt("4378"));
		
		MyInteger n2 = new MyInteger(24);
		System.out.println("n2 is odd? " + n2.isOdd());
		System.out.println("45 is odd? " + MyInteger.isOdd(45));
		System.out.println("n1 is equal to n2? " + n1.equals(n2));
		System.out.println("n1 is equal to 5? " + n1.equals(5));
	}
}

class MyInteger {
	
	// TODO: write your code here
	int value;
	
	public int getValue() {
		// TODO: write your code here
		return value;
	}

	public MyInteger(int value) {
		// TODO: write your code here
		this.value = value;
	}

	public boolean isPrime() {
		// TODO: write your code here
		if (value < 2) return false;
		if (value == 2) return true;
		if (value > 2) {
			for (int i = 2; i < value; i++) {
				if (value % i == 0) return false;
			}
		}
		return true;
	}

	public static boolean isPrime(int num) {
		// TODO: write your code here
		if (num < 2) return false;
		if (num == 2) return true;
		if (num > 2) {
			for (int i = 2; i < num; i++) {
				if (num % i == 0) return false;
			}
		}
		return true;
	}

	public static boolean isPrime(MyInteger o) {
		// TODO: write your code here
		int value = o.getValue();
		if (value < 2) return false;
		if (value == 2) return true;
		if (value > 2) {
			for (int i = 2; i < value; i++) {
				if (value % i == 0) return false;
			}
		}
		return true;
	}

	public boolean isEven() {
		// TODO: write your code here
		return (value % 2 == 0);
	}

	public boolean isOdd() {
		// TODO: write your code here
		return (value % 2 == 1);
	}

	public static boolean isEven(int n) {
		// TODO: write your code here
		return (n % 2 == 0);
	}

	public static boolean isOdd(int n) {
		// TODO: write your code here
		return (n % 2 == 1);
	}

	public static boolean isEven(MyInteger n) {
		// TODO: write your code here
		return (n.getValue() % 2 == 0);
	}

	public static boolean isOdd(MyInteger n) {
		// TODO: write your code here
		return (n.getValue() % 2 == 1);
	}

	public boolean equals(int anotherNum) {
		// TODO: write your code here
		return (value == anotherNum);
	}

	public boolean equals(MyInteger o) {
		// TODO: write your code here
		if (o instanceof MyInteger) {
			return (value == o.getValue());
		}
		return false;
	}

	public static int parseInt(char[] numbers) {
		// numbers consists of digit characters.
		// For example, if numbers is {'1', '2', '5'}, the return value
		// should be 125. Please note that
		// numbers[0] is '1'
		// numbers[1] is '2'
		// numbers[2] is '5'

		// TODO: write your code here
		
		int result = 0;
		for (int i = 0; i < numbers.length; i++) {
			result *= 10;
			result += numbers[i] - '0';
		}
		return result;
	}

	public static int parseInt(String s) {
		// s consists of digit characters.
		// For example, if s is "125", the return value
		// should be 125.
		
		// TODO: write your code here
		char[] charArr = s.toCharArray();
		return parseInt(charArr);
	}
}