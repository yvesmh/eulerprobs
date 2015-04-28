package com.mancera.eulerproj.problem0027;

public class Main {

	public static void main(String[] args) {
		
		int answer = productOfCoefficientsWithMaxPrimes(1000);
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
	
	private static int productOfCoefficientsWithMaxPrimes(final int limit) {
		
		int maxPrimes = 0;
		int maxPrimesCoefficient = 0;
		int currentPrimes;
		int cuadraticFormulaResult;
			
		for(int a = -limit; a <= limit; a++) {
			
			for(int b = -limit; b <= limit; b++) {
				
				currentPrimes = 0;	
				for(int n = 0; n <= limit; n++) {				
					cuadraticFormulaResult = (int)Math.pow(n, 2) + (a * n) + b;
					if(cuadraticFormulaResult > 0 && isPrime(cuadraticFormulaResult)) {
						currentPrimes++;
					}else { //not consecutive, so safe to break
						break;
					}
				}
				if(currentPrimes > maxPrimes) {
					maxPrimes = currentPrimes;
					maxPrimesCoefficient = a * b;
				}
			}
		}		
		
		return maxPrimesCoefficient;
	}

}
