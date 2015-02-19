package com.mancera.eulerproj.problem0016;

/**
 * Writes a number in english in compliance with British usage
 * Only validated for numbers between 1 and 1000
 * @author yves
 *
 */
public class WrittenNumber {
	
	private static final String[] UNITS = new String[] {
		//zero is written as nothing e.g. "120" is one hundred and twenty as opposed to one hundred and twenty zero
		"",
		"one",
		"two",
		"three",
		"four",
		"five",
		"six",
		"seven",
		"eight",
		"nine"		
	};
	
	private static final String[] TEENS = new String[] {
		"ten",
		"eleven",
		"twelve",
		"thirteen",
		"fourteen",
		"fifteen",
		"sixteen",
		"seventeen",
		"eighteen",
		"nineteen"
	};
	
	private static final String[] TENS = new String[] {
		"",
		"ten",
		"twenty",
		"thirty",
		"forty",
		"fifty",
		"sixty",
		"seventy",
		"eighty",
		"ninety",
	};
	private static final String HUNDRED = "hundred";
	private static final String THOUSAND = "thousand";	
	private static final String AND = "and";		
	private static final String SPACE = " ";
	private static final String HYPHEN = "-";
	
	private final int number;

	public WrittenNumber(final int number) {
		this.number = number;		
	}

	@Override
	public String toString() {		
		String thousandDigit = "";
		String hundredDigit = "";	
		String tenDigit = "";
		String unitDigit = "";
		int remaining = number;
		int thousands = 0;
		int hundreds = 0;
		int tens = 0;
		int firstDigit = 0;
		
		if(remaining >= 1000) {
			thousands = remaining / 1000;
			thousandDigit = UNITS[thousands] + SPACE + THOUSAND;
			remaining = remaining - (1000 * thousands);
		}
		
		if(remaining >= 100) {
			hundreds = remaining / 100;
			hundredDigit = UNITS[hundreds] + SPACE + HUNDRED;
			remaining = remaining - (100 * hundreds);
		}
		
		boolean isTeens = remaining > 10 && remaining < 20;
		
		if(!isTeens) {
			tens= remaining / 10;
			firstDigit = remaining % 10;
			String hyphenOrNot = firstDigit > 0? HYPHEN: "";
			tenDigit = tens > 0? TENS[tens] + hyphenOrNot: "";
			unitDigit = UNITS[firstDigit];
		} else {
			tens = remaining % 10;
			tenDigit = TEENS[tens];
		}
		
		StringBuilder builder = new StringBuilder();
		
		if(thousands > 0) {
			builder.append(thousandDigit);
		}
		
		if(hundreds > 0) {
			builder.append(hundredDigit);
			if(remaining > 0) {
				builder.append(SPACE + AND + SPACE);
			}
		}
		
		if(!isTeens) {
			builder.append(tenDigit);
			builder.append(unitDigit);			
		} else {
			builder.append(tenDigit);
		}
		
		return builder.toString();
	}

}
