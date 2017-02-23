package main.binarytree;

/**
 * Given two nodes in a BST, find their lowest common ancestor(LCA)
 * 
 * Analysis: 
 * There are four cases
 * (	
 * 	while actually when dealing with BST, I should always think in this way
 * 	devide the tree by a subRoot, to three parts: 
 * 	leftSubTree, subRoot, rightSubTree
 * )
 * case1: two nodes are on a same leftSubTree->recursively find their LCA on the leftSubTree
 * case2: two nodes are on a same rightSubTree->recursively find their LCA on the rightSubTree
 * case3: one is on a leftSubTree, the other is on a rightSubTree->current node is the subRoot
 * case4: one of them is a subRootNode->current node is the subRoot
 * @author yuchenyang
 *
 */
public class LCAofBST {
	public static TreeNode find(TreeNode root, TreeNode p, TreeNode q)
	{
		if(root == null)
			return null;
		if(Math.max(p.val, q.val)<root.val)
		{
			//case1: p&q are on the same leftSubTree
			return find(root.left, p, q);
		}
		else if(Math.min(p.val, q.val)>root.val)
		{
			//case2: p&q are on the same rightSubTree
			return find(root.right, p, q);
		}
		else
		{
			/*
			 * case3: p&q are on leftSubTree and rightSubTree
			 * 	or
			 * case4: one of p, q is the root 
			 */
			return root;
		}
	}
}
