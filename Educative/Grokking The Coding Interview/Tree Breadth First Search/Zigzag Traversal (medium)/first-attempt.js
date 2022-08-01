const Deque = require("./collections/deque"); //http://www.collectionsjs.com

class TreeNode {
  constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}

const traverse = function (root) {
  const result = [];
  if (!root) return result;
  let deque = new Deque();
  let dequePerLevel = new Deque();
  deque.push(root);
  let inOrder = true;
  while (deque.length > 0) {
    const level = [];
    let currentLevelSize = deque.length;
    for (let i = 0; i < currentLevelSize; i++) {
      const node = inOrder ? deque.shift() : deque.pop();
      level.push(node.value);
      if (inOrder) {
        if (node.left) dequePerLevel.push(node.left);
        if (node.right) dequePerLevel.push(node.right);
      } else {
        if (node.right) dequePerLevel.unshift(node.right);
        if (node.left) dequePerLevel.unshift(node.left);
      }
    }
    const tmpDeque = deque;
    deque = dequePerLevel;
    dequePerLevel = tmpDeque;
    console.log(level);
    result.push(level);
    inOrder = !inOrder;
  }
  // TODO: Write your code here
  return result;
};

var root = new TreeNode(12);
root.left = new TreeNode(7);
root.right = new TreeNode(1);
root.left.left = new TreeNode(9);
root.right.left = new TreeNode(10);
root.right.right = new TreeNode(5);
root.right.left.left = new TreeNode(20);
root.right.left.right = new TreeNode(17);
console.log(`Zigzag traversal: ${traverse(root)}`);
