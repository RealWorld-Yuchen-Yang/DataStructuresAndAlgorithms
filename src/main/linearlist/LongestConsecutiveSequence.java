package main.linearlist;

import java.util.HashSet;

/**
 * Problem: 
 * Given an unsorted array of integers, 
 * find the length of the longest consecutive elements sequnce. 
 * For example, Given [100, 4, 200, 1, 3, 2]
 * The longest consecutive elements seqeunce is [1,2,3,4]
 * 
 * Analysis: 
 * 	If time complexity O(nlogn) is allowed, we can sort the array first
 * 	However, it requires O(n)
 * 	What is more, the array is unsorted, we can use a HashSet
 * 	We use a HashSet to store all appeared elements, 
 * 	use the element as a pivot and consecutively expand to the left and right, 
 * 	record the maximum length
 * 
 * 
 * @author yuchenyang
 *
 */
public class LongestConsecutiveSequence
{
	public static int longestConsecutive(int[] nums)
	{
		final HashSet<Integer> set = new HashSet<>();
		for(int i: nums)
		{
			//put & retrieve from HashSet, time complexity are all O(n)
			set.add(i);
		}
		
		int longest = 0;
		for(int i: nums)
		{
			int length = 1;
			for(int j=i-1; set.contains(j);j--)
			{
				//move to lower side
				set.remove(j);//brute force remove, without checking existance first
				++length;
			}
			for(int j=i+1; set.contains(j);j++)
			{
				//move to lower side
				set.remove(j);//brute force remove, without checking existance first
				++length;
			}
			longest = Math.max(longest, length);
//			for(Integer integer : set)
//			{
//				System.out.print(integer);
//			}
//			System.out.println();
		}
		return longest;
	}
	
	public static void main(String[] args)
	{
		System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
	}
}
