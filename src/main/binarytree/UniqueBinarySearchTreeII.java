package main.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given 1...n, generate all the possible binary trees
 * @author yuchenyang
 *
 */
public class UniqueBinarySearchTreeII {
	public static List<TreeNode> generateTrees(int n)
	{
		if(n == 0)
			return new ArrayList();
		return generate(1, n);
	}
	
	/**
	 * 
	 * @param start, starting point of the element array
	 * @param end, end point of the element array
	 * @return
	 */
	private static List<TreeNode> generate(int start, int end)
	{
		/*
		 * subTree stores roots of
		 * all the generated possibilities of the binary trees 
		 */
		List<TreeNode> subTree = new ArrayList();
		if(start>end)
		{
			subTree.add(null);
			return subTree;
		}
		
		for(int k = start; k<=end; k++)
		{
			/*
			 * k:
			 * 	represents the separation point of the array,
			 * 	which will be stored in the generated BST's root
			 */
			List<TreeNode> leftSubs = generate(start, k-1);
			List<TreeNode> rightSubs = generate(k+1, end);
			
			/*
			 * real work: 
			 * 	adding the recursively constructed left/right subtrees
			 * 	to the separator node k
			 */
			for(TreeNode i: leftSubs)
			{
				for(TreeNode j: rightSubs)
				{
					/*
					 * when using two loops to generate [i,j] combination
					 * It does not matter who is in the outer loop
					 * who is in the inner loop
					 */
					TreeNode node =new TreeNode(k);
					node.left = i;
					node.right = j;
					subTree.add(node);
				}
			}
		}
		return subTree;
	}
}
