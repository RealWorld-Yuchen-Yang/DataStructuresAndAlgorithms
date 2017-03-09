package mnt ain.linnearlist;nt

import java.util.HashMap;
import java.util.Map;

/**
 * Problem:
 * Given an array of integers and an integer k, 
 * find out whether there are two distinct indices i and j in the array
 * such that nums[i] = nums[j] and the difference between i and j is at most k
 * 
 * Analysis: 
 * 	we need to maintain an HashMap<Integer, Integer>, 
 *  whose key is the array element value, 
 *  and the value is corresponding element's index
 * 	if we find any key are the same, 
 *  we calculate their containing value's difference(which is the index gap)	
 *  if the gap > k, return false
 *  otherwise keep iterating
 *  
 * Conclusion: 
 * 	Use hashing to store elements of an array will make the searching time constant
 * 	Whether choose HashMap or HashSet depends on what we really care about
 * 	HashSet: we do not care about the original sequence, just the element values
 * 	HashMap: the original sequence(index) does matters
 * 
 * @author yuchenyang
 *
 */
public class ContainsDuplicateII
{
	public static boolean containsNearByDuplicate(int[] nums, int k)
	{
		final Map<Integer, Integer> map = new HashMap();
		int max = Integer.MIN_VALUE;
	
		for(int i=0; i<nums.length; i++)
		{
			if(map.containsKey(nums[i]))
			{
				final int preIndex = map.get(nums[i]);
				final int gap = i - preIndex;
				max = Math.max(max, gap);
			}
			map.put(nums[i], i);
		}
		return max<=k;
	}
}
