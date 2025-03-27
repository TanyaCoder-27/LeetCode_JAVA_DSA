/*
Lowest Common Ancestor of a Binary Search Tree

Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

 

Example 1:


Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.
Example 2:


Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
Example 3:

Input: root = [2,1], p = 2, q = 1
Output: 2
 

Constraints:

The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the BST.

*/

/**
 * Definition for a binary tree node.
 * A class representing a single node in a binary tree.
 */
public class TreeNode {
    int val;          // The value of the node
    TreeNode left;    // Pointer to the left child node
    TreeNode right;   // Pointer to the right child node

    // Constructor to initialize the node with a value
    TreeNode(int x) { 
        val = x; 
    }
}

/**
 * Solution class for finding the lowest common ancestor in a Binary Search Tree (BST).
 */
class Solution {
    /**
     * Finds the lowest common ancestor (LCA) of two nodes in a BST.
     *
     * @param root The root node of the BST.
     * @param p The first target node.
     * @param q The second target node.
     * @return The LCA node of p and q.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case: If the root is null, there's no ancestor.
        if (root == null) return null;

        // If both p and q are smaller than root, the LCA must be in the left subtree.
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        // If both p and q are greater than root, the LCA must be in the right subtree.
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        // If neither of the above conditions is true, it means one of p or q is on
        // one side of the root and the other is on the opposite side (or one of them is the root itself).
        // Hence, the current root is their lowest common ancestor.
        return root;
    }
}
