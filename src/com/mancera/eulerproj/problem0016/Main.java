package com.mancera.eulerproj.problem0016;

/*
If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?

NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British usage.

 */
public class Main {
	
	private static final String[] IGNORE = new String[] {
		" ",
		"-" 
	};

	public static void main(String[] args) {
		
		long answer = countWrittenNumbers(1, 1000, IGNORE);
		System.out.println("Answer: " + answer);		

	}
	
	private static long countWrittenNumbers(final int start, final int end, final String[] ignoreCharacters) {
		
		StringBuilder builder = new StringBuilder();
		String writtenNumber = "";
		
		for(int i = start; i <= end; i++) {			
			writtenNumber = new WrittenNumber(i).toString();			
			builder.append(writtenNumber);
		}
		
		String allNumbers = builder.toString();
		
		//replace
		for(String ignore: ignoreCharacters) {
			allNumbers = allNumbers.replace(ignore, "");
		}
		
		return allNumbers.length();
		
	}

}
