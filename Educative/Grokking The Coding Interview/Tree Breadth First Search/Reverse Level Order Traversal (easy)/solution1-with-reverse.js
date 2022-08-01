const Deque = require("./collections/deque"); //http://www.collectionsjs.com

class TreeNode {
  constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}

const traverse = function (root) {
  if (!root) return [];

  result = [];
  const deque = new Deque();
  deque.push(root);
  while (deque.length > 0) {
    const level = [];
    let currentSize = deque.length;
    while (currentSize-- !== 0) {
      const node = deque.shift();
      level.push(node.value);
      if (node.left) deque.push(node.left);
      if (node.right) deque.push(node.right);
    }
    result.push(level);
  }

  result.reverse();
  return result;
};

var root = new TreeNode(12);
root.left = new TreeNode(7);
root.right = new TreeNode(1);
root.left.left = new TreeNode(9);
root.right.left = new TreeNode(10);
root.right.right = new TreeNode(5);
console.log(`Reverse level order traversal: ${traverse(root)}`);
