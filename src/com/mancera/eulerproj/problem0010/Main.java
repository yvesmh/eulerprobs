package com.mancera.eulerproj.problem0010;

/*
	The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
	Find the sum of all the primes below two million.
 */
public class Main {

	public static void main(String[] args) {
		
		long n = 2000000;
		long sum = sumOfPrimesBelow(n);
		System.out.println("Sum of all primes below " + n + " is " + sum);

	}
	
	private static long sumOfPrimesBelow(final long number) {
		long sum = 0;
		for(int i = 2; i <= number; i++) {
			
			if(isPrime(i)) {
				sum += i;
			}
		}
		return sum;		
	}
	
	//copied from problem 7
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

}
