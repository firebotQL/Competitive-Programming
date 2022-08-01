const Deque = require("./collections/deque"); //http://www.collectionsjs.com

class TreeNode {
  constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}

const find_minimum_depth = function (root) {
  let minDepth = -1;
  let currentDepth = 0;
  const deque = new Deque();
  deque.push(root);
  while (deque.length > 0) {
    currentDepth += 1;
    const currentLevelSize = deque.length;
    for (let i = 0; i < currentLevelSize; i++) {
      const node = deque.shift();
      if (!node.left && !node.right) return currentDepth;
      if (node.left) deque.push(node.left);
      if (node.right) deque.push(node.right);
    }
  }

  return minDepth;
};

var root = new TreeNode(12);
root.left = new TreeNode(7);
root.right = new TreeNode(1);
root.right.left = new TreeNode(10);
root.right.right = new TreeNode(5);
console.log(`Tree Minimum Depth: ${find_minimum_depth(root)}`);
root.left.left = new TreeNode(9);
root.right.left.left = new TreeNode(11);
console.log(`Tree Minimum Depth: ${find_minimum_depth(root)}`);
