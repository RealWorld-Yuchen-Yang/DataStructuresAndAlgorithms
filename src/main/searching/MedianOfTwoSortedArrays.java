package main.searching;

/**
 * Problem: There are two sorted arrays A and B of size m and n respectively. 
 * Find the median of the two sorted arrays. 
 * The overall run time complexity should be O(log (m+n)).
 * 
 * Analysis:
 * Even though the naive approah is to merge sort these two arries
 * The time complexity is O(m+n)
 * The problem only requires a median(middle number) of the two arries, 
 * which is similar to find the k-th element in the two arries. 
 * If we fully utilize the sorted characteristics of two arries: 
 * we can come up with an approach similar to binary search:
 * 
 * Assuming #elements in A and B are both greater than k, 
 * We compare A's (k/2)-th element (which is A[k/2-1])
 * with B's (k/2)-th element(which is B[k/2-1])
 * 
 * if A[k/2-1] == B[k/2-1], together there are k elements, terminate
 * if A[k/2-1] > B[k/2-1], set B's lowerBound to (k/2-1)
 * if A[k/2-1] < B[k/2-1], set A's lowerBound to (k/2-1)
 * 
 * Terminating condition also contains:
 * A.length == 0 || B.length == 0, we return B[k-1] or A[k-1]
 * when k=1, return min(A[0], B[0])
 * 	 
 * @author yuchenyang
 *
 */
public class MedianOfTwoSortedArrays
{
	public static double findMedianSortedArrays(final int[] A,final int[] B)
	{
		int total = A.length + B.length;
		if(total % 2 == 1)
		{
			//if total is odd elements
			return findKth(A, 0, B, 0, total/2+1);
		}
		else
		{
			//if total is even elements
			return (findKth(A, 0, B, 0, total/2) + findKth(A, 0, B, 0, total/2+1))/2.0;
		}
	}
	
	/**
	 * 
	 * @param A
	 * @param ai, lowerBound index of Array A
	 * @param B
	 * @param bi, lowerBound index of Array B
	 * @param k
	 * @return
	 */
	private static int findKth(final int[] A, int ai, final int[] B, int bi, int k)
	{
		/*
		 * always assume that A is shorter than B
		 *  (the assumption is based on the following conditional conversion)
		 */
		if(A.length -ai > B.length - bi)
		{
			/*
			 * if array A is longer than B, we switch their position
			 * so that beyond this point, A is always shorter than B
			 */
			return findKth(B, bi, A, ai, k);
		}
		
		if(A.length - ai == 0)
		{
			return B[bi+k-1];
		}
		if (k == 1)
		{
			return Math.min(A[ai], B[bi]);
		}
		
		//divide k into two parts
		int k1 = Math.min(k/2, A.length-ai);
		int k2 = k - k1;
		
		if(A[ai+k1-1]<B[bi+k2-1])
		{
			/*
			 * if A's k1-th element < B's k2-th element, 
			 * move A's lowerBound index k1 step further
			 */
			return findKth(A, ai + k1, B, bi, k-k1);
		}
		else if(A[ai+k1-1]>B[bi+k2-1])
		{
			/*Similar
			 * if A's k1-th element > B's k2-th element, 
			 * move B's lowerBound index k2 step further
			 */
			return findKth(A, ai, B, bi+k2, k-k2);
		}
		else
		{
			/*
			 * if A[ai+k1-1] == B[bi+k2-1]
			 * it does not matter which one to return
			 */
			return A[k1-1];
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
