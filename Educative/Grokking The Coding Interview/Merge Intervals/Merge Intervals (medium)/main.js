class Interval {
  constructor(start, end) {
    this.start = start;
    this.end = end;
  }

  get_interval() {
    return "[" + this.start + ", " + this.end + "]";
  }
}


const merge = function(intervals) {
  merged = []
  intervals.sort((a, b) => a.start - b.start);
  let currentInterval;
  for (let i = 0; i < intervals.length; i++) {
    currentInterval = currentInterval || intervals[i];
    const nextInterval = intervals[i + 1];
    if (nextInterval && currentInterval.end >= nextInterval.start) {
      const { start } = currentInterval.start <= nextInterval.start ? currentInterval : nextInterval;
      const { end } = currentInterval.end >= nextInterval.end ? currentInterval : nextInterval;
      currentInterval = new Interval(start, end);
    } else {
      merged.push(currentInterval);
      currentInterval = undefined;
    }
  }
  return merged;
};

merged_intervals = merge([new Interval(1, 4), new Interval(2, 5), new Interval(7, 9)]);
result = "";
for(i=0; i < merged_intervals.length; i++) {
  result += merged_intervals[i].get_interval() + " ";
}
console.log(`Merged intervals: ${result}`)


merged_intervals = merge([new Interval(6, 7), new Interval(2, 4), new Interval(5, 9)]);
result = "";
for(i=0; i < merged_intervals.length; i++) {
  result += merged_intervals[i].get_interval() + " ";
}
console.log(`Merged intervals: ${result}`)


merged_intervals = merge([new Interval(1, 4), new Interval(2, 6), new Interval(3, 5)]);
result = "";
for(i=0; i < merged_intervals.length; i++) {
  result += merged_intervals[i].get_interval() + " ";
}
console.log(`Merged intervals: ${result}`)
