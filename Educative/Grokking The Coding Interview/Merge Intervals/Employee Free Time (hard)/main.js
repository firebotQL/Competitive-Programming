const { MinPriorityQueue } = require("@datastructures-js/priority-queue");

class Interval {
  constructor(start, end) {
    this.start = start;
    this.end = end;
  }

  get_interval() {
    return "[" + this.start + ", " + this.end + "]";
  }
}

const find_employee_free_time = function (schedule) {
  const schedules = schedule
    .reduce((workingHours, currentEmployeeSchedule) => {
      workingHours.push(...currentEmployeeSchedule);
      return workingHours;
    }, [])
    .sort((a, b) => a.start - b.start);
  const result = [];
  const queue = new MinPriorityQueue((schedule) => schedule.start);
  for (let i = 0; i < schedules.length; i++) {
    const schedule = schedules[i];
    let lastSchedule = undefined;
    while (queue.size() > 0 && queue.front().end <= schedule.start) {
      lastSchedule = queue.dequeue();
    }

    if (lastSchedule && lastSchedule.end !== schedule.start) {
      result.push(new Interval(lastSchedule.end, schedule.start));
    }
    queue.push(schedule);
  }
  return result;
};

let input = [
  [new Interval(1, 3), new Interval(5, 6)],
  [new Interval(2, 3), new Interval(6, 8)],
];
let intervals = find_employee_free_time(input);
let result = "Free intervals: ";
for (let i = 0; i < intervals.length; i++)
  result += intervals[i].get_interval();
console.log(result);

input = [
  [new Interval(1, 3), new Interval(9, 12)],
  [new Interval(2, 4)],
  [new Interval(6, 8)],
];
intervals = find_employee_free_time(input);
result = "Free intervals: ";
for (let i = 0; i < intervals.length; i++)
  result += intervals[i].get_interval();
console.log(result);

input = [
  [new Interval(1, 3)],
  [new Interval(2, 4)],
  [new Interval(3, 5), new Interval(7, 9)],
];
intervals = find_employee_free_time(input);
result = "Free intervals: ";
for (let i = 0; i < intervals.length; i++)
  result += intervals[i].get_interval();
console.log(result);
