package main.sorting.radixsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Problem: 
 * Given an unsorted array, 
 * find the maximum difference between the successive elements in its sorted form
 * 
 * Try to solve it in linear time and space
 * Return 0 if the array contains less than 2 elements
 * 
 * You may assume all elements in the array are non-negative integers 
 * and fit in the 32-bit signed integer range
 * 
 * Analysis: 
 * Step1: we need to sort the unsorted array. 
 * 		  Since the requirement is O(n), time complexity, 
 * 		  Applicable sorting algorithms are: 
 * 		  bucket sort, radix sort, counting sort
 * @author yuchenyang
 *
 */
public class MaximumGap
{
	public static int bucketSortImplementation(int[] nums)
	{
		if(nums.length < 0)
		{
			return 0;
		}
		//Step1: sorting the array by using bucket sort 
		bucketSort(nums);
		
		//Step2: Fix the max gap
		return maxDiff(nums);
	}
	
	private static void bucketSort(int[] nums)
	{
		if(nums.length<2)
		{
			return;
		}
		
		/*
		 * step1.1: 
		 * Iterate through the array for the first time
		 * So as to find the min and max value in the array
		 */
		int minVal = Integer.MAX_VALUE;
		int maxVal = Integer.MIN_VALUE;
		for(int i: nums)
		{
			minVal = Math.min(nums[i], minVal);
			maxVal = Math.max(nums[i], maxVal);
		}
		
		/*
		 * Step1.2 calculate the #bucktes and #elements in bucket
		 */
		final int bucketSize = (maxVal - minVal)/nums.length + 1;//#elements in one bucket
		final int bucketCount = (maxVal- minVal)/bucketSize + 1;//#buckets 
		
		final ArrayList<Integer>[] buckets = new ArrayList[bucketCount];
		for(int i=0; i<buckets.length; i++)
		{
			buckets[i] = new ArrayList<>();
		}
		
		/*
		 * Step1.3
		 * assign each element into its corresponding bucket
		 */
		for(int x: nums)
		{
			final int index = (x-minVal)/bucketSize;
			buckets[index].add(x);
		}
		
		/*
		 * Step1.4 Sort each bucket respectively
		 */
		for(final ArrayList<Integer> bucket: buckets)
		{
			Collections.sort(bucket);
		}
		
		/*
		 * Combine and put the sorted elements in each buckets together
		 * Since buckets are ordered, 
		 * we can just iterate through them
		 * and combine them in sequence  
		 */
		int i = 0;
		for(final ArrayList<Integer> bucket: buckets)
		{
			for(int x: bucket)
			{
				nums[i++] = x;
			}
		}	
	}
	
	public static int radixSortImplementation(int[] nums)
	{
		if(nums.length < 2)
		{
			return 0;
		}
		
		//Step1. Sort the array by using radix sort
		radixSort(nums);
		
		//Step2. Find the max diff
		return maxDiff(nums);
	}
	
	private static void radixSort(int[] nums)
	{
		//Step1.1 Radix sort also need to find the minVal and maxVal of the given array
		int minVal = Integer.MAX_VALUE;
		int maxVal = Integer.MIN_VALUE;
		for(int i: nums)
		{
			minVal = Math.min(minVal, nums[i]);
			maxVal = Math.max(maxVal, nums[i]);
		}
		
		/*
		 * here we are actually do the radix sort base on
		 * each element's difference between the minVal, 
		 * instead of the absolute value of the elements, 
		 * The reason is because we would like to reduce 
		 * the number of digits to be compared with. 
		 * Also by doing this, the sorted sequence is the same
		 */
		final int D = Integer.toString(maxVal-minVal).length();//D: number of digits in (maxVal-minVal)
		/*
		 * Initialize 10 buckets, 
		 * each bucket used to save elements 
		 * whose radix is  0~9 radix of the current iteration
		 */
		final ArrayList<Integer>[] buckets = new ArrayList[10];
		for(int i=0; i<buckets.length; i++)//here buckets.lenght is 10, means we initialized 10 buckets
		{
			buckets[i] = new ArrayList();//here we do not specify the bucket's size, for we do not know
		}
		
		for(int i=0; i < D; i++)
		{
			//find the index of bucket that the current element will fall into
			for(int x: nums)
			{
				final int index = getDigit(x-minVal, i);
				buckets[index].add(x);
			}
			
			//add the element from each bucket back to the array so as to be prepared for the next round
			int index = 0;
			for(ArrayList<Integer> bucket: buckets)
			{
				for(int x: bucket)
				{
					nums[index++] = x;
				}
				bucket.clear();
			}
		}
	}
	
	/*
	 * get the i-th digit of number n
	 */
	private static int getDigit(int n, int i)
	{
		for(int j=0; j<i; j++)
		{
			n /= 10;
		}
		return n % 10;
	}
	
	private static int maxDiff(int[] nums)
	{
		int maxDiff = Integer.MIN_VALUE;
		
		for(int i=1; i<nums.length; i++)
		{
			maxDiff=Math.max(maxDiff, nums[i]-nums[i-1]);
		}
		
		return maxDiff;
	}
	
	//Counting sort is an extreme condition of bucket sort(with maximum buckets)
	public static int countingSortImplementation(int[] nums)
	{
		if(nums.length < 2)
		{
			return 0;
		}
		
		//Step1 counting sort
		countingSort(nums);
		
		//step2 find the max diff
		return maxDiff(nums);
	}
	
	private static void countingSort(int[] nums)
	{
		int minVal = Integer.MAX_VALUE;
		int maxVal = Integer.MIN_VALUE;
		
		for(int i : nums)
		{
			minVal = Math.min(minVal, nums[i]);
			maxVal = Math.max(maxVal, nums[i]);
		}
		
		final int[] buckets = new int[maxVal - minVal +1];
		
		//assign each element in its corressponding bucket
		for(int i: nums)
		{
			buckets[i-minVal]++;
		}
		
		for(int i=0, index = 0; i<buckets.length; i++)
		{
			Arrays.fill(nums, index, index+buckets[i], i+minVal);
			index +=buckets[i];
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
