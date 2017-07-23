package main.linearlist;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * Note:
 *  just for information's sake
 *  you can not resize an array,  you can only create a new array and copy over a subsection of the previous value
 *  you can shrink an ArrayList,
 *   syntax: arrayList.subList(startIndex, endIndex).clear()
 *
 * @author yuchenyang
 *
 */
public class RemoveElement
{
	//time complexity O(n), Space complexity O(1)
	public static int removeElement(int[] nums, int target)
	{
		int index = 0;
		for(int i=0; i<nums.length; i++)
		{
			/*
			 * indexPointer moves slower than iPointer,
			 * it stores values do not equal to target
			 */
			 if (nums[i] != target) {
				 	nums[index++]=nums[i];
				}
		}
		return index;
	}
}
