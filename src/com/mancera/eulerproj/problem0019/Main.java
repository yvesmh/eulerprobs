package com.mancera.eulerproj.problem0019;
/*


You are given the following information, but you may prefer to do some research for yourself.

    1 Jan 1900 was a Monday.
    Thirty days has September,
    April, June and November.
    All the rest have thirty-one,
    Saving February alone,
    Which has twenty-eight, rain or shine.
    And on leap years, twenty-nine.
    A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.

How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?

 */
public class Main {
	
	private static final TwentiethCenturyDate janFirstNineteenHundred 
	 	= new TwentiethCenturyDate(1, 1, 1900, 2);

	public static void main(String[] args) {
		
		int answer = sundaysOnFirstOfTheMonth();
		System.out.println("Answer: " + answer);

	}
	
	private static int sundaysOnFirstOfTheMonth() {
		int sum = 0;
		
		TwentiethCenturyDate date = janFirstNineteenHundred.nextYear();
		
		while(date.isTwentiethCentury()) {
			
			if(date.getDayOfTheWeek() == 1) {
				sum++;
			}
			date = date.nextMonth();
		}
		
		return sum;
	}

}
