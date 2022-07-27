const find_all_duplicates = function (nums) {
  duplicateNumbers = [];
  let i = 0;
  while (i < nums.length) {
    const num = nums[i];
    if (num - 1 == i) i++;
    else {
      const tmpNum = nums[num - 1];
      nums[num - 1] = num;
      nums[i] = tmpNum;
      if (tmpNum == num) {
        duplicateNumbers.push(tmpNum);
        i++;
      }
    }
  }
  return duplicateNumbers;
};
