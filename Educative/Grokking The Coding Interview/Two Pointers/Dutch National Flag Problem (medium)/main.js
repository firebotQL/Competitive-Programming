const dutch_flag_sort = function(arr) {
  let i = 0, low = 0, high = arr.length - 1;
  while (i <= high) {
    if (arr[i] === 0) {
      [arr[i], arr[low]] = [arr[low], arr[i]]; // destructuring swap
      i++;
      low++;
    } else if (arr[i] === 1) {
      i++;
    } else {
      [arr[i], arr[high]] = [arr[high], arr[i]];  // destructuring swap
      high -= 1;
    }
  }
};
