/*
Validate Binary Search Tree

Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:


Input: root = [2,1,3]
Output: true
Example 2:


Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1

*/

/**
 * Definition for a binary tree node.
 * A basic structure of a binary tree node.
 */
public class TreeNode {
    int val;          // Value of the node
    TreeNode left;    // Pointer to the left child node
    TreeNode right;   // Pointer to the right child node

    // Default constructor (no-argument constructor)
    TreeNode() {}

    // Constructor that initializes the node with a value
    TreeNode(int val) { 
        this.val = val; 
    }

    // Constructor that initializes the node with a value and its child nodes
    TreeNode(int val, TreeNode left, TreeNode right) { 
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * Main solution class for validating a Binary Search Tree (BST).
 */
class Solution {
    /**
     * Public method to validate if a given binary tree is a BST.
     *
     * @param root The root node of the binary tree.
     * @return true if the tree is a valid BST, false otherwise.
     */
    public boolean isValidBST(TreeNode root) {
        // Call the helper method with initial min and max values.
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * Helper method to validate the BST using the properties of a BST:
     * - The value of each node must lie within a specific range [min, max].
     * - The left child's value must be less than the current node's value.
     * - The right child's value must be greater than the current node's value.
     *
     * @param root The current node being checked.
     * @param min The minimum allowable value for the current node.
     * @param max The maximum allowable value for the current node.
     * @return true if the subtree rooted at this node is a BST, false otherwise.
     */
    static boolean isValidBST(TreeNode root, long min, long max) {
        // Base case: If the current node is null, it's a valid BST.
        if (root == null) return true;

        // If the current node's value violates the min/max constraint, return false.
        if (root.val >= max || root.val <= min) return false;

        // Recursively check the left and right subtrees.
        // - For the left subtree, the maximum value is the current node's value.
        // - For the right subtree, the minimum value is the current node's value.
        return isValidBST(root.left, min, root.val) && 
               isValidBST(root.right, root.val, max);
    }
}
