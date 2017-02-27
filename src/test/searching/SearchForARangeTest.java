package test.searching;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import main.searching.SearchForARange;

public class SearchForARangeTest
{
	@Test
	public void testFindingLowerUpperBound()
	{
		int[] inputArray = {5, 7, 7, 8, 8, 10};
		int inputTarget = 8;
		int[] expectedRange = {3,4};
		
		int[] resultRange = SearchForARange.binarySearchSolution(inputArray, inputTarget);
//		System.out.println(Arrays.toString(resultRange));
		Assert.assertArrayEquals(expectedRange, resultRange);
	}
}
