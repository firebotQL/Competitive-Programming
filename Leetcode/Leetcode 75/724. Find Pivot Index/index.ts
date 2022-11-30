/**
 * @param {number[]} nums
 * @return {number}
 */
var pivotIndex = function (nums) {
  if (!nums || nums.length === 0) return -1;
  let leftSum = 0;
  let rightSum = nums.reduce((sum, current) => sum + current, 0) - nums[0];
  if (rightSum === leftSum) return 0;
  for (var i = 1; i < nums.length; i++) {
    rightSum -= nums[i];
    leftSum += nums[i - 1];
    if (rightSum === leftSum) return i;
  }
  return -1;
};
