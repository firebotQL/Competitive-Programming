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

function middleNode(head: ListNode | null): ListNode | null {
  let tmpHead = head;
  let i = 0;
  while (tmpHead !== null) {
    i++;
    tmpHead = tmpHead.next;
  }
  const upTo = i / 2 - (i % 2);
  for (let j = 0; j < upTo; j++) {
    head = head.next;
  }
  return head;
}
