package main.binarytree;

/**
 * Given an array where elements are sorted in ascending order
 * Convert it to a height balanced BST
 * 
 * Analysis: 
 * 	considering the characteristics of a BST
 * 	each "subRoot" was placed in the subSortedArray's middle
 * 	this is a recursive characteristic
 * 	so we recursively solve this problem
 * @author yuchenyang
 *
 */
public class ConvertSortedArrayToBinarySearchTree {
	public static TreeNode recursivelyConvert(int[] nums)
	{
		return recursivelyConvert(nums, 0, nums.length);
	}
	
	/**
	 * 
	 * @param nums, the subArray
	 * @param begin, beginning index of the subarray
	 * @param end, ending index of the subarray
	 * @return
	 */
	private static TreeNode recursivelyConvert(int[] nums, int begin, int end)
	{
		int length = end - begin;
		
		//terminate situation
		if(length<1)
			return null;
		
		/*
		 * Real work:
		 * 
		 * Preorder
		 * 1. find the middle element to construct the current subroot
		 * 2. add the left/right subtree which will recursively be constructed
		 *    to the step1 geneated subroot
		 */
		int mid = begin + length/2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = recursivelyConvert(nums, begin, mid);
		root.right = recursivelyConvert(nums, mid+1, end);
		
		return root;
	}
}
