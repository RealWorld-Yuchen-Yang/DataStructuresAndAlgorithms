package main.binarytree;

/**
 * Problem:
 * Given a binary tree containing digits from 0~9 only, 
 * each root-to-leaf path could represent a number, 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123
 * 
 * 
 * Analysis: 
 * 	this question should be more properly called 
 * 	concatenate root-to-leaf literal numbers
 * 	This problem is simple, just shift 10 for the parent node, 
 * 	then plus the child node 
 * @author yuchenyang
 *
 */
public class SumRootToLeafNumbers {
	public static int sumNumbers(TreeNode root)
	{
		return dfs(root, 0);
	}
	
	private static int dfs(TreeNode root, int sum)
	{
		if(root == null)
		{
			return 0;
		}
		if(root.left == null && root.right == null)
		{
			return sum*10+root.val;
		}
		
		return dfs(root.left, sum*10 + root.val) +
				dfs(root.right, sum*10 + root.val);
	}
	
}
