/*

Remove Nth Node From End of List

Given the head of a linked list, remove the nth node from the end of the list and return its head.

 

Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]
 

Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
 

Follow up: Could you do this in one pass?
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {} // Default constructor
 *     ListNode(int val) { this.val = val; } // Constructor to initialize a node with a value
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; } // Constructor with value and next node
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Step 1: Initialize two pointers, fast and slow, both pointing to the head
        ListNode fast = head, slow = head;

        // Step 2: Move the fast pointer 'n' steps ahead
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // Step 3: Check if fast reached the end (null), meaning we need to remove the first node
        if (fast == null) {
            return head.next; // Return the second node as the new head
        }

        // Step 4: Move both fast and slow pointers simultaneously until fast reaches the last node
        while (fast.next != null) {
            fast = fast.next; // Advance the fast pointer
            slow = slow.next; // Advance the slow pointer
        }

        // Step 5: Adjust the 'next' pointer of the slow pointer to skip the target node
        slow.next = slow.next.next; // The Nth node from the end is removed

        // Step 6: Return the head of the modified list
        return head;
    }
}

/*
Explanation of Key Steps:
Two-pointer Technique:

The fast pointer is moved n steps ahead of the slow pointer initially. This creates a gap of n nodes between the two pointers.

Once the fast pointer reaches the end of the list, the slow pointer will be at the node just before the target node (the Nth node from the end).

Special Case for Removing the First Node:

If fast becomes null after moving n steps ahead, it means the Nth node from the end is the head itself. In this case, head.next is returned as the new head of the list.

Adjusting Pointers:

The slow pointer’s next is updated to skip over the target node (slow.next = slow.next.next). This effectively removes the Nth node from the list.

Edge Cases:

The solution handles cases where the list has only one node, or when n equals the length of the list, ensuring no null pointer exceptions occur.

This implementation is efficient with O(n) time complexity, as the list is traversed only once, and O(1) space complexity, since no additional data structures are used.

*/
