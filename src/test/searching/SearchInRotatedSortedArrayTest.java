package test.searching;

import org.junit.Assert;
import org.junit.Test;

import main.searching.SearchInRotatedSortedArray;

public class SearchInRotatedSortedArrayTest
{
	@Test
	public void binarySearchInLeftMidRangeSolutionTest()
	{
		int[] inputArray = {4,5,6,7,0,1,2};
		int inputTarget = 2;
		int expectedIndex = 6;
		int resultIndex = SearchInRotatedSortedArray.binarySearchInLeftMidRangeSolution(inputArray, inputTarget);
		Assert.assertEquals(expectedIndex, resultIndex);
	}
}
