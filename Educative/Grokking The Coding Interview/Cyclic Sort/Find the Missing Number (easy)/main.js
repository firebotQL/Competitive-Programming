const find_missing_number = function (nums) {
  let i = 0;
  while (i < nums.length) {
    const num = nums[i];
    if (num === i || num == nums.length) i++;
    else {
      [nums[i], nums[num]] = [nums[num], nums[i]];
    }
  }

  for (let i = 0; i < nums.length; i++) {
    if (nums[i] !== i) return i;
  }

  return -1;
};
