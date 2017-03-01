package main.sorting.mergesort;

/**
 * Given two sorted integer arrays A and B, 
 * merge B into a as one sorted array
 * 
 * Note: you may assume that A has enough space to hold additional element from B
 * 		The number of elements initialized in A and B are m and n respectively
 * 
 * @author yuchenyang
 *
 */
public class MergeTwoSortedArrays
{
	/**
	 * Merge arrayB into arrayA, starting from the end,
	 * since we know the total number of elements
	 * @param A
	 * @param m
	 * @param B
	 * @param n
	 */
	public static void merge(int[] A, int m, int[] B, int n)
	{
		int ia = m-1;
		int ib = n-1;
		int icur = m+n-1;
		while(ia>=0 && ib>=0)
		{
			A[icur--] = A[ia] >= B[ib]? A[ia--]: B[ib--];
		}
		while(ib >= 0)
		{
			A[icur--] = B[ib--];
		}
	}
}
