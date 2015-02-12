package com.mancera.eulerproj.problem0005;

/*
 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
public class Main {

	public static void main(String[] args) {
		
		long smallest = smallestEvenlyDivisible(20);
		System.out.println("Smallest evenly divisible of 20: " + smallest);		

	}
	
	private static long smallestEvenlyDivisible(final int number) {
		//start at the number to avoid unnecessary iterations 
		long smallest = number;
		int evenlyDivided = 0;
		int i = 0;
		
		while(smallest < Long.MAX_VALUE) {

			for(i = 1; i <= number; i++) {
				
				if(smallest % i == 0) {
					evenlyDivided++;
					continue;
				} else {
					evenlyDivided = 0;
					smallest++;
					break;
				}
			}
			//if the number of evenly divided equals the number, we're done
			if(evenlyDivided == number) {
				return smallest;				
			}			
			
		}
		//looped until the max Long value and nothing found
		return -1;
	}

}
