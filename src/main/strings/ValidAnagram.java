package main.strings;

/**
 * Problem: 
 * 	Given two strings s and t, write a function to determine if t is an anagram of s. 
 * 	You should use space complexity O(1)
 * 
 * Note:	
 * 	You may assume the string contains only lowercase alphabets
 * 
 * Analysis: 
 * 	Initialize one CharArray[26], 
 * 	initialize the CharArray by counting the occurrence of each characters in String s
 * 	in the String t, if one character occurs, decrease the counter in the CharArray by 1
 * 	only if all elements in the CharArray decreased to exactly 0,
 * 	will it mean that string s and t are anagrams.
 * @author yuchenyang
 *
 */
public class ValidAnagram
{
	private static final int ALPHABET_SIZE = 26;
	public boolean isAnagram(String s, String t)
	{
		final int[] map = new int[ALPHABET_SIZE];
		
		for(int i=0; i<s.length(); i++)
		{
			map[s.charAt(i-'a')]++;
		}
		
		for(int i=0; i<t.length();i++)
		{
			map[t.charAt(i-'a')]--;
		}
		
		for(int charOccur: map)
		{
			if(charOccur != 0)
			{
				return false;
			}
		}
		
		return true;
	}
	
}
