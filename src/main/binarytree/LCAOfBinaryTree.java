package main.binarytree;

/**
 * Analysis: 
 * 	use the bottom-up approach
 * 	assuming we are at a subRoot node
 * 	if we can find node p and in subRoot's left and right subTree respectively, root is the LCA
 *  if they are not in the leftSubTree, p and q are in rightSubTree
 *  vise versa
 * @author yuchenyang
 *
 */
public class LCAOfBinaryTree {
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
	{
		//if root is null or found p or q, return root itself
		if(root == null || root.val == p.val || root.val == q.val)
			return root;
		//find p or q in the left subtree
		final TreeNode left = lowestCommonAncestor(root.left, p, q);
		//find p or q in the right subtree
		final TreeNode right = lowestCommonAncestor(root.right, p, q);
		
		if(left != null && right != null)
		{
			return root;
		}
		else
		{
			return left == null? right: left;
		}
		
	}
}
