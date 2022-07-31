class Node {
  constructor(value, next = null) {
    this.value = value;
    this.next = next;
  }

  get_list() {
    let result = "";
    let temp = this;
    while (temp !== null) {
      result += temp.value + " ";
      temp = temp.next;
    }
    return result;
  }
}

const rotate = function (head, rotations) {
  if (rotations < 1 || head == null) return head;

  let current = head;
  let previous = null;
  let end = null;
  let newHead = null;
  let previousEnd = null;

  while (rotations > -1) {
    if (rotations-- === 0) {
      previousEnd = previous;
      newHead = current;
    }
    previous = current;
    current = current.next;
    if (current == null) {
      rotations -= 1; // including null!
      if (end == null) end = previous;
      current = head;
    }
  }

  while (current !== null && end == null) {
    previous = current;
    current = current.next;
  }

  if (end == null) end = previous;

  if (newHead == head) return head;

  end.next = head;
  previousEnd.next = null;

  return newHead;
};

head = new Node(1);
head.next = new Node(2);
head.next.next = new Node(3);
head.next.next.next = new Node(4);
head.next.next.next.next = new Node(5);
head.next.next.next.next.next = new Node(6);

console.log(`Nodes of original LinkedList are: ${head.get_list()}`);
console.log(`Nodes of rotated LinkedList are: ${rotate(head, 3).get_list()}`);

head = new Node(1);
head.next = new Node(2);
head.next.next = new Node(3);
head.next.next.next = new Node(4);
head.next.next.next.next = new Node(5);

console.log(`Nodes of original LinkedList are: ${head.get_list()}`);
console.log(`Nodes of rotated LinkedList are: ${rotate(head, 8).get_list()}`);
