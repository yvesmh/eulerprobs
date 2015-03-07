package com.mancera.eulerproj.problem0021;

/*

Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.

For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. 
The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

Evaluate the sum of all the amicable numbers under 10000.

 */
public class Main {

	public static void main(String[] args) {
		
		int answer = 0;
		for(int i = 1; i < 10000; i++) {
			if(isAmicable(i)) {
				answer += i;
			}
		}
		
		System.out.println("Answer: " + answer);

	}
	
	private static int sumOfProperDivisors(int num) {
		int sum = 0;
		int half = num /2;
		for(int i = 1; i <= half; i++ ) {
			if(num % i == 0) {
				sum += i;
			}
		}
		return sum;
	}
	
	
	private static boolean isAmicable(int num) {
		int sumOfDivisors = sumOfProperDivisors(num);
		//it's not amicable if a != b
		if(sumOfDivisors == num) {
			return false;
		}
		int sumOfTheSumOfDivisors = sumOfProperDivisors(sumOfDivisors);
		return sumOfTheSumOfDivisors == num;
	}

}
