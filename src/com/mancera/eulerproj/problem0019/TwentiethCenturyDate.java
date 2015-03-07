package com.mancera.eulerproj.problem0019;

public class TwentiethCenturyDate {
	
	private final int day;
	private final int month;
	private final int year;
	private final int dayOfTheWeek;
	
	private final int daysInCurrentMonth;
	private final boolean isLeapYear;
	
	private static final int[] daysInMonth = {
      0, // nothing at 0 index, won't use it
      31, //january
      28, //february
      31, //march
      30, //april
      31, //may
      30, //june
      31, //july
      31, //august
      30, //september
      31, //october
      30, //november
      31 //december                           
	};
	
	
	public TwentiethCenturyDate(int day, int month, int year, int dayOfWeek) {
		this.day = day;
		this.month = month;
		this.year = year;
		
		this.dayOfTheWeek = dayOfWeek;
		
		boolean isLeapYear = false;
		if(year % 4 == 0) {
			if(year % 100 == 0){
				if(year % 400 == 0) {
					isLeapYear = true;
				}
			} else {
				isLeapYear = true;
			}
		}
		
		this.isLeapYear = isLeapYear;
		this.daysInCurrentMonth = month == 2 && isLeapYear? 29:  daysInMonth[month];
		
	}
	
	public TwentiethCenturyDate nextMonth() {
		
		int nextDayOfTheWeek =  this.dayOfTheWeek + (this.daysInCurrentMonth % 7);
		//if it's bigger than 7, it subtracts 7, if not, it stays the same
		nextDayOfTheWeek %= 7;
		
		int nextMonth = this.month;
		int nextYear = this.year;
		if(this.month == 12) {
			nextMonth = 1;
			nextYear++;
		} else {
			nextMonth++;
		}
		
		return new TwentiethCenturyDate(this.day, nextMonth, nextYear, nextDayOfTheWeek);
	}
	
	public TwentiethCenturyDate nextYear() {
		int daysInYear = this.isLeapYear? 366: 365;
		int nextDayOfWeek = this.dayOfTheWeek + (daysInYear % 7);
		nextDayOfWeek %= 7;
		return new TwentiethCenturyDate(this.day, this.month, this.year +1, nextDayOfWeek);
	}
	
	
	// 1 = sunday
	// 2 = monday
	// 3 = tuesday
	// 4 = wednesday
	// 5 = thursday
	// 6 = friday
	// 7 = saturday
	public int getDayOfTheWeek() {
		return this.dayOfTheWeek;
	}
	
	public boolean isTwentiethCentury() {
		return this.year >= 1901 && this.year <= 2000;
	}

}
