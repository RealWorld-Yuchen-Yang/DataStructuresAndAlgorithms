package main.sorting.quicksort;

/**
 * Given an array with n objects colored red, white or blue, sort them so that
 * objects of the same color are adjacent. 
 * 
 * Here we will use the integer 0, 1, 2 to represent RED, WHITE, BLUE
 * Use an one-pass algorithm with constant space
 * 
 * Analysis: 
 * since this problem intrinsically has three parts, 
 * the natural solution would be quick sort
 * 
 * The essence of quick sort(sort in ascending order) is to 
 * 	Step1: find a pivot, usually the median of a portion of the designated array
 *  Step2: start from one-side/two-side of the given array, 
 *  	   compare the first element in the subarray, 
 *  	   if it is less than the pivot, it swap with the pivot,
 *  	   and move the wall(representing the beginning of the subarray)
 *  	   one step further.
 *  step3: terminate situation: 	
 *  	for one-side approach, terminate when there is only one element in the subarray
 *  	for two-side approach, terminate when walls representing the two directions collide 
 *  Step3：
 * @author yuchenyang
 *
 */
public class SortColors
{	
	public static final int RED = 0;
	public static final int WHITE = 1;
	public static final int BLUE = 2;
	
	public static void sortColors(int[] colors) {
        partition(colors, partition(colors, 0, colors.length, RED),colors.length, WHITE);
    }
    private static int partition(int[] colors, int begin, int end, int color) {
        int pos = begin;

        /*
         * note, here begin and end are both moving
         */
        for (; begin != end; ++begin)
            if (color == colors[begin])
                swap(colors, begin,pos++);

        return pos;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
