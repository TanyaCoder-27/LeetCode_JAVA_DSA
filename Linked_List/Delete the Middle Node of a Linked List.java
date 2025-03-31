/*

Delete the Middle Node of a Linked List

You are given the head of a linked list. Delete the middle node, and return the head of the modified linked list.

The middle node of a linked list of size n is the ⌊n / 2⌋th node from the start using 0-based indexing, where ⌊x⌋ denotes the largest integer less than or equal to x.

For n = 1, 2, 3, 4, and 5, the middle nodes are 0, 1, 1, 2, and 2, respectively.
 

Example 1:


Input: head = [1,3,4,7,1,2,6]
Output: [1,3,4,1,2,6]
Explanation:
The above figure represents the given linked list. The indices of the nodes are written below.
Since n = 7, node 3 with value 7 is the middle node, which is marked in red.
We return the new list after removing this node. 
Example 2:


Input: head = [1,2,3,4]
Output: [1,2,4]
Explanation:
The above figure represents the given linked list.
For n = 4, node 2 with value 3 is the middle node, which is marked in red.
Example 3:


Input: head = [2,1]
Output: [2]
Explanation:
The above figure represents the given linked list.
For n = 2, node 1 with value 1 is the middle node, which is marked in red.
Node 0 with value 2 is the only node remaining after removing node 1.
 

Constraints:

The number of nodes in the list is in the range [1, 105].
1 <= Node.val <= 105
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) return null;

        ListNode fast = head, slow = head;

        fast = head.next.next;

        while(fast !=null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}

/*

Code Explanation:
This method removes the middle node from a singly linked list using the two-pointer technique. Here's how it works, step-by-step:

1. Edge Case Handling:
If the linked list is empty (head == null) or contains only one node (head.next == null), the middle node is the only node in the list.
In such cases, the result is an empty list, so the method returns null.

2. Initialize Pointers:
Two pointers are initialized at the head of the list:

fast: Moves two steps at a time.

slow: Moves one step at a time.

These pointers help identify the middle node.
The fast pointer is advanced two steps ahead of the slow pointer at the start.
This is done to maintain the correct logic when traversing the list.

3. Traverse the List:
The while loop ensures both pointers move through the list simultaneously:

The fast pointer moves two steps at a time (fast = fast.next.next), reaching the end of the list faster.

The slow pointer moves one step at a time (slow = slow.next), eventually stopping at the middle node.

The loop continues as long as the fast pointer and its next node exist (fast != null && fast.next != null).

4. Delete the Middle Node:
By the time the loop ends, the slow pointer is at the node just before the middle node (if the list has an even number of nodes, it stops at the "left middle").

The slow.next pointer (which points to the middle node) is adjusted to skip the middle node and connect directly to the node after it.

5. Return the Updated List:
The method returns the modified linked list, with the middle node removed.

Key Observations:
Two-pointer Technique:

The fast pointer moving twice as fast as the slow pointer ensures that the slow pointer reaches the middle node when the fast pointer reaches the end of the list.

Time Complexity:

The algorithm traverses the list once, so it runs in O(n) time.

Space Complexity:

The algorithm uses constant additional space, i.e., O(1).

*/
