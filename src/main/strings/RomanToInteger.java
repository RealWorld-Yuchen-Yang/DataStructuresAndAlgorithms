package main.strings;

/**
 * Problem: 
 * 	Given a roman numeral, convert it to an integer
 * 	Input is guranteed to be within the range from 1 to 3999
 * 
 * Analysis: 
 * 	Parse from front to end, use a temporary variable to store the digit separator
 * 	If the currenValue > previousValue, currentRadix = currentValue-previousValue, 
 * 	otherwise, add the currentValue to the result
 * 
 * @author yuchenyang
 *
 */
public class RomanToInteger
{
	//Time complexity O(n), space complexity O(1)
	public int romanToInt(String s)
	{
		int result = 0;
		for(int i=0; i<s.length(); i++)
		{
			if(i>0 && map(s.charAt(i) )> map(s.charAt(i-1)))
			{
				result +=(map(s.charAt(i))-2*map(s.charAt(i-1)));
			}
			else
			{
				result +=map(s.charAt(i));
			}
		}
		return result;
	}
	
	private static int map(char c)
	{
		switch(c)
		{
		case 'I': return 1;
		case 'V': return 5;
		case 'x': return 10;
		case 'L': return 50;
		case 'C': return 100;
		case 'D': return 500;
		case 'M': return 1000;
		default: return 0;
		}
		
	}
}
