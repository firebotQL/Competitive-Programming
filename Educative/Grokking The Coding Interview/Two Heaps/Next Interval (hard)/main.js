class Interval {
  constructor(start, end) {
    this.start = start;
    this.end = end;
  }
}

const find_next_interval = function (intervals) {
  result = [];
  // TODO: Write your code here
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
