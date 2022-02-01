class TreeNode {
  constructor(value, left, right) {
    this.value = value;
    this.left = left;
    this.right = right;
  }
}

const findSmallestKthSmallest = (node, K, currentCount = 1) => {
  if (node.left) currentCount += findSmallestKthSmallest(node.left, K);
  if (K === currentCount) console.log(`Result: ${node.value}`);
  if (node.right) currentCount = findSmallestKthSmallest(node.right, K, currentCount + 1);
  return currentCount;
}

const leaf1 = new TreeNode(2);
const leaf2 = new TreeNode(3);
const leaf3 = new TreeNode(7);

const mid1 = new TreeNode(4, leaf1, leaf2);
const mid2 = new TreeNode(6, undefined, leaf3);

const treeRoot = new TreeNode(5, mid1 , mid2);


findSmallestKthSmallest(treeRoot, 5);
