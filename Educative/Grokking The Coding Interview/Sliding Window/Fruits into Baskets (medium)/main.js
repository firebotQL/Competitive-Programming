const fruits_into_baskets = function(fruits) {
  const basket = {};
  let maxLen = Number.MIN_SAFE_INTEGER;
  let startWindow = 0;
  for(let i = 0; i < fruits.length; i++) {
    const fruit = fruits[i];
    if (!basket[fruit]) basket[fruit] = 0;
    basket[fruit] += 1;

    while(Object.keys(basket).length > 2) {
      const startingFruit = fruits[startWindow];
      basket[startingFruit] -= 1;
      if (basket[startingFruit] === 0) {
        delete basket[startingFruit];
      }
      startWindow++;
    }
    maxLen = Math.max(maxLen, i - startWindow + 1);
  }
  return maxLen;
};
