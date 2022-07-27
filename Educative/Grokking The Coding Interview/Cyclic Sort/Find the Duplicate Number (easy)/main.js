const find_duplicate = function (nums) {
  let i = 0;
  while (i < nums.length) {
    const num = nums[i];
    if (num - 1 == i) i++;
    else {
      const tmpNum = nums[num - 1];
      if (tmpNum == num) return num;
      nums[num - 1] = num;
      nums[i] = tmpNum;
    }
  }
  return -1;
};
