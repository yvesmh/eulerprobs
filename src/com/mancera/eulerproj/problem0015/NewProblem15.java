package com.mancera.eulerproj.problem0015;

import java.math.BigInteger;

/*
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.
 */
public class NewProblem15 {
	
	//Euler Project changed problems when I had already solved a problem 15 before, so this is the new unsolved problem 15
	public static void main(String[] args) {		
		BigInteger answer = binomialCoefficient(40, 20);
		System.out.println("Answer: " + answer);		
		
	}
	
	private static BigInteger factorial(final int num) {
		BigInteger result = new BigInteger("1");
		for(int i = 1; i <= num; i++) {
			result =  result.multiply(new BigInteger("" + i));
		}
		return result;
		
	}
	
	private static BigInteger binomialCoefficient(final int n, final int k) {
		BigInteger factorialOfN = factorial(n);
		BigInteger factorialOfK = factorial(k);
		BigInteger factorialOfNMinusK = factorial(n - k);
		
		return factorialOfN.divide(factorialOfK.multiply(factorialOfNMinusK)); 
	}

}
