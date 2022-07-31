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

const reverse_every_k_elements = function (head, k) {
  let current = head;
  let previous = null;
  let resultHead = null;
  let previousTail = null;
  debugger;
  while (current != null) {
    const currentStart = current;
    for (let i = 0; i < k && current != null; i++) {
      const tmpNext = current.next;
      current.next = previous;
      previous = current;
      current = tmpNext;
    }
    if (!resultHead) resultHead = previous;
    if (!previousTail) {
      previousTail = head;
    } else {
      previousTail.next = previous;
      previousTail = currentStart;
    }
  }

  previousTail.next = null;

  return resultHead;
};

head = new Node(1);
head.next = new Node(2);
head.next.next = new Node(3);
head.next.next.next = new Node(4);
head.next.next.next.next = new Node(5);
head.next.next.next.next.next = new Node(6);
head.next.next.next.next.next.next = new Node(7);
head.next.next.next.next.next.next.next = new Node(8);

console.log(`Nodes of original LinkedList are: ${head.get_list()}`);
console.log(
  `Nodes of reversed LinkedList are: ${reverse_every_k_elements(
    head,
    3
  ).get_list()}`
);
