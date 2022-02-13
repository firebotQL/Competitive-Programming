const circular_array_loop_exists = function(arr) {
  for(let index = 0; index < arr.length; index++) {
      const isRightDirection = arr[index] >= 0
      let slow = index, fast = index;

      do {
        slow = findNextIndex(arr, isRightDirection, slow);
        fast = findNextIndex(arr, isRightDirection, fast);
        if (fast !== -1) {
          fast = findNextIndex(arr, isRightDirection, fast);
        }
      } while (slow !== -1 && fast !== -1 && slow !== fast)

      if (slow !== -1 && slow === fast) {
        return true;
      }
  }
  return false;
};

const findNextIndex = (arr, isRightDirection, currentIndex) => {
    const currentDirection = arr[currentIndex] >= 0;

    if (currentDirection !== isRightDirection) {
      return -1;
    } 

    nextIndex = (currentIndex + arr[currentIndex]) % arr.length;
    if (nextIndex < 0) {
      nextIndex += arr.length;
    }

    if (nextIndex === currentIndex) {
      nextIndex = -1;
    }

    return nextIndex;
}


console.log(`${circular_array_loop_exists([1, 2, -1, 2, 2])}`)
console.log(`${circular_array_loop_exists([2, 2, -1, 2])}`)
console.log(`${circular_array_loop_exists([2, 1, -1, -2])}`)
