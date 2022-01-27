const make_squares = function(arr) {
  squares = []
  let negativeStartIdx = -1;
  let positiveStartIdx = -1;
  let i = 0;
  while(negativeStartIdx === -1 && positiveStartIdx === -1) {
    if (arr[i] >= 0) {
      positiveStartIdx = i;
      if (positiveStartIdx == 0) break;
      else negativeStartIdx = positiveStartIdx - 1;
    }
    i++;
  }

  while(negativeStartIdx >= 0 || positiveStartIdx < arr.length) {
    if (negativeStartIdx >= 0 && positiveStartIdx < arr.length) {
      const neg = arr[negativeStartIdx] * arr[negativeStartIdx];
      const pos = arr[positiveStartIdx] * arr[positiveStartIdx];
      if (neg < pos) {
        squares.push(neg);
        negativeStartIdx--;
      } else {
        squares.push(pos);
        positiveStartIdx++;
      }
    } else if (negativeStartIdx >= 0) {
        const neg = arr[negativeStartIdx] * arr[negativeStartIdx];
        squares.push(neg);
        negativeStartIdx--;
    } else if (positiveStartIdx < arr.length) {
        const pos = arr[positiveStartIdx] * arr[positiveStartIdx];
        squares.push(pos);
        positiveStartIdx++;
    }
  }
  return squares;
};
