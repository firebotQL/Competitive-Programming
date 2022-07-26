const { MinPriorityQueue } = require("@datastructures-js/priority-queue");

class Job {
  constructor(start, end, cpu_load) {
    this.start = start;
    this.end = end;
    this.cpu_load = cpu_load;
  }
}

// O(N*logN) <-- while sorting and also while iterating through N jobs dequeing/peeking operation takes O(logN) so overall runtime is O(NlogN)
// O(N) <-- space complexity for sorting and also if we fully utilise the queue 2*N
const find_max_cpu_load = function (jobs) {
  jobs.sort((a, b) => a.start - b.start);

  const queue = new MinPriorityQueue((job) => job.end);

  let maxCPULoad = 0,
    currentCPULoad = 0;
  for (let i = 0; i < jobs.length; i++) {
    const job = jobs[i];
    while (queue.size() > 0 && queue.front().end <= job.start) {
      currentCPULoad -= queue.dequeue().cpu_load;
    }
    queue.enqueue(job);
    currentCPULoad += job.cpu_load;
    maxCPULoad = Math.max(maxCPULoad, currentCPULoad);
  }

  return maxCPULoad;
};

console.log(
  `Maximum CPU load at any time: ${find_max_cpu_load([
    new Job(1, 4, 3),
    new Job(2, 5, 4),
    new Job(7, 9, 6),
  ])}`
);
console.log(
  `Maximum CPU load at any time: ${find_max_cpu_load([
    new Job(6, 7, 10),
    new Job(2, 4, 11),
    new Job(8, 12, 15),
  ])}`
);
console.log(
  `"Maximum CPU load at any time: ${find_max_cpu_load([
    new Job(1, 4, 2),
    new Job(2, 4, 1),
    new Job(3, 6, 5),
  ])}`
);
