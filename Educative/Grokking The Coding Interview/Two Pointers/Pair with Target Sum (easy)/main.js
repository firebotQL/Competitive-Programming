const pair_with_targetsum = function(arr, target_sum) {
  let startIndex = 0;
  let endIndex = arr.length - 1;
  while(startIndex < endIndex) {
    const sum = arr[startIndex] + arr[endIndex];
    if (target_sum < sum) {
      endIndex--;
    } else if (target_sum > sum) {
      startIndex++;
    } else {
      return [startIndex, endIndex];
    }
  }
}
