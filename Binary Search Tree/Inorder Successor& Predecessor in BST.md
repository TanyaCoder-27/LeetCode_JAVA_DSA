# Inorder Predecessor in Binary Search Tree (BST)

## Problem Description
Write a Java method to find the **inorder predecessor** of a given node in a Binary Search Tree (BST). The inorder predecessor of a node `p` is the largest node in the BST whose value is less than `p.val`. The method should use the properties of a BST to find the predecessor efficiently in `O(h)` time, where `h` is the height of the tree, without using additional space. 

If no predecessor exists (e.g., if the node is the smallest value in the tree), the method should return `null`. Implement the solution using an **iterative approach**, as outlined below.

---

## Function Signature
```java
public class Solution {
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        // Method implementation here
    }
}

```
/**
 * Definition of a TreeNode in a Binary Search Tree.
 */
class TreeNode {
    int val; // Value of the node
    TreeNode left; // Pointer to the left child
    TreeNode right; // Pointer to the right child

    // Constructor to create a node with a given value
    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class Solution {
    /**
     * Function to find the inorder predecessor of a given node in a BST.
     * @param root The root of the BST.
     * @param p The node for which the predecessor is to be found.
     * @return The inorder predecessor node or null if no predecessor exists.
     */
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        // Variable to track the predecessor during traversal
        TreeNode predecessor = null;

        // Traverse the tree starting from the root
        while (root != null) {
            if (root.val >= p.val) {
                // If the current node's value is greater than or equal to the given node's value,
                // move to the left subtree because smaller values lie there.
                root = root.left;
            } else {
                // If the current node's value is smaller than the given node's value,
                // it could potentially be the predecessor.
                predecessor = root;

                // Move to the right subtree to find a larger value closer to p.val.
                root = root.right;
            }
        }

        // Return the predecessor (or null if none found)
        return predecessor;
    }
}
```
=================================================================================================================

# Inorder Successor in Binary Search Tree (BST)

## Problem Description
Write a Java method to find the **inorder successor** of a given node in a Binary Search Tree (BST). The inorder successor of a node `p` is the smallest node in the BST whose value is greater than `p.val`. The method should use the properties of a BST to find the successor efficiently in `O(h)` time, where `h` is the height of the tree, without using additional space.

If no successor exists (e.g., if the node is the largest value in the tree), the method should return `null`. Implement the solution using an **iterative approach**, as outlined below.

---

## Function Signature
```java
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // Method implementation here
    }
}

```
/**
 * Definition for a binary tree node in a Binary Search Tree.
 */
class TreeNode {
    int val; // Value of the node
    TreeNode left; // Pointer to the left child
    TreeNode right; // Pointer to the right child

    // Constructor to initialize a TreeNode with a value
    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class Solution {
    /**
     * This function finds the inorder successor of a given node in a BST.
     * @param root The root of the BST.
     * @param p The target node whose inorder successor we want to find.
     * @return The inorder successor node or null if no successor exists.
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null; // Variable to track the successor node

        // Traverse the BST
        while (root != null) {
            if (root.val <= p.val) {
                // If the current node's value is less than or equal to p.val:
                // Move to the right subtree, because larger values lie there.
                root = root.right;
            } else {
                // If the current node's value is greater than p.val:
                // Mark the current node as a potential successor.
                successor = root;

                // Move to the left subtree to find a smaller value closer to p.val.
                root = root.left;
            }
        }

        // Return the successor (null if none was found)
        return successor;
    }
}

```
