package com.mancera.eulerproj.problem0015;

import java.math.BigInteger;

/*
	2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

	What is the sum of the digits of the number 2^1000?

 */
public class Main {

	public static void main(String[] args) {
		
		BigInteger twoToTheThousand = bigPow(2, 1000);
		long answer = sumOfDigits(twoToTheThousand);
		System.out.println("Answer: " + answer);

	}
	
	private static BigInteger bigPow(int base, int exponent) {
		return new BigInteger("" + base).pow(exponent);
	}
	
	private static long sumOfDigits(BigInteger number) {
		String digitsString = number.toString();
		char[] digitsArray = digitsString.toCharArray();
		long sum = 0;
		for(int i = 0, length = digitsArray.length; i < length; i++) {
			sum += digitsArray[i] - 0x30;
		}
		return sum;
		
	}

}
