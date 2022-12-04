/**
 * Definition for singly-linked list.
 * class ListNode {
 *     val: number
 *     next: ListNode | null
 *     constructor(val?: number, next?: ListNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.next = (next===undefined ? null : next)
 *     }
 * }
 */

function reverseList(head: ListNode | null): ListNode | null {
  let current = null;
  let previous = null;
  while (head !== null) {
    current = head;
    head = head.next;
    current.next = previous;
    previous = current;
  }
  return previous;
}
