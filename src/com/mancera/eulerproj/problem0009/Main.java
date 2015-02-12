package com.mancera.eulerproj.problem0009;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

/*
	A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

		a^2 + b^2 = c^2
		For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.

	There exists exactly one Pythagorean triplet for which a + b + c = 1000.
	Find the product abc.
 */
public class Main {

	public static void main(String[] args) {
		
		int product = pythagoreanTripletProduct(1000);
		System.out.println("Triplet: " + product);
		

	}
	
	private static int pythagoreanTripletProduct(final int number) {
		int a = 1;
		int b = 2;
		int c = 3;
		
		//TODO optimize condition
		for(a = 1; a <  number; a++) {			
			for(b = a + 1; b < number; b++) {				
				for(c = b + 1; c < number; c++) {					
					if((a * a) + (b * b) == (c * c) && (a + b + c) == number) {
						return a * b * c;						
					}					
				}
			}			
		}
		return -1;		
	}
	
	

}
