const Deque = require("./collections/deque"); //http://www.collectionsjs.com

class TreeNode {
  constructor(val) {
    this.val = val;
    this.left = null;
    this.right = null;
    this.next = null;
  }

  // level order traversal using 'next' pointer
  print_level_order() {
    console.log("Level order traversal using 'next' pointer: ");
    let nextLevelRoot = this;
    while (nextLevelRoot !== null) {
      let current = nextLevelRoot;
      nextLevelRoot = null;
      while (current != null) {
        process.stdout.write(`${current.val} `);
        if (nextLevelRoot === null) {
          if (current.left !== null) {
            nextLevelRoot = current.left;
          } else if (current.right !== null) {
            nextLevelRoot = current.right;
          }
        }
        current = current.next;
      }
      console.log();
    }
  }
}

const connect_level_order_siblings = function (root) {
  if (root === null) return root;
  let deque = new Deque();
  deque.push(root);
  while (deque.length > 0) {
    let currentLevelSize = deque.length;
    let previous = null;
    while (currentLevelSize-- !== 0) {
      const node = deque.pop();
      node.next = previous;
      previous = node;
      if (node.right) deque.unshift(node.right);
      if (node.left) deque.unshift(node.left);
    }
  }
};

var root = new TreeNode(12);
root.left = new TreeNode(7);
root.right = new TreeNode(1);
root.left.left = new TreeNode(9);
root.right.left = new TreeNode(10);
root.right.right = new TreeNode(5);
connect_level_order_siblings(root);

root.print_level_order();
