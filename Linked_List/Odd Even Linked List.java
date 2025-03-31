/*
Odd Even Linked List

Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

The first node is considered odd, and the second node is even, and so on.

Note that the relative order inside both the even and odd groups should remain as it was in the input.

You must solve the problem in O(1) extra space complexity and O(n) time complexity.

 

Example 1:


Input: head = [1,2,3,4,5]
Output: [1,3,5,2,4]
Example 2:


Input: head = [2,1,3,5,6,4,7]
Output: [2,3,6,7,1,5,4]
 

Constraints:

The number of nodes in the linked list is in the range [0, 104].
-106 <= Node.val <= 106

*/

class Solution {
    public ListNode oddEvenList(ListNode head) {
        // Step 1: Handle edge cases where the list is empty or has only one node
        if (head == null || head.next == null) {
            return head; // No rearrangement needed
        }

        // Step 2: Initialize pointers
        ListNode odd = head;          // Pointer to track the odd-indexed nodes
        ListNode even = head.next;    // Pointer to track the even-indexed nodes
        ListNode evenHead = even;     // Store the head of the even-indexed nodes to reconnect later

        // Step 3: Rearrange the list
        while (even != null && even.next != null) { // Continue as long as there are more nodes
            odd.next = odd.next.next;  // Connect the current odd node to the next odd node
            even.next = even.next.next; // Connect the current even node to the next even node
            odd = odd.next;            // Move the odd pointer to the next odd node
            even = even.next;          // Move the even pointer to the next even node
        }

        // Step 4: Connect the odd list to the even list
        odd.next = evenHead;

        // Step 5: Return the head of the rearranged list
        return head;
    }
}

/*
Note:
The reason we use odd = odd.next; and even = even.next; instead of odd = odd.next.next; and even = even.next.next; in the loop is 
because we've already updated the next pointers in the lines just before.
*/
