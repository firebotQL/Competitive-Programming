class TreeNode {
  constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}

class MaximumPathSum {
  find_maximum_path_sum(root) {
    this.globalMaximumSum = -Infinity;
    this.find_maximum_path_sum_recursive(root);
    return this.globalMaximumSum;
  }

  find_maximum_path_sum_recursive(currentNode) {
    if (!currentNode) return 0;

    let maxPathSumFromLeft = this.find_maximum_path_sum_recursive(
      currentNode.left
    );
    let maxPathSumFromRight = this.find_maximum_path_sum_recursive(
      currentNode.right
    );

    const localMaximumSum =
      maxPathSumFromLeft + maxPathSumFromRight + currentNode.value;

    this.globalMaximumSum = Math.max(this.globalMaximumSum, localMaximumSum);

    return (
      Math.max(maxPathSumFromLeft, maxPathSumFromRight) + currentNode.value
    );
  }
}

const find_maximum_path_sum = function (root) {
  if (!root) return 0;

  return calculate_max_sum(root, 0);
};

const calculate_max_sum = (currentNode, previousSum) => {
  debugger;
  if (!currentNode) return previousSum;

  const currentSum = previousSum + currentNode.value;

  const leftTreeMaxSum = calculate_max_sum(currentNode.left, currentSum);
  const rightTreeMaxSum = calculate_max_sum(currentNode.right, currentSum);

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
