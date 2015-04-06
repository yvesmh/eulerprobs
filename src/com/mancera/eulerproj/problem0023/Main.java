package com.mancera.eulerproj.problem0023;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
	
	private static final int MIN_NON_SUM_OF_ABUNDANT_NUMBERS = 28123;

	public static void main(String[] args) {
		
		List<Integer> abundants =  abundantNumbers(MIN_NON_SUM_OF_ABUNDANT_NUMBERS);
		Set<Integer> allSums = allSumsOfTwoAbundants(abundants);
		int sum = 0;
		
		for(int i = 1; i <= MIN_NON_SUM_OF_ABUNDANT_NUMBERS; i++) {
			if(!allSums.contains(i)) {
				sum += i;				
			}
		}
		
		System.out.println("Answer: " + sum);
		

	}
	
	private static int sumOfProperDivisors(final int number) {
		int sum = 0;
		int limit = number / 2;
		for(int i = 1; i <= limit; i++) {
			if(number % i == 0) {
				sum += i;
			}
		}
		return sum;
	}
	
	private static List<Integer> abundantNumbers(final int limit) {
		List<Integer> numbers = new ArrayList<Integer>();
		int sumOfDivisors;
		
		for(int i = 12; i <= limit; i++) {
			sumOfDivisors = sumOfProperDivisors(i);
			if(sumOfDivisors > i) {				
				numbers.add(i);
			}
		}
		return numbers;
	}

	
	private static Set<Integer> allSumsOfTwoAbundants(final List<Integer> abundants) {
		Set<Integer> sum = new HashSet<Integer>();
		int length = abundants.size();		
		
		for(int i = 0; i < length-1; i++) {
			int base = abundants.get(i);
			sum.add(base * 2);
			
			for(int j = i + 1; j < length; j++) {
				sum.add(base + abundants.get(j));
			}
			
		}
		
		return sum;
	}

}
