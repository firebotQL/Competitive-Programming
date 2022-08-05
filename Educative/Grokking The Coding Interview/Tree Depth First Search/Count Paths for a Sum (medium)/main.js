const Deque = require("./collections/deque");

class TreeNode {
  constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}

const count_paths = function (root, S, path = new Deque()) {
  if (!root) return 0;

  path.push(root.value);
  let currentSum = 0;
  let pathCount = 0;
  if (!root.left && !root.right) {
    for (let i = path.length - 1; i >= 0; i--) {
      currentSum += path[i];
      if (currentSum === S) {
        pathCount++;
      }
    }
  }

  pathCount +=
    count_paths(root.left, S, path) + count_paths(root.right, S, path);

  path.pop();
  return pathCount;
};

var root = new TreeNode(12);
root.left = new TreeNode(7);
root.right = new TreeNode(1);
root.left.left = new TreeNode(4);
root.right.left = new TreeNode(10);
root.right.right = new TreeNode(5);
console.log(`Tree has paths: ${count_paths(root, 11)}`);
