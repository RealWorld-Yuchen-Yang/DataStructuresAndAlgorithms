package main.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem: 
 * 	Given an array of strings, return all groups of strings that are anagrams
 * 
 * Analysis: 
 * 	Definition of Anagrams: string sequences that contain same characters, ignoring spaces
 * 	The chacracteristics of these kind of strings are: 
 * 		1) characters are the same
 * 		2) number of characters are the same, as well
 * 
 * Solution: 
 * 	we can sort chars in these strings, if after sorting, strings are equal
 *  then they are anagrams respectively
 * @author yuchenyang
 *
 */
public class Anagrams
{
	public static List<List<String>> groupAnagrams(String[] strs)
	{
		final HashMap<String, List> groups = new HashMap<>();
		for(final String s: strs)
		{
			char[] tmp = s.toCharArray();
			Arrays.sort(tmp);
			
			final String key = new String(tmp);
			if(!groups.containsKey(key))
			{
				groups.put(key, new ArrayList());
			}
			
			groups.get(key).add(s);
		}
		
		List<List<String>> result = new ArrayList();
		for(Map.Entry<String, List> entry: groups.entrySet())
		{
			final List<String> list = entry.getValue();
			Collections.sort(list);
			result.add(list);
		}
		return result;
	}
}
