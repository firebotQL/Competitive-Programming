const find_subsets = function (nums) {
  const subsets = [];
  subsets.push([]);
  for (let i = 0; i < nums.length; i++) {
    const num = nums[i];
    const currentSubsetSize = subsets.length;
    for (let j = 0; j < currentSubsetSize; j++) {
      const subset = subsets[j];
      subsets.push([...subset, num]);
    }
  }
  return subsets;
};

console.log(
  `Here is the list of subsets: ${JSON.stringify(find_subsets([1, 3]))}`
);
console.log(
  `Here is the list of subsets: ${JSON.stringify(find_subsets([1, 5, 3]))}`
);
