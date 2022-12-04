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

function mergeTwoLists(
  list1: ListNode | null,
  list2: ListNode | null
): ListNode | null {
  if (!list1) return list2;
  if (!list2) return list1;
  let head = undefined;
  let current = undefined;
  while (list1 && list2) {
    if (list1.val < list2.val) {
      if (!head) {
        head = list1;
        current = head;
      } else {
        current.next = list1;
        current = current.next;
      }
      list1 = list1.next;
    } else {
      if (!head) {
        head = list2;
        current = head;
      } else {
        current.next = list2;
        current = current.next;
      }
      list2 = list2.next;
    }
  }
  if (!list1) current.next = list2;
  else if (!list2) current.next = list1;
  return head;
}
