var Heap = require("./collections/heap");

class Interval {
  constructor(start, end) {
    this.start = start;
    this.end = end;
  }
}

const find_next_interval = function (intervals) {
  const result = Array(intervals.length).fill(0);
  const maxStartHeap = new Heap([], null, (a, b) => a[0] - b[0]);
  const maxEndHeap = new Heap([], null, (a, b) => a[0] - b[0]);
  for (let i = 0; i < intervals.length; i++) {
    maxStartHeap.push([intervals[i].start, i]);
    maxEndHeap.push([intervals[i].end, i]);
  }

  for (let i = 0; i < intervals.length; i++) {
    const [topEnd, endIndex] = maxEndHeap.pop();
    result[endIndex] = -1;
    if (maxStartHeap.peek()[0] >= topEnd) {
      let [topStart, startIndex] = maxStartHeap.pop();

      while (maxStartHeap.length > 0 && maxStartHeap.peek()[0] >= topEnd) {
        [topStart, startIndex] = maxStartHeap.pop();
      }
      result[endIndex] = startIndex;

      maxStartHeap.push([topStart, startIndex]);
    }
  }
  return result;
};

result = find_next_interval([
  new Interval(2, 3),
  new Interval(3, 4),
  new Interval(5, 6),
]);
console.log(`Next interval indices are: ${result}`);

result = find_next_interval([
  new Interval(3, 4),
  new Interval(1, 5),
  new Interval(4, 6),
]);
console.log(`Next interval indices are: ${result}`);
