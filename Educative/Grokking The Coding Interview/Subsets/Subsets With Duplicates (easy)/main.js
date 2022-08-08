const find_subsets = function (nums) {
  debugger;
  subsets = [];
  nums.sort();
  subsets.push([]);
  let previousNum;
  let endIndex;
  for (let i = 0; i < nums.length; i++) {
    const currentNum = nums[i];
    startIndex = previousNum === currentNum ? endIndex : 0;
    endIndex = subsets.length;
    for (let j = startIndex; j < endIndex; j++) {
      const subset = subsets[j];
      subsets.push([...subset, currentNum]);
    }
    previousNum = currentNum;
  }
  return subsets;
};

console.log(
  `Here is the list of subsets: ${JSON.stringify(find_subsets([1, 3, 3]))}`
);
console.log(
  `Here is the list of subsets: ${JSON.stringify(find_subsets([1, 5, 3, 3]))}`
);
