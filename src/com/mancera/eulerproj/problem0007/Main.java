package com.mancera.eulerproj.problem0007;

/*
	By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
	What is the 10 001st prime number?
 */
public class Main {

	public static void main(String[] args) {
		
		int n = 10001;
		long p = nthPrime(n);
		System.out.println("The " + n + "th prime is: " + p);

	}
	
	private static long nthPrime(final int number) {
		int primesCounted = 0;
		long currentPrime = 2;
		int i = 2;
		
		while(primesCounted < number) {
			
			if(isPrime(i)) {
				primesCounted++;
				currentPrime = i;
			}
			i++;			
		}
		
		return currentPrime;
		
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

}
