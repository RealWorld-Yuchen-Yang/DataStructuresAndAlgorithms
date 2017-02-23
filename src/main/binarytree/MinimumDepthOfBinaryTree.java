package main.binarytree;

/*
 * Given a binary tree, find its minimum depth
 * 
 * Analysis:
 * If a subRoot node has no brother, 
 * its depth can represents the minimum depth on that subpath
 * otherwise, we should keep on investigating the rest of the path
 */
public class MinimumDepthOfBinaryTree {
	public static int recursiveSolution(TreeNode root)
	{
		return recursiveSolution(root, false);
	}
	
	private static int recursiveSolution(TreeNode root, boolean hasBrother)
	{
		if(root == null) 
			return hasBrother? Integer.MAX_VALUE:0;
		return 1+ Math.min(recursiveSolution(root.left, root.right != null), recursiveSolution(root.right, root.left!=null));
	}
}
