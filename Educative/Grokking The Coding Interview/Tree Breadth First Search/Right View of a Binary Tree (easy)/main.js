const Deque = require("./collections/deque"); //http://www.collectionsjs.com

class TreeNode {
  constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}

const tree_right_view = function (root) {
  result = [];
  if (root === null) return result;
  const deque = new Deque();
  deque.push(root);
  while (deque.length > 0) {
    let currentLevelSize = deque.length;
    while (currentLevelSize-- != 0) {
      const node = deque.shift();
      if (currentLevelSize === 0) result.push(node.value);
      if (node.left) deque.push(node.left);
      if (node.right) deque.push(node.right);
    }
  }
  return result;
};

var root = new TreeNode(12);
root.left = new TreeNode(7);
root.right = new TreeNode(1);
root.left.left = new TreeNode(9);
root.right.left = new TreeNode(10);
root.right.right = new TreeNode(5);
root.left.left.left = new TreeNode(3);
console.log("Tree right view: " + tree_right_view(root));
