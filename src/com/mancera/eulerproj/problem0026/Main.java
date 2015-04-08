package com.mancera.eulerproj.problem0026;

import java.math.BigDecimal;
import java.math.RoundingMode;

/*
A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators 2 to 10 are given:

    1/2	= 	0.5
    1/3	= 	0.(3)
    1/4	= 	0.25
    1/5	= 	0.2
    1/6	= 	0.1(6)
    1/7	= 	0.(142857)
    1/8	= 	0.125
    1/9	= 	0.(1)
    1/10	= 	0.1

Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.

Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
 */

public class Main {
	
	private static final BigDecimal DECIMAL_ONE = new BigDecimal(1);

	public static void main(String[] args) {
		
		int answer = longestRecurringCycle(1000);
		System.out.println("Answer: " + answer);

	}	

	private static boolean isPrime(final int number) {
		//1 is not a prime
		if(number <= 1) {
			return false;
		}
		
		//no need to check all the way up to n-1, check until sqrt
		for(int i= 2; (i * i) <= number; i++) {
			if(number % i == 0) {
				return false;
			}
		}
		return true;		
		
	}
	
	private static int cycleLength(BigDecimal num) {
		String numString = num.toString();		
		numString = numString.substring(numString.indexOf(".") + 1);
		String firstHalf, secondHalf, lastDetectedCycle = "";		
		int currentCycleLength = 0, cyclesDetected = 0;
		
		for(int i = 1; i < numString.length() / 2; i++) {
			firstHalf = numString.substring(0, i);
			secondHalf = numString.substring(i, i * 2);
			
			if(firstHalf.equals(secondHalf)) {			
				//if a cycle was already detected, make sure that it is not contained
				if(currentCycleLength > 0) {
					String temp = repeatString(lastDetectedCycle, cyclesDetected);
					//if they're not the same, we've found a new unique cycle
					if(!temp.equals(firstHalf)) {
						currentCycleLength = i;
						lastDetectedCycle = firstHalf;
						//reset it back to 0 since this is the first of its kind
						cyclesDetected = 0;
												
					} else {
						//just stop if we already saw the same cycle 5 times.
						if(cyclesDetected == 5) {
							break;
						}						
					}
										
				} else {
					currentCycleLength = i;
					lastDetectedCycle = firstHalf;
				}
				
				cyclesDetected++;
			}
			
		}
		return currentCycleLength;
		
	}
	
	private static String repeatString(String s, int times) {		
		StringBuilder sb = new StringBuilder(s);
		while(times-- != 0) {
			sb.append(s);
		}

		return sb.toString();
	}
	
	private static int longestRecurringCycle(int limit) {
		int longestCycleLength = 0;
		int longestCycleNum = 0;
		
		
		for(int i = 1; i <= limit; i++) {
			//since I didn't understand how to determine reptend primes, being a prime will have to do for now...
			if(isPrime(i)) {
				
				BigDecimal result = DECIMAL_ONE.divide(new BigDecimal(i), 10000, RoundingMode.UP);
				int length = cycleLength(result);
				if(length > longestCycleLength) {
					longestCycleLength = length;
					longestCycleNum = i;
				}
								
			}
						
		}
		return longestCycleNum;
	}
	
	

}
