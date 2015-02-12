package com.mancera.eulerproj.problem0006;

/*
	The sum of the squares of the first ten natural numbers is,

		1^2 + 2^2 + ... + 10^2 = 385
		
	The square of the sum of the first ten natural numbers is,

		(1 + 2 + ... + 10)^2 = 552 = 3025
		
	Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
	Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */
public class Main {

	public static void main(String[] args) {
		
		long difference = sumSquareDifference(100);
		System.out.println("The sum square difference of 100 is: " + difference);
		

	}
	
	private static long sumOfSquares(final int number) {
		long sum = 0;
		
		for(int i = 1; i <= number; i++) {
			sum += Math.pow(i, 2);
		}
		
		return sum;		
	}
	
	private static long squareOfSums(final int number) {
		long sum = 0;
		
		for(int i = 1; i <= number; i++) {
			sum += i;
		}
		
		return (long)Math.pow(sum,2);
	}
	
	private static long sumSquareDifference(final int number) {
		long diff = squareOfSums(number) - sumOfSquares(number);
		return diff;
	}

}
