class TreeNode {
  constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}

const find_path = function (root, sequence, idx = 0) {
  if (!root || !sequence || sequence.length === 0) return false;
  if (root.value !== sequence[idx]) return false;
  if (sequence.length - 1 === idx) return true;
  return (
    find_path(root.left, sequence, idx + 1) ||
    find_path(root.right, sequence, idx + 1)
  );
};

var root = new TreeNode(1);
root.left = new TreeNode(0);
root.right = new TreeNode(1);
root.left.left = new TreeNode(1);
root.right.left = new TreeNode(6);
root.right.right = new TreeNode(5);

console.log(`Tree has path sequence: ${find_path(root, [1, 0, 7])}`);
console.log(`Tree has path sequence: ${find_path(root, [1, 1, 6])}`);
