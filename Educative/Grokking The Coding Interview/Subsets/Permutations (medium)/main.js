const find_permutations = function (nums) {
  result = [];
  result.push([]);
  for (let i = 0; i < nums.length; i++) {
    const num = nums[i];
    const newResult = [];
    for (let j = 0; j < result.length; j++) {
      const permutation = result[j];
      if (permutation.length > 0) {
        for (let k = 0; k <= permutation.length; k++) {
          const newPermutation = [
            ...permutation.slice(0, k),
            num,
            ...permutation.slice(k),
          ];
          newResult.push(newPermutation);
        }
      } else {
        newResult.push([num, ...permutation]);
      }
    }
    result = newResult;
  }
  return result;
};

console.log(
  `Here are all the permutations: ${JSON.stringify(
    find_permutations([1, 3, 5])
  )}`
);
