// O(N^2) runtime complexity and O(N) space complexity
const triplet_with_smaller_sum = function(arr, target) {
  let count = 0;
  arr.sort((a,b) => a - b);
  for(let i = 0; i < arr.length - 2; i++) {
    // x + z + y < target
    const x = arr[i];

    let left = i + 1;
    let right = arr.length - 1;

    while(left < right) {
      const y = arr[left];
      const z = arr[right];

      if (x + y + z < target) {
        count += right - left;
        left++;
      } else {
        right--;
      }
    }
  }
  return count;
};
