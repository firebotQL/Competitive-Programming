class Node {
  constructor(value, next=null){
    this.value = value;
    this.next = next;
  }

  print_list() {
    result = "";
    temp = this;
    while (temp !== null) {
      result += temp.value + " ";
      temp = temp.next;
    }
    console.log(result);
  }
}


const reorder = function(head) {
  // find mid
  let slow = head;
  let fast = head;
  let cnt = 0;
  while(fast !== null && fast.next !== null) {
    slow = slow.next;
    fast = fast.next.next;
    cnt++;
  }

  let previous = slow;
  let current = slow;
  // reverse end
  while(current !== null) {
    let tmp = current.next;
    current.next = previous;
    previous = current;
    current = tmp;
  }

  let left = head;
  let right = previous;
  let tmpl;
  let tmpr;
  while (cnt-- > 0) {
    tmpl = left.next;
    left.next = right;
    tmpr = right.next;
    right.next = tmpl;
    left = tmpl;
    right = tmpr;
  }

  left.next = null;

  return head;
}


head = new Node(2)
head.next = new Node(4)
head.next.next = new Node(6)
head.next.next.next = new Node(8)
head.next.next.next.next = new Node(10)
head.next.next.next.next.next = new Node(12)
reorder(head)
head.print_list()
