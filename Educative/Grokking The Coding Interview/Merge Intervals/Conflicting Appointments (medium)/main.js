class Interval {
  constructor(start, end) {
    this.start = start;
    this.end = end;
  }

  print_interval() {
    process.stdout.write(`[${this.start}, ${this.end}]`);
  }
}

const can_attend_all_appointments = function (intervals) {
  const sorted_intervals = intervals.sort((a, b) => a.start - b.start);
  for (let i = 0; i < sorted_intervals.length - 1; i++) {
    const left_interval = sorted_intervals[i];
    const right_interval = sorted_intervals[i + 1];
    const overlapping = intervals[i].end > intervals[i + 1].start;
    if (overlapping) return false;
  }
  return true;
};

console.log(
  `Can attend all appointments: ${can_attend_all_appointments([
    new Interval(1, 4),
    new Interval(2, 5),
    new Interval(7, 9),
  ])}`
);

console.log(
  `Can attend all appointments: ${can_attend_all_appointments([
    new Interval(6, 7),
    new Interval(2, 4),
    new Interval(8, 12),
  ])}`
);

console.log(
  `Can attend all appointments: ${can_attend_all_appointments([
    new Interval(4, 5),
    new Interval(2, 3),
    new Interval(3, 6),
  ])}`
);
