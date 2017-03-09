package main.linearlist;

import java.util.Arrays;
import java.util.List;

import com.sun.security.auth.SolarisNumericUserPrincipal;

/**
 * Problem
 * Rotate an array of n elements to the right by k steps
 * For example, with n=7 and k=3, the array[1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4]
 * 
 * Analysis:
 *  Regularity: switch position the 0~k element with n-1-k elements
 *   
 * @author yuchenyang
 *
 */
public class RotateArray
{
	public static void main(String[] args)
	{
		int[] inputArray = {1,2,3,4,5,6,7};
		solution1(inputArray, 3);
		System.out.println(Arrays.toString(inputArray));
	}
	
	/**
	 * Three times rotate: 
	 * 	Rotate1: 0~k-1
	 * 	Rotate2: k~nums.length-1
	 *  Rotate3: 0~nums.length-1
	 * time complexity O(n), 
	 * space complexity O(1)
	 * @param nums
	 * @param k
	 */
	public static void solution1(int[] nums, int k)
	{
		reverse(nums, 0,nums.length-k);
		reverse(nums, nums.length-k, nums.length);
		reverse(nums, 0, nums.length);
	}
	
	private static void reverse(int[]nums, int begin, int end)
	{
		int left = begin;
		int right = end-1;
		while(left<right)
		{
			swap(nums, left, right);
			left++; 
			right--;
		}
	}
	
	private static void swap(int[] nums, int i, int j)
	{
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	
	//TODO:
	/**
	 *  step1: store the front k elements into a temporary array
	 *  step2: move the back nums.length-1-k elements to the front
	 *  step3: copy over the temporary array
	 *  time complexity O(n), 
	 *  space complexity O(k)
	 * @param nums
	 * @param k
	 */
	public static void solution2(int[] nums,int k){}
	
	//TODO:
	/**
	 * step1: create a function that rotate the array to the right 1 step
	 * step2: call this function k times
	 * time complexity O(n*k), 
	 * space complexity O(1)
	 * @param nums
	 * @param k
	 */
	public static void solution3(int[] nums,int k){}
}
