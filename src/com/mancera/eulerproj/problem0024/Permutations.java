package com.mancera.eulerproj.problem0024;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Permutations {
	
	private List<String> permutations = new ArrayList<String>();
	
	private Permutations(String source) {
		findPermutations("", source);
		Collections.sort(this.permutations);
	}
	
	public static List<String> of(String source) {
		return new Permutations(source).getPermutations();
	}
	
	
	public List<String> getPermutations() {
		return this.permutations;
	}
	
	private void findPermutations(String base, String rest) {
		
		int length = rest.length();
		//base case, once the base has all characters
		if(length == 0) {
			this.permutations.add(base);
			return;
		}
		//pass 1 char from rest to base and rest
		for(int i = 0; i < length; i++) {
			findPermutations(base + rest.charAt(i), rest.substring(0, i) + rest.substring(i+1, length));
		}
	}
}
