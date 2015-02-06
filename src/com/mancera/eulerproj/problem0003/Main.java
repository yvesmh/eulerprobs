package com.mancera.eulerproj.problem0003;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 The prime factors of 13195 are 5, 7, 13 and 29.
 What is the largest prime factor of the number 600851475143 ?
 */
public class Main {

	public static void main(String[] args) {
		
		List<Long> myPrimeFactors = primeFactors(600851475143L);
		
		long largest = Collections.max(myPrimeFactors);
		System.out.println("Largest: "+ largest);

	}
	
	public static List<Long> primeFactors(long number) {
		List<Long> primeFactors = new ArrayList<Long>();
		
		long i = 2;
		while(number > 1) {
			while(number % i == 0) {
				primeFactors.add(i);
				number /= i;
			}
			i++;
			if((i * i) > number) {
				if(number > 1) {
					primeFactors.add(number);
				}
				break;
			}
		}
		return primeFactors;
	}

}
