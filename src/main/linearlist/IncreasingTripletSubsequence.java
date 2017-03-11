package main.linearlist;

/**
 * Problem: 
 * 	Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array
 * 	More specifically, if there exists i, j, k, such that arr[i]< arr[j]< arr[k], given 0<=i<j<k<=n-1
 * 	return true else return false
 * 	
 * 	Your function should run in O(n) time complexity and O(1) space complexity
 * 
 * Analysis: 
 * 	Parse the array once, 
 * 	x1 stores the current minimum, 
 * 	x2 stores the current second minimum,
 * 	if an element greater than x2 exists
 * 	return true, else return false
 * @author yuchenyang
 *
 */
public class IncreasingTripletSubsequence
{
	public static boolean increasingTriplet(int[] nums)
	{
		int x1 = Integer.MAX_VALUE;
		int x2 = Integer.MAX_VALUE;
		
		for(int x: nums)
		{
			if(x<=x1)
			{
				x1 = x;
			}
			else if(x<x2)
			{
				x2=x;
			}
			else
			{
				return true;
			}
		}
		return false;
	}
}	












