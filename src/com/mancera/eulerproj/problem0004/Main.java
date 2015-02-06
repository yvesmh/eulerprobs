package com.mancera.eulerproj.problem0004;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 A palindromic number reads the same both ways. 
 The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

 Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class Main {
	
	public static void main(String[] args) {
		
		long largest = largestPalindrome(3);
		System.out.println("Largest Palindrome for two 3-digit numbers: " + largest);

		
	}
	
	private static long largestPalindrome(int numberOfDigits) {
		long bigger = (long) (Math.pow(10, numberOfDigits) -1);
		long shorter = bigger -1;
		long lowLimit = (long)(Math.pow(10,  numberOfDigits -1));
		List<Long> products = new ArrayList<Long>();
		
		while(bigger > lowLimit) {
			
			while(shorter > lowLimit) {
				
				long product = bigger * shorter;
				if(isPalindrome(product)) {
					//don't return it right away
					//instead add it to the collection
					//since it would return 999 * 583 without checking for 997*995
					products.add(product);
				}
				shorter--;
			}
			
			bigger--;
			shorter = bigger -1;
		}
		if(!products.isEmpty()) {
			return Collections.max(products);
			
		} else {
			throw new AssertionError("Shouldn't happen");	
		}
		
	}
	
	//TODO do it without converting to string. 
	// I remember doing this for microcontrollers class
	private static boolean isPalindrome(long number) {
		String numberString = Long.toString(number);
		String reversed = new StringBuilder(numberString).reverse().toString();
		
		return numberString.equals(reversed);
		
	}

}
