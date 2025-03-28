/*
Construct Binary Search Tree from Preorder Traversal

Given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree), construct the tree and return its root.

It is guaranteed that there is always possible to find a binary search tree with the given requirements for the given test cases.

A binary search tree is a binary tree where for every node, any descendant of Node.left has a value strictly less than Node.val, and any descendant of Node.right has a value strictly greater than Node.val.

A preorder traversal of a binary tree displays the value of the node first, then traverses Node.left, then traverses Node.right.

 

Example 1:


Input: preorder = [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]
Example 2:

Input: preorder = [1,3]
Output: [1,null,3]
 

Constraints:

1 <= preorder.length <= 100
1 <= preorder[i] <= 1000
All the values of preorder are unique.
*/

/**
 * Definition for a binary tree node.
 * Each TreeNode has a value and left and right child pointers.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    // Default constructor
    TreeNode() {}

    // Constructor to create a node with a given value
    TreeNode(int val) {
        this.val = val;
    }

    // Constructor to create a node with a value and children
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    /**
     * Main method to construct the BST from preorder traversal.
     * It uses a helper method with additional parameters.
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        // Call the helper method with:
        // preorder: the input array,
        // Integer.MAX_VALUE: the initial upper limit,
        // new int[]{0}: a single-element array to keep track of the current index.
        return bstFromPreorder(preorder, Integer.MAX_VALUE, new int[]{0});
    }

    /**
     * Helper method to construct the BST recursively.
     * @param pre The preorder traversal array.
     * @param max The maximum allowed value for the current node.
     * @param i   A single-element array to track the current index in the preorder array.
     * @return The root of the constructed subtree.
     */
    static TreeNode bstFromPreorder(int[] pre, int max, int[] i) {
        // Base case: If we've processed all elements or the current value exceeds max.
        if (i[0] == pre.length || pre[i[0]] > max) {
            return null;
        }

        // Create the current node using the value at index i[0].
        TreeNode node = new TreeNode(pre[i[0]++]);

        // Recursively construct the left subtree.
        // The max value for the left subtree is the value of the current node.
        node.left = bstFromPreorder(pre, node.val, i);

        // Recursively construct the right subtree.
        // The max value for the right subtree remains unchanged.
        node.right = bstFromPreorder(pre, max, i);

        return node;
    }
}
