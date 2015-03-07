package com.mancera.eulerproj.problem0020;

import java.math.BigInteger;

/*
n! means n × (n − 1) × ... × 3 × 2 × 1

For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

Find the sum of the digits in the number 100!

 */
public class Main {

	public static void main(String[] args) {
		long answer = sumOfDigits(factorialOf(100));
		System.out.println("Answer: " + answer);

	}
	
	private static BigInteger factorialOf(int num) {
		BigInteger result = new BigInteger("1");
		
		while(num > 1) {
			result = result.multiply(new BigInteger(String.valueOf(num)));
			num--;
		}
		return result;
	}
	
	private static long sumOfDigits(BigInteger num) {
		String numString = num.toString();
		char[] digits = numString.toCharArray();
		int sum = 0;
		for(char digit: digits) {
			sum += digit - 0x30;
		}
		return sum;
	}

}
