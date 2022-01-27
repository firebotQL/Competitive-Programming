const remove_duplicates = function(arr) {
    let nonDuplicateIdx = 1;
    let currentIdx = 1;
    while(currentIdx < arr.length) {
      if (arr[nonDuplicateIdx - 1] !== arr[currentIdx]) {
        arr[nonDuplicateIdx] = arr[currentIdx];
        nonDuplicateIdx++;
      }
      currentIdx++;
    }

    return nonDuplicateIdx;
};
