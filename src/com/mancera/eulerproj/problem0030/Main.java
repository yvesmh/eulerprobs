package com.mancera.eulerproj.problem0030;

public class Main {

	public static void main(String[] args) {
		//ran it once until Integer.MAX_VALUE, but the last one found is 194979
		int answer = sumOfNumbersThatCanBeWrittenAsTheSumOfFifthPowersOfTheirDigits(194979);
		System.out.println("Answer: " + answer);

	}
	
	private static int sumOfNumbersThatCanBeWrittenAsTheSumOfFifthPowersOfTheirDigits(final int limit) {		
		int sum = 0;
		
		for(int i = 2; i <= limit; i++) {			
			if(sumOfFifthPowerDigits(i) == i) {				
				sum += i;				
			}			
		}
		
		return sum;	 
	}
	
	private static int[] digitsOf(final int number) {
		String numString = "" + number;
		char[] numChars = numString.toCharArray();
		int[] digits = new int[numChars.length];
		
		for(int i = 0; i < numChars.length; i++) {			
			digits[i] = numChars[i] - 0x30;
		}
		
		return digits;
	}
	
	private static int sumOfFifthPowerDigits(final int number) {
		int[] digits = digitsOf(number);		
		int sum = 0;
		
		for(int digit: digits) {			
			sum += Math.pow(digit, 5);	
		}
		
		return sum;		
	}

}
