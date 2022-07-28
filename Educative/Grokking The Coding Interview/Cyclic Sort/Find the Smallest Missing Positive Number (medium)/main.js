const find_first_smallest_missing_positive = function (nums) {
  let i = 0;
  while (i < nums.length) {
    const j = nums[i] - 1;
    if (j > -1 && nums[j] != nums[i]) {
      [nums[j], nums[i]] = [nums[i], nums[j]];
    } else {
      i++;
    }
  }

  for (i = 0; i < nums.length; i++) {
    if (nums[i] - 1 !== i) return i + 1;
  }

  return -1;
};
