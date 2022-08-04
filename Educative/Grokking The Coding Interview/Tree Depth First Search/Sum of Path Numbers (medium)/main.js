class TreeNode {
  constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}

const find_sum_of_path_numbers = function (root) {
  if (!root) return 0;
  return find_sum_of_path_numbers_to_theLeaf(root, 0);
};

const find_sum_of_path_numbers_to_theLeaf = (root, currentPath) => {
  if (!root) return 0;
  const newPath = currentPath * 10 + root.value;
  if (!root.left && !root.right) return newPath;

  return (
    find_sum_of_path_numbers_to_theLeaf(root.left, newPath) +
    find_sum_of_path_numbers_to_theLeaf(root.right, newPath)
  );
};

var root = new TreeNode(1);
root.left = new TreeNode(0);
root.right = new TreeNode(1);
root.left.left = new TreeNode(1);
root.right.left = new TreeNode(6);
root.right.right = new TreeNode(5);
console.log(`Total Sum of Path Numbers: ${find_sum_of_path_numbers(root)}`);
