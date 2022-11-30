function runningSum(nums: number[]): number[] {
  const result = [];
  let prevSum = 0;
  for (let i = 0; i < nums.length; i++) {
    let sum = prevSum + nums[i];
    result.push(sum);
    prevSum = sum;
  }
  return result;
}
