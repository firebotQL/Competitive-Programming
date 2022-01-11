const smallest_subarray_with_given_sum = function(s, arr) {
  let smallest = Number.MAX_SAFE_INTEGER;
  let window = 0;
  let length = 0;
  for(let i = 0; i < arr.length; i++) {
    window += arr[i];
    length += 1;
    while(window >= s) {
      smallest = Math.min(smallest, length);
      window -= arr[i + 1 - length];
      length -= 1;
    }
  }
  return smallest === Number.MAX_SAFE_INTEGER ? 0 : smallest;
};
