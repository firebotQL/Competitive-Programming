const find_first_k_missing_positive = function (nums, k) {
  const missingNumbers = [];
  let i = 0;
  while (i < nums.length) {
    const j = nums[i] - 1;
    if (j > -1 && j < nums.length && nums[i] !== nums[j]) {
      [nums[i], nums[j]] = [nums[j], nums[i]];
    } else {
      i++;
    }
  }

  const extraNumbers = new Set();
  for (i = 0; i < nums.length; i++) {
    if (missingNumbers.length < k) {
      if (nums[i] !== i + 1) {
        extraNumbers.add(nums[i]);
        missingNumbers.push(i + 1);
      }
    }
  }

  i = 1;
  while (missingNumbers.length < k) {
    const candidateNumber = i + nums.length;
    // ignore if the array contains the candidate number
    if (!extraNumbers.has(candidateNumber))
      missingNumbers.push(candidateNumber);
    i++;
  }
  return missingNumbers;
};
