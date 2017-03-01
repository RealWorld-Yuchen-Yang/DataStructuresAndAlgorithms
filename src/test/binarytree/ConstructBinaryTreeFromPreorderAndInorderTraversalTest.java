package test;

import main.ConstructBinaryTreeFromPreorderAndInorderTraversal;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yucheny on 2/16/17.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversalTest
{

    @Test
    public void testBuildTree() throws Exception
    {
        int[] preorderRepresentation = {1,2,4,5,3,6,7};
        int[] inorderRepresentation = {4,2,5,1,6,3,7};

        ConstructBinaryTreeFromPreorderAndInorderTraversal constructBinaryTreeFromPreorderAndInorderTraversal = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        constructBinaryTreeFromPreorderAndInorderTraversal.buildTree(preorderRepresentation, inorderRepresentation);
        constructBinaryTreeFromPreorderAndInorderTraversal.inorderPrint();

    }
}