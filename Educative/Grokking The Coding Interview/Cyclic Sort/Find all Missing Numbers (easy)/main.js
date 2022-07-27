const find_missing_numbers = function (nums) {
  missingNumbers = [];
  let i = 0;
  while (i < nums.length) {
    const num = nums[i];
    if (num - 1 == i) i++;
    else {
      const tmpNum = nums[num - 1];
      if (tmpNum == num) i++;
      else {
        nums[num - 1] = num;
        nums[i] = tmpNum;
      }
    }
  }
  for (let i = 0; i < nums.length; i++) {
    if (nums[i] - 1 != i) missingNumbers.push(i + 1);
  }
  return missingNumbers;
};
