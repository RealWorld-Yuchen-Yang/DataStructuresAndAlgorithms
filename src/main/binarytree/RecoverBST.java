package main.binarytree;
/**
 * in Morris inorder traversal
 * pre(decessor) means  the current node's value-wised predecessor
 * which on the tree should be the immediate left child's right-most child
 * 
 * Requirement: Two elements of a BST are swapped by mistake
 * Recover the tree without changing its structure
 * 
 * Note: A solution using o(n) space is pretty straight forward. Could you devise a constant space solution?
 * 
 * Analysis:
 * 	Based on the characteristics of BST, we know that node.left<node<node.right
 * 	So our goal is to find such a node who violates this rule. 
 * 
 * 	1. Recursive inorder traversal's time complexity is o(n), but space complexity is o(logn),
 *  2. Morris inorder traversal's time complexity is also o(n), but space complexity is o(1)
 * @author yuchenyang
 *
 */
public class RecoverBST {
	public static void morriesInorderTraversalSolution(TreeNode root)
	{
		TreeNode[] broken = new TreeNode[2];//represents the two nodes who swapped position
		TreeNode prev = null;
		TreeNode cur = root;
		
		/*
		 * Starting from the root of this BST
		 */
		while(cur != null)
		{
			
			if(cur.left == null)
			{
				/*
				 * parsing the right side of the tree
				 * the misplaced node was found by prev, and is now stored in broken[0]
				 * we can move on to the immediate next node, which is the current node
				 */
				detect(broken, prev, cur);
				prev = cur;
				cur = cur.right;
			}
			else
			{
				//parsing the left side of the tree
				TreeNode node = cur.left;
				
				/*
				 * now we are pointing the node the current's leftChild's right-most child,
				 * which is the immediate predecessor of the "current"
				 */
				while(node.right != null && node.right != cur)
				{
					node = node.right;
				}
				
				if(node.right == null)
				{
					/*
					 * point the node's right to its value-wised immediate parent
					 * which is the subtree's root
					 * and after this redirection, the link loopback path is formed
					 */
					node.right = cur;
					//move the current node pointer one step left
					cur = cur.left;
				}
				else
				{
					/*
					 *The above "if block" has normalized the tree/subtree's left side situation
					 *into the "parsing of right side" situation 
					 */
					detect(broken, prev, cur);
					node.right = null;
					prev = cur;
					cur = cur.right;
				}
			}
		}

		/*
		 * after the above detection,
		 * the misplaces two nodes are stored in broken[0], broken[1]
		 * we do not need to touch the structure of the tree,
		 * just swap the misplaced value
		 */
		int tmp = broken[0].val;
		broken[0].val = broken[1].val;
		broken[1].val = tmp;
	}
	
	private static void detect(TreeNode[] broken, TreeNode prev, TreeNode current)
	{
		if(prev != null & prev.val > current.val)
		{
			if(broken[0] == null)
			{
				broken[0] = prev;//store the mispaced left node in broken[0]
			}
			broken[1] = current;//store the current pointer into broken[1]
		}
	}
	
	
	//compared with Morris inorder traversal solution
    private static TreeNode p1 = null;//p1 is broken[0]
    private static TreeNode p2 = null;//p2 is broken[1]
    private static TreeNode prev = null;
	public static void recursiveInorderTraversalSolution(TreeNode root)
	{
		/*
		 * recursively inorder traverse the tree
		 * and store the misplaced nodes in p1, p2
		 */
		inOrder(root);
		
		//swap the misplaced value, no need to change the structure of the tree
		int tmp = p1.val;
		p1.val = p2.val;
		p2.val = tmp;
	}
	
	private static void inOrder(TreeNode root)
	{
		if(root == null)
			return;
		//traverse the left subtree
		if(root.left != null)
			inOrder(root.left);
		
		/*
		 * this is real work that inOrder does:
		 * store the misplaced left side node in broken[0]
		 * store the current node inside broken[1]
		 */
		if(prev != null && root.val <prev.val)
		{
			if(p1 == null)
			{
				p1 = prev;
			}
			p2 = root;
		}
		
		prev = root;
		//traverse the left subtree
		if(root.right != null)
		{
			inOrder(root.right);
		}
			
	}
	
	
	
	
	
	
	
	
	
	
}
