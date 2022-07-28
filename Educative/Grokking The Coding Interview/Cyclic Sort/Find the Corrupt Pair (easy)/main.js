const find_corrupt_numbers = function (nums) {
  let i = 0;
  while (i < nums.length) {
    const num = nums[i];
    if (i === num - 1 || num == -1) i++;
    else {
      const tmpNum = nums[num - 1];
      if (tmpNum == num) {
        i++;
        continue;
      }
      nums[num - 1] = num;
      nums[i] = tmpNum;
    }
  }
  for (i = 0; i < nums.length; i++) {
    if (nums[i] != i + 1) return [nums[i], i + 1];
  }
  return [-1, -1];
};
