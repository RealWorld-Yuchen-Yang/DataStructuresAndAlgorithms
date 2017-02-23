package main;

/**
 * Created by yucheny on 2/16/17.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal
{
    public Node root;//used to store the constructed BST's root

    /*
    construct the tree from two arrays,
    1st one is preorder traversal of the tree,
    2nd one is inorder traversal of the same tree
     */
    public void buildTree(int[] preorder, int[] inorder)
    {
        this.root =  buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private Node buildTree(int[] preorder, int preorderBegin, int preorderEnd, int[] inorder, int inorderBegin, int inorderEnd)
    {
        //traversed tree is empty
        if(preorderBegin == preorderEnd)
            return null;
        if(inorderBegin == inorderEnd)
            return null;

        Node root = new Node(preorder[preorderBegin]);//first element of the preorder traversed array should be the actual head of the BST, which is the middle value
        int inorderRootPos = find(inorder, inorderBegin, inorderEnd, preorder[preorderBegin]);//find the root position in the inorder traversed array

        int leftSize = inorderRootPos - inorderBegin;//from the inorder traversed array, determine the size of the leftChild of the original BST

        //recursively construct the leftChild and rightChild
        root.l = buildTree(
                preorder, preorderBegin+1, preorderBegin + leftSize + 1,//leftTree span in preorder array, +1 is because all leftTree index is shifted by 1 at the beginning
                inorder, inorderBegin, inorderBegin + leftSize);//leftTree span in inorder array

        root.r = buildTree(
                preorder, preorderBegin + leftSize + 1, preorderEnd,//rightTree span in preorder array
                inorder, inorderRootPos + 1, inorderEnd);//rightTree span in inorder array

        return root;
    }

    //return the index of value inside array[begin, end]
    private static int find(int[] array, int begin, int end, int value)
    {
        for(int i = begin; i<end; i++)
        {
            if(array[i] == value)
            {
                return i;
            }
        }

        return -1; //represents not found
    }

    public static class Node
    {
        Node l;
        Node r;
        int value;

        public Node(int value)
        {
            this(value, null, null);
        }

        public Node(int value, Node l, Node r)
        {
            this.value = value;
            this.l = l;
            this.r = r;
        }
    }

    public void inorderPrint()
    {
        if(isEmpty(root))
        {
            System.out.println("Empty tree, no inorder traversed result");
        }
        else
        {
            inorderPrint(root);
        }
    }

    private void inorderPrint(Node root)
    {
        if(root != null)
        {
            inorderPrint(root.l);
            System.out.print(root.value);
            inorderPrint(root.r);
        }
    }

    //not sure how to determine emptiness, implement as follows for now
    public boolean isEmpty(Node root)
    {

        if(root == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}
