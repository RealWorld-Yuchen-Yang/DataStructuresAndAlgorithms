package main.strings;

import java.util.HashMap;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;

import org.junit.Assert;
import org.junit.Test;

/**
 * Problem: 
 * 	Given two strings s and t, determine if they are isomorphic
 * 	Two strings are isomorphic if the characters in s can be replaced to get t. 
 * 	Note: that the sequence and number of chars does not matter
 * 
 * Examples: 
 * 	Given "egg", "add", return true. 
 * 	Given "foo", "bar", return false.
 * 	Given "paper", "title", return true
 * 
 * Note:
 * 	You may assume both s and t have the same length
 * 
 * Analysis: 
 * 	We can use two HashMaps to maintain the char projection relationship
 * 	Time Complexity: O(n), 
 * 	Space Complexity: O(n)
 * @author yuchenyang
 *
 */
public class IsomorphicStrings
{
	@Test
	public void testIsIsomorphic()
	{
		String str1 = "egg";
		String str2 = "add";
		String str3 = "yyc";
		Assert.assertTrue(isIsomorphic(str1, str2));
		Assert.assertFalse(isIsomorphic(str1, str3));
	}
	
	public static boolean isIsomorphic(String s, String t)
	{
		if(s.length() != t.length())
		{
			//violate the assumption that s and t are of the same length
			return false;
		}
		
		final Map<Character, Character> map1 = new HashMap<>();
		final Map<Character, Character> map2 = new HashMap<>();
		
		for(int i=0; i<s.length(); i++)
		{
			final char c1 = s.charAt(i);
			final char c2 = t.charAt(i);
			
			if(map1.containsKey(c1))
			{
				if(map1.get(c1) != c2)
				{
					return false;
				}	
			}
			else
			{
				map1.put(c1, c2);
			}
			
			if(map2.containsKey(c2))
			{
				if(map2.get(c2)!= c1)
				{
					return false;
				}
			}
			else
			{
				map2.put(c2, c1);
			}
	
		}
		return true;
	}
}
