/*

Palindrome Linked List

Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

 

Example 1:


Input: head = [1,2,2,1]
Output: true
Example 2:


Input: head = [1,2]
Output: false
 

Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9
 

Follow up: Could you do it in O(n) time and O(1) space?
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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;

        //Find middle (first middle in case of even no elements)
        ListNode fast = head, slow = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //Reverse the second half based on our slow pointer location now and get the newHead returned back

        ListNode newHead = reverseL(slow.next);

        //Compare the both halves based on head and newHead without interfering with them

        ListNode first = head , second = newHead;

        while(second != null){
            if(first.val != second.val){
                reverseL(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverseL(newHead);
        return true;
        

    }

    private static ListNode reverseL(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode newHead = reverseL(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

}

//Time complexity : O(2N)
//SPace complexity : O(1)
