package com.mancera.eulerproj.problem0025;

import java.math.BigInteger;

/*


The Fibonacci sequence is defined by the recurrence relation:

    Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.

Hence the first 12 terms will be:

    F1 = 1
    F2 = 1
    F3 = 2
    F4 = 3
    F5 = 5
    F6 = 8
    F7 = 13
    F8 = 21
    F9 = 34
    F10 = 55
    F11 = 89
    F12 = 144

The 12th term, F12, is the first term to contain three digits.

What is the first term in the Fibonacci sequence to contain 1000 digits?

 */
public class Main {

	public static void main(String[] args) {
		
		int answer = firstTermOverNDigitsInFibonacciSequence(1000);
		System.out.println("Answer: " + answer);
		
	}
	
	private static int firstTermOverNDigitsInFibonacciSequence(int numOfDigits) {
		//start from 3 because 1 -> 1 ?
		int currentTerm = 4;
		BigInteger currentNumber = new BigInteger("3");
		BigInteger previousNumber = new BigInteger("2");
		BigInteger temp;
		
		while(currentNumber.toString().length() < numOfDigits) {
			temp = currentNumber;
			currentNumber = currentNumber.add(previousNumber);
			previousNumber = temp;
			currentTerm++;
		}
		
		return currentTerm;
		
	}
}
