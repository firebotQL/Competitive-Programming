const cyclic_sort = function (nums) {
  let start = 0;
  while (start < nums.length) {
    let num = nums[start];
    if (num === start + 1) start++;
    else {
      const tmpNum = nums[num - 1];
      nums[num - 1] = num;
      nums[start] = tmpNum;
    }
  }
  return nums;
};

console.log(`${cyclic_sort([3, 1, 5, 4, 2])}`);
console.log(`${cyclic_sort([2, 6, 4, 3, 1, 5])}`);
console.log(`${cyclic_sort([1, 5, 6, 4, 3, 2])}`);
