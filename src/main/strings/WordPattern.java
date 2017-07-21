package main.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem
 * 	Given a pattern and a string str, find if str follows the same pattern
 * 	Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str
 *
 * Example:
 * 	1. pattern = "abba", str = "dog cat cat dog", should return true;
 * 	2. pattern = "abba", str = "dog cat cat fish", should return false;
 * 	3. pattern = "aaaa", str = "dog cat cat dog", should return false;
 * 	4. pattern = "abba", str = "dog dog dog dog", should return false;
 *
 * Note:
 * 	You may assume pattern contains only lowercase letters,
 * 	and str contains lowercase letters separated by a single space.
 *
 * Analysis:
 * 	This problem is similar to Isomorphic Strings,
 * 	use two HashMap to store the bijection
 * @author yuchenyang
 *
 */
public class WordPattern
{
	public boolean wordPattern(String pattern, String str)
	{
		String[] words = str.split(" ");
		if(words.length != pattern.length())
		{
			return false;
		}

		final Map<Character, String> map1 = new HashMap();
		final Map<String, Character> map2 = new HashMap();


		for(int i = 0; i<words.length; i++)
		{
			final Character key1 = pattern.charAt(i);
			if(map1.containsKey(key1))
			{
				final String value = map1.get(key1);
				if(!value.equals(words[i]))
				{
					return false;
				}
			}
			else
			{
				map1.put(key1, words[i]);
			}

			final String key2 = words[i];
			if(map2.containsKey(key2))
			{
				final char value = map2.get(key2);
				if(value != pattern.charAt(i))
				{
					return false;
				}
			}
			else
			{
				map2.put(key2, pattern.charAt(i));
			}
		}

		return true;
	}
}
