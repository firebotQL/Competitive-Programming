const shortest_window_sort = function(arr) {
  let low = 0;
  let high = arr.length - 1;

  while (low < arr.length - 1 && arr[low] <= arr[low + 1]) {
    low++;
  }

  if (low === arr.length - 1) {
    return 0;
  }

  while (high > 0 && arr[high] >= arr[high - 1]) {
    high--;
  }

  let max = Number.MIN_SAFE_INTEGER,
    min = Number.MAX_SAFE_INTEGER;
  for (let i = low; i < high + 1; i++) {
    max = Math.max(max, arr[i]);
    min = Math.min(min, arr[i]);
  }

  while(low > 0 && arr[low - 1] > min) {
    low--;
  }

  while (high < arr.length - 1 && arr[high + 1] < max) {
    high++;
  }

  return high - low + 1;
};
