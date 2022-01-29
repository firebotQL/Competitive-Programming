// Runtime complexity is O(N * logN + N^2) which is actually by highest is O(N^2) quadratic
// Space complexity is O(N) for sort ignoring result array
const search_triplets = function(arr) {
  triplets = [];
  sorted_array = arr.sort((a,b) => a - b);
  // x + y + z = 0;
  // x + y = -z
  for(let i = 0; i < arr.length; i++) {

    if (i > 0 && arr[i] === arr[i - 1]) {
      continue;
    }

    const x = arr[i];
    let left = i + 1;
    let right = arr.length - 1;
    while(left < right) {
      while(arr[left] === arr[left - 1]) left++;
      while(arr[right] === arr[right + 1]) right--;
      const y = arr[left];
      const z = arr[right]
      const sum = y + z;
      if (sum === -x) {
        triplets.push([y, x, z]);
        left++;
        right--;
      } else if (sum > -x) {
        right--;
      } else if (sum < -x) {
        left++;
      }
    }
  }
  return triplets;
};
