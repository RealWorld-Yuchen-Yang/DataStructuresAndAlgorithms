package main.binarytree;

/**
 * Validate if a BST is valid
 * Analysis: 
 * 	From the definition of a BST
 * 	recursively,
 * 		nodes to the left of subRoot should be smaller than it
 * 		nodes to the right of subRoot should be greater than it
 * @author yuchenyang
 *
 */
public class ValidateBinarySearchTree {
	public static boolean isValidBST(TreeNode root)
	{
		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private static boolean isValidBST(TreeNode root, int lower, int upper)
	{
		//terminate condition
		if(root == null)
			return true;
		//real work: recursively test current level and it subtrees' validity
		return root.val > lower && root.val < upper
				&& isValidBST(root.left, lower, root.val)
				&& isValidBST(root.right, root.val, upper);
	}
}
