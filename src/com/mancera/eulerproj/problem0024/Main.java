package com.mancera.eulerproj.problem0024;

import java.util.List;

/*
A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:

012   021   102   120   201   210

What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?

 */
public class Main {
	
	private static final String PERMUTATION_SOURCE = "0123456789";
	private static final int MILLIONTH_ITEM = 1000000 - 1;

	public static void main(String[] args) {
		
		List<String> permutations =  Permutations.of(PERMUTATION_SOURCE);
		String answer = permutations.get(MILLIONTH_ITEM);
		
		System.out.println("Answer: " + answer);

	}
}
