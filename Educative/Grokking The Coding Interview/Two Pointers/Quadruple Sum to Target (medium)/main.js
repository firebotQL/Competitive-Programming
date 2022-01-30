const search_quadruplets = function(arr, target) {
  quadruplets = [];
  // x + y + z + t = target
  arr.sort((a,b) => a-b);
  for(let i = 0; i < arr.length - 3; i++) {
    const x = arr[i];
    for (let j = i + 1; j < arr.length - 2; j++) {
      const y = arr[j];
       let left = j + 1;
       let right = arr.length - 1;
       while (left < right) {
         const z = arr[left];
         const t = arr[right];
         if (x + y + z + t === target) {
           quadruplets.push([x, y, z, t]);
           break;
         } else if (x + y + z + t < target) {
           left++;
         } else {
           right--;
         }
       }
    }
  }
  return quadruplets;
};
