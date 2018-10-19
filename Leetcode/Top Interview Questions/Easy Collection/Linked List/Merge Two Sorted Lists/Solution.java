/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // O(n + m) runtime and O(n + m) space complexity where
    // n - first list size and m - second list size
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = new ListNode(-1);
        ListNode prev = head;
        while(l1 != null || l2 != null) {
            ListNode current;
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    current = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    current = new ListNode(l2.val);
                    l2 = l2.next;
                }
            } else if (l2 != null) {
                current = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                current = new ListNode(l1.val);
                l1 = l1.next;
            }
            prev.next = current;
            prev = current;
        }
        return head.next;
    }
}
