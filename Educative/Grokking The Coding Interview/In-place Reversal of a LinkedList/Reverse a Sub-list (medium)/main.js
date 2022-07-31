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

const reverse_sub_list = function (head, p, q) {
  let initialCurrent = head;
  let initialPrevious = null;
  let i = 1;
  for (; i < p; i++) {
    initialPrevious = initialCurrent;
    initialCurrent = initialCurrent.next;
  }

  let current = initialCurrent;
  let previous = initialPrevious;

  for (; i <= q && current != null; i++) {
    const tmpNext = current.next;
    current.next = previous;
    previous = current;
    current = tmpNext;
  }

  initialCurrent.next = current;

  if (initialPrevious) {
    initialPrevious.next = previous;
  }

  return initialPrevious || previous;
};

head = new Node(1);
head.next = new Node(2);
head.next.next = new Node(3);
head.next.next.next = new Node(4);
head.next.next.next.next = new Node(5);

console.log(`Nodes of original LinkedList are: ${head.get_list()}`);
console.log(
  `Nodes of reversed LinkedList are: ${reverse_sub_list(head, 1, 5).get_list()}`
);
head = new Node(1);
head.next = new Node(2);
head.next.next = new Node(3);
head.next.next.next = new Node(4);
head.next.next.next.next = new Node(5);
console.log(
  `Nodes of reversed LinkedList are: ${reverse_sub_list(head, 1, 6).get_list()}`
);
head = new Node(1);
head.next = new Node(2);
head.next.next = new Node(3);
head.next.next.next = new Node(4);
head.next.next.next.next = new Node(5);
console.log(
  `Nodes of reversed LinkedList are: ${reverse_sub_list(head, 1, 4).get_list()}`
);
head = new Node(1);
head.next = new Node(2);
head.next.next = new Node(3);
head.next.next.next = new Node(4);
head.next.next.next.next = new Node(5);
console.log(
  `Nodes of reversed LinkedList are: ${reverse_sub_list(head, 2, 5).get_list()}`
);
head = new Node(1);
head.next = new Node(2);
head.next.next = new Node(3);
head.next.next.next = new Node(4);
head.next.next.next.next = new Node(5);
console.log(
  `Nodes of reversed LinkedList are: ${reverse_sub_list(head, 2, 6).get_list()}`
);
head = new Node(1);
head.next = new Node(2);
head.next.next = new Node(3);
head.next.next.next = new Node(4);
head.next.next.next.next = new Node(5);
console.log(
  `Nodes of reversed LinkedList are: ${reverse_sub_list(head, 2, 4).get_list()}`
);
