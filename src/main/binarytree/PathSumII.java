package main.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum,
 * find all root-to-leaf paths 
 * where each paths's sum equals the given sum.
 * @author yuchenyang
 *
 */
public class PathSumII {
	public static List<List<Integer>> pathSum(TreeNode root, int sum)
	{
		List<List<Integer>> result = new ArrayList();//list of all possible paths
		ArrayList<Integer> cur = new ArrayList();//one potential path being constructed at the moment
		pathSum(root, sum, cur, result);
		return result;
	}
	
	private static void pathSum(TreeNode root, int gap, ArrayList<Integer> cur, List<List<Integer>> result)
	{
		if(root == null) 
			return;
		//add the node being examined to the current path
		cur.add(root.val);
		if(root.left == null && root.right == null)
		{
			if(gap == root.val)
			{	
				//reached the end of a path, and pathSum equals given sum
				result.add(cur);
			}
		}
		
		//examine the left and right subPath respectively
		pathSum(root.left, gap - root.val, cur, result);
		pathSum(root.right, gap - root.val, cur, result);
		
		/*
		 * remove the last added element, 
		 * for it can represent he value of the leaf
		 * which will be examined in the next round 
		 * when root.left and root.right are null
		 */
		cur.remove(cur.size()-1);
	}
}
