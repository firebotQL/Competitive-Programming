class Solution {
    // Idea is to have slow and fast moving pointer so
    // we iterate lists once
    // Runtime complexity is O(n)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int cnt = 0;
        ListNode slow = null;
        ListNode current = head;
        while(current != null) {
            if (cnt++ >= n) {
                slow = slow != null ? slow.next : head;
            }
            current = current.next;
        }
        if (slow == null) {
            return head.next;
        } else {
            slow.next = slow.next != null ? slow.next.next : null;
        }
        return head;
    }
}
