package main.binarytree;

/**
 * a binary tree is balanced if and only if 
 * nodes inside the tree's left and right subtrees' height difference is no more than 1
 * 
 * @author yuchenyang
 *
 */
public class BalancedBinaryTree {
	public static boolean isBalanced(TreeNode root)
	{
		return balancedHeight(root) >=0;
	}
	
	/*
	 * this should be a post order traversal,
	 *  since node's height depend on its left and right subtrees
	 */
	private static int balancedHeight(TreeNode root)
	{
		if(root == null)
			return 0;
		
		int left = balancedHeight(root.left);
		int right = balancedHeight(root.right);
		
		//real work of balancedHeight()
		if(left<0 || right<0 || Math.abs(left - right) > 1)
			return -1;//actually it can be any negative value, which represents failure.
		
		return Math.max(left, right)+1;//height of the node = max subtree height + 1
	}
}
