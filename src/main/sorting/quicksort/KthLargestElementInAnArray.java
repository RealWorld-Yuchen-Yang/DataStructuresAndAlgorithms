package main.sorting.quicksort;

import test.utils.YuchenPrinter;

/**
 * Find the k-th largest element in an unsorted array
 * For example, given [3,2,1,5,6,4] and k = 2, return 5
 * 
 * Note you may assume k is always valid, 1 <= k <= array.length
 * 
 * Analysis: 
 * 	best solution is to use quick sort,
 *  because we do not care the whole sequence of the array
 *  jut the k-th element
 * 	time complexity: O(n)
 * 	space complexity: O(1)
 * 
 * 	step1: randomly select an element from the given array as the pivot x. 
 *  step2: conceptually separate the array into two parts: sa and sb
 *  	   for each iteration, 
 *  	   
 *  	   sa: stores elements < x
 *  	   sb: stores elements > x
 *  		
 *  	   after one iteration's swapping, 
 *  	   if sa.length < k, then recursively find the sb[k-sa.length]
 *  	   if sa.length >= k, then recursively find the sa[k]
 * @author yuchenyang
 *
 */
public class KthLargestElementInAnArray {
 public static int findKthLargest(int[] nums, int k) {
     quickSort(nums, 0, nums.length - 1);
     return nums[nums.length - k];
 }
 private static int findKthLargest(int[] nums, int begin, int end, int k) {
     if (begin + 1 == end && k == 1) return nums[0];

     final int pos = partition(nums, begin, end - 1);
     final int len = pos - begin;

     if (len == k) {
         return nums[pos-1];
     } else if (len < k) {
         return findKthLargest(nums, pos, end, k - len);
     } else {
         return findKthLargest(nums, begin, pos, k);
     }
 }
 private static void quickSort(int[] nums, int left, int right) {
     if (left < right) {
         final int pos = partition(nums, left, right);
         quickSort(nums, left, pos - 1);
         quickSort(nums, pos + 1, right);
     }
 }
 private static int partition(int[] nums, int i, int j) {
     final int pivot = nums[i];//randomly choose a pivot
     while (i < j) {
         while (i < j && nums[j] >= pivot) --j;
         nums[i] = nums[j];
         while(i < j && nums[i] <= pivot) ++i;
         nums[j] = nums[i];
     }
     nums[i] = pivot;
     return i;
 }
}
