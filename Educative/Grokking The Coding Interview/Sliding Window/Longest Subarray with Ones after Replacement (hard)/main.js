const length_of_longest_substring = function(arr, k) {
  let maxLength = Number.MIN_SAFE_INTEGER;
  let maxCount = 0;
  let windowStart = 0;
  for(let i = 0; i < arr.length; i++) {
    if (arr[i] === 1) maxCount++;

    if ((i - windowStart + 1 - maxCount) > k) {
      if (arr[windowStart++] === 1) {
        maxCount--;
      }
    }
    maxLength = Math.max(maxLength, i - windowStart + 1);
  }
  return maxLength;
};
