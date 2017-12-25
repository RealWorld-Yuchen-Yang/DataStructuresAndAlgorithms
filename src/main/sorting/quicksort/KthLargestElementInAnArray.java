package main.sorting.quicksort;


/**
 * Find the k-th largest element in an unsorted array
 * For example, given [3,2,1,5,6,4] and k = 2, return 5
 * 
 * Note you may assume k is always valid, 1 <= k <= array.length
 * 
 * Analysis: 
 * 	best solution is to use quick sort,
 * 
 * 	step1: randomly select an element from the given array as the pivot x. 
 * 			(here we just arbitrarily choose the value at the end)
 *  step2: conceptually separate the array into two parts: left and right
 *  	   for each iteration, 
 *  	   
 *  	   left: stores elements < x
 *  	   right: stores elements > x
 * @author yuchenyang
 *
 */
public class KthLargestElementInAnArray {
 public static int findKthLargest(int[] nums, int k) {
     quickSort(nums, 0, nums.length - 1);
     return nums[nums.length - k];
 }

 private static void quickSort(int[] array, int left, int right)
 {
	 if(right<=left)
	 {
		 return;
	 }
	 else
	 {
		 int pivot = array[right];//arbitrarily choose the element in the end as a pivot
		 int pivotLocation = partitionArray(array, left, right, pivot);
		 quickSort(array, left, pivotLocation-1);//Sorts the left side
		 quickSort(array, pivotLocation+1, right);//Sorts the right side
	 }
 }
 
 /**
  * 
  * @param array
  * @param left, left "index"
  * @param right, right "index"
  * @param pivot, pivot "value"
  * @return pivot "index"
  */
 private static int partitionArray(int[] array, int left, int right, int pivot)
 {
	 int leftPointer = -1;
	 int rightPointer = right;
	 while(true)
	 {
		 while(array[++leftPointer]<pivot);
		 while(rightPointer>0&&array[--rightPointer]>pivot);
		 if(leftPointer >= rightPointer)
		 {
			 break;
		 }
		 else
		 {
			 swap(array, leftPointer, rightPointer);
		 }
	 }
	 /*
	  * Note!! here we are swapping the leftPoitner with the right
	  * (which is the arbitrary pivot index)
	  * We are doing this because,
	  * we would always want to 
	  */
	 System.out.println(pivot);
	 swap(array, leftPointer, right);//restore the pivotValue to its position

	 return leftPointer;
 }
 
 private static void swap(int[] array, int indexA, int indexB)
 {
	 int temp = array[indexA];
	 array[indexA] = array[indexB];
	 array[indexB] = temp;
 }
 
}
