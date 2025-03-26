/*

Insert into a Binary Search Tree
  
You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.

 

Example 1:


Input: root = [4,2,7,1,3], val = 5
Output: [4,2,7,1,3,5]
Explanation: Another accepted tree is:

Example 2:

Input: root = [40,20,60,10,30,50,70], val = 25
Output: [40,20,60,10,30,50,70,null,null,25]
Example 3:

Input: root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
Output: [4,2,7,1,3,5]
 

Constraints:

The number of nodes in the tree will be in the range [0, 104].
-108 <= Node.val <= 108
All the values Node.val are unique.
-108 <= val <= 108
It's guaranteed that val does not exist in the original BST.
*/

class Solution {
    /**
     * Function to insert a value into a Binary Search Tree (BST).
     * 
     * The rules for a BST are:
     * - The left subtree of a node contains only nodes with values less than the node's value.
     * - The right subtree of a node contains only nodes with values greater than the node's value.
     * 
     * This function ensures that the BST structure is preserved after the insertion.
     * 
     * @param root - The root node of the BST.
     * @param val - The value to be inserted into the BST.
     * @return The root node of the BST after insertion.
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // Step 1: Create a new node with the given value.
        TreeNode newNode = new TreeNode(val);

        // Step 2: If the BST is empty (root is null), the new node becomes the root.
        if (root == null) {
            root = newNode;
            return root; // Return the updated tree.
        } 

        // Step 3: Use two pointers to find the correct position for the new value.
        TreeNode parent = null; // To store the parent of the current node.
        TreeNode curr = root; // Start with the root node.

        // Step 4: Traverse the BST to find the appropriate position for insertion.
        while (curr != null) {
            parent = curr; // Keep track of the parent node.

            if (val < curr.val) {
                // If the value is less than the current node, move to the left subtree.
                curr = curr.left;
            } else if (val > curr.val) {
                // If the value is greater than the current node, move to the right subtree.
                curr = curr.right;
            } else {
                // If the value already exists in the BST, do not insert it again.
                return root; // No changes to the tree.
            }
        }

        // Step 5: Insert the new node as a child of the parent node.
        if (val < parent.val) {
            // Attach the new node to the left of the parent.
            parent.left = newNode;
        } else {
            // Attach the new node to the right of the parent.
            parent.right = newNode;
        }

        // Step 6: Return the updated root of the BST.
        return root;
    }
}

