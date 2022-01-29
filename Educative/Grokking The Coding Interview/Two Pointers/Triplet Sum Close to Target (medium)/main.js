// O(N^2) runtime complexity and O(N) space for sorting complexity
const triplet_sum_close_to_target = function(arr, target_sum) {
  const arr_sorted = arr.sort((a,b) => a - b);
  let minDiff = Number.MAX_SAFE_INTEGER;
  let minSum = 0;
  for(let i = 0; i < arr_sorted.length; i++) {
    // z + y = -x
    const x = arr[i];
    let left = i + 1;
    let right = arr_sorted.length - 1;

    while (left < right) {
      const z = arr[left];
      const y = arr[right];
      const tripletSum = x + y + z;
      const diff = Math.abs(target_sum - tripletSum);
      if (minDiff > diff) {
        minDiff = diff;
        minSum = tripletSum;
      }
      if (z + y < target_sum - x) {
        left++;
      } else {
        right--;
      }
    }
  }
  return minSum;
};
