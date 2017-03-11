package main.linearlist;

/**
 * Problem: 
 * Given an array of n integers where n>1, nums, 
 * return an array output such that output[i] is equal to the product of
 * all the elements of nums except nums[i]
 * Solve it without division and in O(n) and with constant space complexity
 * 
 * Note: the output array does not count as extra space for the purpose of space complexity
 * 
 * For example, given [1,2,3,4], return [24,12,8,6]
 * 
 * Analysis: 
 * Assuming we have nums=[a1,a2,a3,a4], 
 * we can construct two helper arrays, 
 * one stores the products of the current element's left elements' product
 * one store the products of the current element's right elements product
 * So that our final result--product of all other elements can be calculated 
 * by multiply the leftElementsProduct*rightElementsProduct.
 * 
 * solution for the so-called constant space complexity is meaningless
 * from my opinion, since it take the advantage of not counting the "return array space complexity"
 * 
 * @author yuchenyang
 *
 */
public class ProductOfArrayExceptSelf
{
	//two helper array solution(time complexity(O(n)), space complexity(O(n))
	public static int[] twoHelperArriesSolution(int[] nums)
	{
		final int length = nums.length;
		final int[] result = new int[length - 1];
		final int[] leftElementsProduct = new int[length - 1];
		final int[] rightElementsProduct = new int[length - 1];

		leftElementsProduct[0] = 1;
		rightElementsProduct[length-1]=1;
		
		//initialize leftElementsProduct array
		for(int i=1; i<length; i++)
		{
			leftElementsProduct[i] = nums[i-1]*leftElementsProduct[i-1];
		}
		
		//initialize rightElementsProduct array
		for(int i=length-2; i>=0; i--)
		{
			rightElementsProduct[i] = rightElementsProduct[i+1]+rightElementsProduct[i+1];
		}
		
		//multiply the left&rightElementProducts
		for(int i=0; i<length; i++)
		{
			result[i] = leftElementsProduct[i]*rightElementsProduct[i];
		}
		
		return result;
	}
	
	
}
