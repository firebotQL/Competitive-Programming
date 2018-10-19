class Solution {
    // Iterative solution
    // O(n) runtime and O(1) space complexity
   /* public ListNode reverseList(ListNode head) {
        ListNode tmp = head;
        ListNode prev = null;
        ListNode current = head;
        while(current != null) {
            tmp = current.next;
            current.next = prev;
            prev = current;
            current = tmp;
        }
        return prev != null ? prev : head;
    }
    */
    
    // Recursive solution (uses call stack!)
    // O(n) runtime and O(n) call stack space complexity
    public ListNode reverseList(ListNode head) {
        return reverseList(null, head);
    }

    public ListNode reverseList(ListNode prev, ListNode current) {
        if (current == null) return prev;
        ListNode tmp = current.next;
        current.next = prev;
        return reverseList(current, tmp);
    }
}
