/**
 * Question
 * 		Given a specific date, write a function to return the day of the year for that date. The signature of the function is
 *
 *         int dayOfYear(int year, int month, int day)
 *
 *		For example, given input of year=2016, month=1, day=3. The function should return 3 as the date 2016-01-03 is the 3rd day of the year 2016.
 *		Another example, given input of year=2016, month=2, day=1. The function should return 32 as the date 2016-02-01 is the 32nd day of the year 2016.
 * @author yuchenyang
 *
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DayOfYearInterviewQuestionSolution {
	private static final int INVALID = -1;
	private static final int MONTH_MIN = 1;
	private static final int MONTH_MAX = 12;
	private static final int DAY_MIN = 1;

	//index represents month
	private static final int[] averageYearMonthdays = {INVALID, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	private static final int[] leapYearMonthdays = {INVALID, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	/**
	 * Calculate the day's ordinal of the given date
	 * @param year
	 * @param month
	 * @param day
	 * @return ordinal 
	 */
	int dayOfYear(int year, int month, int day)
	{
		int ordinal = INVALID;
		
		if(valid(year, month, day))
		{
			if(isLeapYear(year))
			{
				ordinal = calculateDaysToMonth(month, leapYearMonthdays);
			}
			else
			{
				ordinal = calculateDaysToMonth(month, averageYearMonthdays);
			}
			ordinal += day;
		}
		
		return ordinal;
	}
	
	private boolean valid(int year, int month, int day)
	{
		if(month<MONTH_MIN || month > MONTH_MAX || day < DAY_MIN)
		{
			return false;
		}
		
		return isLeapYear(year)? day <= leapYearMonthdays[month]: day <= averageYearMonthdays[month];
	}
	
	private int calculateDaysToMonth(int month, int[] monthDays)
	{
		int sum = 0;
		for(int i=1; i<month; i++)
		{
			sum += monthDays[i];
		}
		return sum;
	}
	
	private boolean  isLeapYear(int year)
	{
	  return ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));
	}
	
	@Test
	public void testIsLeapYear()
	{
		assertTrue(isLeapYear(2000));
		assertFalse(isLeapYear(1900));
	}
	
	@Test
	public void testValid()
	{
		assertTrue("2017-5-11", valid(2017,5,11));
		assertTrue("2017-2-28", valid(2017,2,28));
		assertFalse("2017-2-29", valid(2017,2,29));
		assertFalse("2017-(-1)-10", valid(2017, -1, 10));
	}
	
	@Test 
	public void testDayOfYear()
	{
		assertEquals(1, dayOfYear(2016, 1, 1));
		assertEquals(3, dayOfYear(2016, 1, 3));
		assertEquals(32, dayOfYear(2016, 2, 1));
		assertEquals(59, dayOfYear(2017, 2, 28));
		assertEquals(365, dayOfYear(2017, 12, 31));
		assertEquals(366, dayOfYear(2000, 12, 31));
		assertEquals(INVALID, dayOfYear(2017, 13, 1));
	}
}
