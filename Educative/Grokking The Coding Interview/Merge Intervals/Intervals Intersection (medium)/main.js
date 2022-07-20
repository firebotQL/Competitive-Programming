class Interval {
  constructor(start, end) {
    this.start = start;
    this.end = end;
  }

  print_interval() {
    process.stdout.write(`[${this.start}, ${this.end}]`);
  }
}

const merge = function (intervals_a, intervals_b) {
  let result = [];
  if (
    !intervals_a ||
    !intervals_b ||
    intervals_a.length == 0 ||
    intervals_b.length === 0
  ) {
    return result;
  }

  let i = 0;
  let j = 0;

  while (i < intervals_a.length && j < intervals_b.length) {
    const interval_a = intervals_a[i];
    const interval_b = intervals_b[j];
    const overlaps =
      (interval_a.start >= interval_b.start &&
        interval_a.start <= interval_b.end) ||
      (interval_b.start >= interval_a.start &&
        interval_b.start <= interval_a.end);
    if (overlaps)
      result.push(
        new Interval(
          Math.max(interval_a.start, interval_b.start),
          Math.min(interval_a.end, interval_b.end)
        )
      );

    if (interval_a.end < interval_b.end) i++;
    else j++;
  }

  return result;
};

process.stdout.write("Intervals Intersection: ");
let result = merge(
  [new Interval(1, 3), new Interval(5, 6), new Interval(7, 9)],
  [new Interval(2, 3), new Interval(5, 7)]
);
for (i = 0; i < result.length; i++) {
  result[i].print_interval();
}
console.log();

process.stdout.write("Intervals Intersection: ");
result = merge(
  [new Interval(1, 3), new Interval(5, 7), new Interval(9, 12)],
  [new Interval(5, 10)]
);
for (i = 0; i < result.length; i++) {
  result[i].print_interval();
}
console.log();
