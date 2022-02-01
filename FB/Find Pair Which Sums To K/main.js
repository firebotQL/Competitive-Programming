// Note array is sorted
const findPairWhichSumsToK = (array, K) => {
  let left = 0;
  let right = array.length - 1;
  while (left < right) {
    const currentSum = array[left] + array[right];
    if (currentSum > K) {
      right--;
    } else if (currentSum < K) {
      left++;
    } else {
      return [left, right];
    }
  }
}
// findPairWhichSumsToK([1,2,3,4,5,6,7,8,9,10], 9)
