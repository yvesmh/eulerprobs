package com.mancera.eulerproj.problem0029;

import java.math.BigInteger;
import java.util.TreeSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Set<BigInteger> terms = distinctTerms(100, 100);
		int answer = terms.size();
		System.out.println("Answer: " + answer);
	}
	
	private static Set<BigInteger> distinctTerms(final int a, final int b) {
		Set<BigInteger> terms = new TreeSet<BigInteger>();
		
		for(int i = 2; i <= a; i++) {
			BigInteger bigI = new BigInteger("" + i);
			
			for(int j = 2; j <= b; j++) {
				BigInteger bigJ = new BigInteger("" + j);
				terms.add(bigI.pow(j));
				terms.add(bigJ.pow(i));
			}
		}				
		return terms;		
	}

}
