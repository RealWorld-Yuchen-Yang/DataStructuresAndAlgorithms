package main.binarytree;

/**
 * Find the max depth of the given BT
 * @author yuchenyang
 *
 */
public class MaximumDepthOfBinaryTree {
	public static int maxDepth(TreeNode root)
	{
		if(root == null)
			return 0;
		return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
	}
}
