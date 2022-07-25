const { MinPriorityQueue } = require("@datastructures-js/priority-queue");

function minMeetingRooms(intervals) {
  const sortedIntervals = intervals.sort((a, b) => a[0] - b[0]);
  const priorityQueue = new MinPriorityQueue();

  for (let i = 0; i < intervals.length; i++) {
    const [startTime, endTime] = intervals[i];
    if (priorityQueue.size() > 0 && priorityQueue.front().element <= startTime)
      priorityQueue.dequeue();
    priorityQueue.enqueue(endTime);
  }

  return priorityQueue.size();
}
