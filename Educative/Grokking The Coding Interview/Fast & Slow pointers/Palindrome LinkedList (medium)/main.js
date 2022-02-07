class Node {
  constructor(value, next=null){
    this.value = value;
    this.next = next;
  }
}


const is_palindromic_linked_list= function(head) {
  let slow = head;
  let fast = head;
  let cnt = 1;
  while(fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
    cnt++;
  }
  let mid = slow;

  let start = head;
  let end = reverseFromMidAndGetEnd(mid);
  let previous = null;
  while (cnt-- > 0) {
    if (start.value !== end.value) {
      return false;
    }
    start = start.next;
    let tmp = end;
    end = end.next;
    tmp.next = previous;
    previous = end;
  }
  return true;
};

const reverseFromMidAndGetEnd = (mid) => {
  let previous = mid;
  let current = mid.next;
  let tmp;
  while(current != null) {
    tmp = current.next;
    current.next = previous;
    previous = current;
    current = tmp;
  }
  return previous;
}


head = new Node(2)
head.next = new Node(4)
head.next.next = new Node(6)
head.next.next.next = new Node(4)
head.next.next.next.next = new Node(2)

console.log(`Is palindrome: ${is_palindromic_linked_list(head)}`)

head.next.next.next.next.next = new Node(2)
console.log(`Is palindrome: ${is_palindromic_linked_list(head)}`)
