package main.binarytree;

/**
 * Given a binary tree, find the maximum path sum
 * The path may start and end at any node in the tree.
 * 
 * Analysis: 
 * 	we can use DFS, 
 * 	if leftSubTree's sum >0, then it it benificial to the total sum
 * 	so as the rightSubTree's sum
 * 	then we can add their sum to the whole sum
 * @author yuchenyang
 *
 */
public class BinaryTreeMaximumPathSum {
	
	private static int max_sum;
	public static int maxPathSum(TreeNode root)
	{
		max_sum = Integer.MIN_VALUE;
		dfs(root);
		return max_sum;
	}
	
	/**
	 * this method does two things
	 * 1. return the maxSum of the subPath, 
	 *    either the root.val itself,
	 *    or root.val + its indeterminated subTreeSum
	 * 
	 * 2. Refresh the max_sum of the whole tree
	 * 	
	 * @param root
	 * @return
	 */
	private static int dfs(TreeNode root)
	{
		if(root == null)
			return 0;//means no contribution to the total sum
		int l = dfs(root.left);//sub total of left tree
		int r = dfs(root.right);//sub total of right tree
		int sum = root.val;
		if(l>0)
			sum+=l;
		if(r>0)
			sum+=r;
		
		//return the maximum sum of the current subTree
		return Math.max(r, l) >0 ? Math.max(r, l) + root.val:root.val;
		
	}
}
