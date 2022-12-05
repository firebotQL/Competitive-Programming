const Deque = require("./collections/deque"); //http://www.collectionsjs.com

class TreeNode {
  constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }

  // tree traversal using 'next' pointer
  print_tree() {
    result = "Traversal using 'next' pointer: ";
    current = this;
    while (current != null) {
      result += current.value + " ";
      current = current.next;
    }
    console.log(result);
  }
}

const connect_all_siblings = function (root) {
  if (root === null) return root;
  const deque = new Deque();
  deque.push(root);
  let previous;
  while (deque.length > 0) {
    let currentLevelSize = deque.length;
    while (currentLevelSize-- != 0) {
      const node = deque.shift();
      if (previous) previous.next = node;
      previous = node;
      if (node.left) deque.push(node.left);
      if (node.right) deque.push(node.right);
    }
  }
};

var root = new TreeNode(12);
root.left = new TreeNode(7);
root.right = new TreeNode(1);
root.left.left = new TreeNode(9);
root.right.left = new TreeNode(10);
root.right.right = new TreeNode(5);
connect_all_siblings(root);
root.print_tree();