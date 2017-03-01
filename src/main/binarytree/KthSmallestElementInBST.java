package main.binarytree;

import java.util.Stack;

/**
 * Given a BST, find the kth smallest element
 * 
 * Analysis: 
 * 	inorder traversal
 * 	time complexity O(k)
 * @author yuchenyang
 *
 */
public class KthSmallestElementInBST {
	//iterative inorder traversal
	public static int kthSmallest(TreeNode root, int k)
	{
		Stack<TreeNode> s =new Stack();
		TreeNode p = root;
		
		while(!s.isEmpty() || p != null)
		{
			if(p != null)
			{
				/*
				 * push all the leftSubTrees of the root 
				 * into the stack for later use
				 */
				s.push(p);
				p = p.left;
			}
			else
			{
				p = s.pop();
				--k;
				if(k == 0)
				{
					return p.val;
				}
				p = p.right;
			}
		}
		return -1;//not found
	}
}
