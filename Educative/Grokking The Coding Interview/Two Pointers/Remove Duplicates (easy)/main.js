const remove_duplicates = function(arr) {
  let dups = 0;
  for(let leftIdx = 0, rightIdx = 1; rightIdx < arr.length; leftIdx++, rightIdx++) {
    if (arr[leftIdx] === arr[rightIdx]) dups++;
  }
  return arr.length - dups;
};
