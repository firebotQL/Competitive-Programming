class Node {
  constructor(value, next = null) {
    this.value = value;
    this.next = next;
  }

  get_list() {
    result = "";
    temp = this;
    while (temp !== null) {
      result += temp.value + " ";
      temp = temp.next;
    }
    return result;
  }
}

const reverse_alternate_k_elements = function (head, k) {
  if (k <= 1 || head == null) return head;

  let current = head;
  let previous = null;

  while (current !== null) {
    const lastNodeOfPreviousSublist = previous;
    const lastNodeOfCurrentSublist = current;
    for (let i = 0; i < k && current !== null; i++) {
      const tmpNext = current.next;
      current.next = previous;
      previous = current;
      current = tmpNext;
    }

    if (lastNodeOfPreviousSublist !== null) {
      lastNodeOfPreviousSublist.next = previous;
    } else {
      head = previous;
    }

    lastNodeOfCurrentSublist.next = current;

    for (let i = 0; i < k && current != null; i++) {
      previous = current;
      current = current.next;
    }
  }
  return head;
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
  `Nodes of reversed LinkedList are: ${reverse_alternate_k_elements(
    head,
    2
  ).get_list()}`
);
