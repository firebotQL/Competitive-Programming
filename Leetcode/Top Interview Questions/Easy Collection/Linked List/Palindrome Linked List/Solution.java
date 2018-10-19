/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // O(n) time and O(1) space
    // Though list is modified
    // There should be other solution which doesn't touch the original list..
    public boolean isPalindrome(ListNode head) {
        ListNode slow = getMidNode(head);
        ListNode prev = null;
        while(slow != null) {
            ListNode tmp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = tmp;
        }
        while(head != prev && head != null && prev != null) {
            if (head.val != prev.val) return false;
            head = head.next;
            prev = prev.next;
        }
        return true;
    }

    public ListNode getMidNode(ListNode head) {
        int n = getSize(head) / 2;
        while(n-- != 0) {
            head = head.next;
        }
        return head;
    }

    public int getSize(ListNode head) {
        int size = 0;
        while(head != null) {
            head = head.next;
            size++;
        }
        return size;
    }
}
