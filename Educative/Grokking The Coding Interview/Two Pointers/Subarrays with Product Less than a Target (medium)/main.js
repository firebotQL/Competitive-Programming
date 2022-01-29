const Deque = require("collections/deque");

const find_subarrays = function(arr, target) {
  let result = [],
  product = 1;
  for(let left = 0, right = 0; right < arr.length; right++) {
    product *= arr[right];
    while((product >= target && left < arr.length)) {
      product /= arr[left++];
    }

    const temp = new Deque();
    for(let i = right; i > left - 1; i--) {
      temp.unshift(arr[i]);
      result.push(temp.toArray());
    }
  }
  return result;
};
