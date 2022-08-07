const Heap = require("./collections/heap");

// Input: Project Capitals=[0,1,2,3], Project Profits=[1,2,3,5], Initial Capital=0, Number of Projects=3
const find_maximum_capital = function (
  capital,
  profits,
  numberOfProjects,
  initialCapital
) {
  const minCapitalHeap = new Heap([], null, (a, b) => b[0] - a[0]);
  const maxProfitHeap = new Heap([], null, (a, b) => a[0] - b[0]);

  for (let i = 0; i < profits.length; i++) {
    minCapitalHeap.push([capital[i], i]);
  }

  let availableCapital = initialCapital;
  for (let i = 0; i < numberOfProjects; i++) {
    while (
      minCapitalHeap.length > 0 &&
      minCapitalHeap.peek()[0] <= availableCapital
    ) {
      const [capital, index] = minCapitalHeap.pop();
      maxProfitHeap.push([profits[index], index]);
    }

    if (maxProfitHeap.length == 0) break;

    availableCapital += maxProfitHeap.pop()[0];
  }
  return availableCapital;
};

console.log(
  `Maximum capital: ${find_maximum_capital([0, 1, 2], [1, 2, 3], 2, 1)}`
);
console.log(
  `Maximum capital: ${find_maximum_capital([0, 1, 2, 3], [1, 2, 3, 5], 3, 0)}`
);
