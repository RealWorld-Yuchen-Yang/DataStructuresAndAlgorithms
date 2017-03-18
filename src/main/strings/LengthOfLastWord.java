package main.strings;


/**
 * Problem: 
 * 	Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * 	return the length of last word in the string. 
 * 	If the last word does not exist, return 0
 * 
 * Note: A word is defined as a character sequence consists of non-space characters only. 
 * 
 * Analysis: 
 * 	Search from right to left, 
 * 	step1: find the first alphabetic char j
 * 	step2: find the first non-alphabetic char i
 *  the distance (j-i) between these two chars is the last word's length
 * 
 * @author yuchenyang
 *
 */
public class LengthOfLastWord
{
	public int lengthOfLastWord(String s)
	{
		final Predicate isAlphabet = new Predicate()
		{
			@Override
			public boolean apply(char ch)
			{
				
				return Character.isAlphabetic(ch);
			}
		};
		
		final Predicate isNotAlphabet = new Predicate()
		{
			
			@Override
			public boolean apply(char ch)
			{
				return !Character.isAlphabetic(ch);
			}
		};
		
		//MainLogic
		int j = findIndex(s, s.length()-1, isAlphabet);
		int i = findIndex(s, j, isNotAlphabet);//by starting from j, I can skip a few chars
		return j-i;
	}
	
	private static int findIndex(final String s, int fromIndex, Predicate p)
	{
		for(int i = fromIndex; i>=0; i--)
		{
			if(p.apply(s.charAt(i)))
			{
				return i;
			}
		}
		
		return -1;
	}
	
	private interface Predicate
	{
		boolean apply(char ch);
	}
}
