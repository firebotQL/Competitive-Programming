class TreeNode {
  constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}

const find_maximum_path_sum = function (root) {
  if (!currentNode) return 0;

  return calculate_max_sum(root, 0);
};

const calculate_max_sum = (currentNode, previousSum) => {
  if (!currentNode) return previousSum;

  const currentSum = previousSum + currentNode.value;

  const leftTreeMaxSum = this.calculate_max_sum(currentNode.left, currentSum);
  const rightTreeMaxSum = this.calculate_max_sum(currentNode.right, currentSum);

  return Math.max(leftTreeMaxSum, rightTreeMaxSum);
};

var root = new TreeNode(1);
root.left = new TreeNode(2);
root.right = new TreeNode(3);
console.log(`Maximum Path Sum: ${find_maximum_path_sum(root)}`);

root.left.left = new TreeNode(1);
root.left.right = new TreeNode(3);
root.right.left = new TreeNode(5);
root.right.right = new TreeNode(6);
root.right.left.left = new TreeNode(7);
root.right.left.right = new TreeNode(8);
root.right.right.left = new TreeNode(9);
console.log(`Maximum Path Sum: ${find_maximum_path_sum(root)}`);

root = new TreeNode(-1);
root.left = new TreeNode(-3);
console.log(`Maximum Path Sum: ${find_maximum_path_sum(root)}`);
