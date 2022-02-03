// This is O(N) time and space complexity, we can do better with not using additional space
// Othersolution is not using space
class Node {
  constructor(value, next=null){
    this.value = value;
    this.next = next;
  }
}

const find_cycle_start = function(head){
  let slow = head;
  let fast = head;
  const visited = new Set;
  visited.add(head);
  while(fast !== null && fast.next !== null) {
    fast = fast.next.next;
    slow = slow.next;
    if (visited.has(slow)) { 
      return slow; 
    } else {
      visited.add(slow);
    }
  }
  return 'head';
};


head = new Node(1)
head.next = new Node(2)
head.next.next = new Node(3)
head.next.next.next = new Node(4)
head.next.next.next.next = new Node(5)
head.next.next.next.next.next = new Node(6)

head.next.next.next.next.next.next = head.next.next
console.log(`LinkedList cycle start: ${find_cycle_start(head).value}`)

head.next.next.next.next.next.next = head.next.next.next
console.log(`LinkedList cycle start: ${find_cycle_start(head).value}`)

head.next.next.next.next.next.next = head
console.log(`LinkedList cycle start: ${find_cycle_start(head).value}`)
