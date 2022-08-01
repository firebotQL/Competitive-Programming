const Deque = require("./collections/deque"); //http://www.collectionsjs.com

class TreeNode {
  constructor(val) {
    this.val = val;
    this.left = null;
    this.right = null;
  }
}

const find_successor = function (root, key) {
  if (root === null) return null;
  const deque = new Deque();
  deque.push(root);
  let catchNext = false;
  while (deque.length > 0) {
    const node = deque.shift();
    if (catchNext) return node;
    if (key == node.val) catchNext = true;
    if (node.left) deque.push(node.left);
    if (node.right) deque.push(node.right);
  }
  return null;
};

var root = new TreeNode(1);
root.left = new TreeNode(2);
root.right = new TreeNode(3);
root.left.left = new TreeNode(4);
root.left.right = new TreeNode(5);

result = find_successor(root, 3);
if (result) {
  console.log(result.val);
}

root = new TreeNode(12);
root.left = new TreeNode(7);
root.right = new TreeNode(1);
root.left.left = new TreeNode(9);
root.right.left = new TreeNode(10);
root.right.right = new TreeNode(5);

let result = find_successor(root, 9);
if (result) {
  console.log(result.val);
}

result = find_successor(root, 12);
if (result) {
  console.log(result.val);
}
