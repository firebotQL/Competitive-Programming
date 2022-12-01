/**
 * // This is the ImmutableListNode's API interface.
 * // You should not implement it, or speculate about its implementation
 * class ImmutableListNode {
 *      printValue() {}
 *
 *      getNext(): ImmutableListNode {}
 * }
 */

function printLinkedListInReverse(head: ImmutableListNode) {
  if (head.getNext() == undefined) {
    head.printValue();
  } else {
    printLinkedListInReverse(head.getNext());
    head.printValue();
  }
}
