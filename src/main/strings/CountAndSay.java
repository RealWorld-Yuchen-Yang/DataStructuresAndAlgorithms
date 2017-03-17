package main.strings;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * Problem: 
 * 	The count-and-say sequence is the sequence of integers beginning as follows: 
 * 	NumberOfOccurence+Value
 * 
 * Examples:
 * 	1 is read off as "one 1", or 11;
 *	11 is read off as "two 1s", or 21
 *	21 is read off as "one 2 one 1", or 1211
 *
 * Note the sequence of integers will be represented as a string
 * 
 * @author yuchenyang
 *
 */
public class CountAndSay
{
	public static void main(String[] args)
	{
		int inputN = 1211;
		System.out.println(new CountAndSay().countAndSay(inputN));
	}
	
	public String countAndSay(int n)
	{
		String inputDigitSequence = (new Integer(n)).toString();
		StringBuilder result = new StringBuilder();
		
		int index = 0; 
		String nextSubString = inputDigitSequence;
		while(index<inputDigitSequence.length())
		{
			
			int nextSequenceStartIndex = nextNotEqual(nextSubString);
			if(nextSequenceStartIndex == -1)
			{
				break;
			}
			
			int currentSequenceLength = nextSubString.length();
			
			if(index != 0)
			{
				result.append(",");
			}
			result.append(nextSequenceStartIndex);
			result.append(nextSubString.charAt(0));
			
			nextSubString = nextSubString.substring(nextSequenceStartIndex, currentSequenceLength);
			index += nextSequenceStartIndex;
			
		}
		return result.toString();
	}
	
	/*
	 * This is the key function of this problem: 
	 * 	find the first char not equal to fromIndex
	 * 	by scanning forward everytime
	 * 
	 */
	private static int nextNotEqual(final String s)
	{
		if(s != null && !s.equals(""))
		{
			final char target = s.charAt(0);
			int i=0;
			for(;i<s.length();i++)
			{
				if(s.charAt(i) != target)
				{
					break;
				}
			}
			return i;	
		}
		return -1;
	}
}
