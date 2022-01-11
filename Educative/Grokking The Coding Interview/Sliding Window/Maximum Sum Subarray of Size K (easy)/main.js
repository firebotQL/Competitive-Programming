const max_sub_array_of_size_k = function(k, arr) {
  let currentSum = 0;
  let maxSum = Number.MIN_SAFE_INTEGER;
  for(let i = 0; i < arr.length; i++) {
    currentSum += arr[i];
    if (i >= k) {
      currentSum -= arr[i - k];
    }
    maxSum = Math.max(maxSum, currentSum);
  }
  return maxSum;
};
