class TreeNode {
  constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}

const find_paths = function (root, sum, exploringPath = []) {
  let allPaths = [];
  if (!root) return allPaths;

  // not efficient, can be sorted with the (de)queue
  const currentPath = [...exploringPath, root.value];

  if (root.value == sum && !root.left && !root.right)
    allPaths.push(currentPath);

  allPaths = [
    ...allPaths,
    ...find_paths(root.left, sum - root.value, currentPath),
    ...find_paths(root.right, sum - root.value, currentPath),
  ];

  return allPaths;
};

var root = new TreeNode(12);
root.left = new TreeNode(7);
root.right = new TreeNode(1);
root.left.left = new TreeNode(4);
root.right.left = new TreeNode(10);
root.right.right = new TreeNode(5);
(sum = 23), (result = find_paths(root, sum));

process.stdout.write(`Tree paths with sum ${sum}: `);
for (i = 0; i < result.length; i++) {
  process.stdout.write(`[${result[i]}] `);
}
