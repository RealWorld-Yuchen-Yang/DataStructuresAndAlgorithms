package main.linearlist;

/**
 * Problem:
 * Implement next permutation,
 * which rearranges numbers into the lexicographically next greater permutation of numbers
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest possible order
 * (i.e. sorted in ascending order)
 * 
 * The replacement must be in-place, do not allocate extra memory
 * 
 * Analysis: 
 * 	This problem is all about finding the regularity!!!
 * 	Step1: From right to left(<---), 
 * 		   find the first digit(PartitionNumver) which violates the increase trend
 * 	Step2: From right to left(<---), 
 * 		   find the first digit which is larger than step1's partitionNumber, 
 * 		   call it changeNumber. 
 * 	Step3: Swap the partitionNumber and the changeNumber
 *  Step4: Reverse all the digit on the right of the "original" partition index
 * @author yuchenyang
 *
 */
public class NextPermutation
{
	public static void nextPermutation(int[] nums)
	{
		nextPermutation(nums, 0, nums.length);
	}
	
	/**
	 * 
	 * @param nums
	 * @param begin, nums starts from begin index
	 * @param end, nums ends at (end-1) index
	 * @return
	 */
	private static boolean nextPermutation(int[] nums, int begin, int end)
	{
		/*
		 * From right to left(<---),
		 * find the first digit (partitionNumber)
		 * which violates the increase trend
		 */
		int p = end-2;
		while(p>-1 && nums[p]>=nums[p+1])
		{
			p--;
		}
		
		/*
		 * If the PartitionNumer is not found
		 * (the whole sequence from right to left(<---) is increasing)
		 * , it means current sequence is already the largest permutation. 
		 * then rearrange to the first permutation adn return false
		 */
		if(p == -1)
		{
			reverse(nums, begin, end);
			return false;
		}
		
		/*
		 * From right to left(<---),
		 * find the first digit which is greater than the partition number, 
		 * call it changeNumber
		 */
		int c= end-1;//which is the exact end of the array
		while(c>0 && nums[c]<=nums[p])
		{
			c--;
		}
		
		/*
		 * swap the partiotionNumber and the changeNumber
		 * here nums[p] and nums[c], which are values, are swapped
		 * but the indices: p and c are not changed
		 */
		swap(nums, p, c);

		/*Reverse all the digits on the right of 
		 * original position of the partitionNumber
		 */
		reverse(nums, p+1, end);
		return true;
	}
	
	private static void swap(int[] nums, int i, int j)
	{
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	
	/**
	 * This array reverse function is universal, 
	 * which is applicable to other problems as well. 
	 * @param nums
	 * @param begin
	 * @param end
	 */
	private static void reverse(int[] nums, int begin, int end)
	{
		end--;
		while(begin<end)
		{
			swap(nums, begin++, end--);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
