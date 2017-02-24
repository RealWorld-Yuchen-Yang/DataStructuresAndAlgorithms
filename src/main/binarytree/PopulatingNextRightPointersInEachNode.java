package main.binarytree;

/**
 * Populate each next pointer to point to its next right node.
 * If there is no right node, the next pointer should be null
 * Initially, all next pointers are set to null
 * 
 * Note: 
 * 	You may only use constant extra space
 * 	You may assume that it is a perfect binary tree
 * 	(ie, all leaves are at the same level, and every parent has two children)
 * 
 * @author yuchenyang
 *
 */
public class PopulatingNextRightPointersInEachNode {
	private static class TreeLinkNode
	{
		int val;
		TreeLinkNode left;
		TreeLinkNode right;
		TreeLinkNode next;
		
		public TreeLinkNode(int val) 
		{
			this.val = val;
		}
	}
	
	public static void connect(TreeLinkNode root)
	{
		connect(root, null);
	}
	
	/**
	 * 
	 * @param root
	 * @param sibling, here declare sibling is because
	 * 					we know each parent has two children
	 */
	private static void connect(TreeLinkNode root, TreeLinkNode sibling)
	{
		if(root == null)
		{
			return;
		}
		else
		{
			//real work of root level
			root.next = sibling;
		}
		
		//real work of next level, e.g. left & right child level
		//this is connection of the same root's children
		connect(root.left, root.right);
		//this is connection of to adjacent children of two sibling nodes
		if(sibling != null)
		{
			connect(root.right, sibling.left);
		}
		else
		{
			connect(root.right, null);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
