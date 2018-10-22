/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    // The idea of this solution that faster moving
    // pointer is going to overlap slowrunning if there
    // is a cycle
    // O(n) - runtime and O(1) space complexity
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(slow != null) {
            slow = slow.next;
            fast = fast != null && fast.next != null ? fast.next.next : null;
            if (slow != null && slow == fast) return true;
        }
        return false;
    }
}
