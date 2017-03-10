package main.linearlist;

import java.util.TreeSet;

import javafx.scene.control.TreeCell;

/**
 * Problem: 
 * Given an array of integers, find out whether there are two distinct indices i and j
 * in the array such that the difference between nums[i] and nums[j] is at most t and 
 * the difference between i and j is at most k
 * 
 * Analysis: 
 * For one integer in an array,
 * if we can find out 
 * the smallest element that is greater than it 
 * the largest element that is less than it
 * then we can calculate these two elements' difference 
 * so as to determine if it is less than t
 * 
 * Data structure that satisfies such characteristic is BST
 * An element's left child is the largest element smaller than it
 * and its right child is the smallest element greater than it. 
 *  
 * We can create a sliding window containing k elements. 
 * Then construct the k element in the sliding window into a tree. 
 * For each iteration, move the sliding window one step further along the array, that is
 * add a next element into the window 
 * and remove the oldest element out of the window
 * in this way we keep updating the tree, and if at one time, 
 * there are two elements' difference is greater than t, 
 * then return true, 
 * if after parsing the whole array still does not encounter such situation, 
 * return false
 * 
 * In Java we can use the TreeSet to construct the BST
 * 
 * Time Complexity: O(nlogk), 
 * Space Complexity: O(k) 
 *
 * @author yuchenyang
 *
 */
public class ContainsDuplicateIII
{
	/**
	 * 
	 * @param nums
	 * @param k, index difference
	 * @param t, value difference
	 * @return
	 */
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t)
	{
		if(k<1 || t<0)
		{
			return false;
		}
		
		final TreeSet<Integer> set = new TreeSet<>();
		for(int i=0; i<nums.length; i++)
		{
			final int x = nums[i];
			final Integer floor = set.floor(x);
			final Integer ceiling = set.ceiling(x);
			
			if((floor != null && x<=floor+t)
				|| (ceiling != null && x>=ceiling-t))
			{
				return true;
			}
			set.add(x);
			if(i>=k)
			{
				set.remove(nums[i-k]);
			}
		}
		return false;
	}
}

















