const Deque = require("./collections/deque"); //http://www.collectionsjs.com

class TreeNode {
  constructor(val) {
    this.val = val;
    this.left = null;
    this.right = null;
  }
}

const traverse = function (root) {
  result = [];
  var deque = new Deque();
  deque.push(root);
  var dequeCurrentLevel = new Deque();
  while (deque.length > 0) {
    const level = [];
    while (deque.length > 0) {
      const node = deque.pop();
      level.push(node.val);
      if (node.left) dequeCurrentLevel.push(node.left);
      if (node.right) dequeCurrentLevel.push(node.right);
    }
    result.push([level]);

    const tmpDequeue = deque;
    deque = dequeCurrentLevel;
    dequeCurrentLevel = tmpDequeue;
  }
  return result;
};

var root = new TreeNode(12);
root.left = new TreeNode(7);
root.right = new TreeNode(1);
root.left.left = new TreeNode(9);
root.right.left = new TreeNode(10);
root.right.right = new TreeNode(5);
console.log(`Level order traversal: ${traverse(root)}`);
