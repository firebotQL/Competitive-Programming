var Heap = require("./collections/heap");

class SlidingWindowMedian {
  constructor() {
    this.minHeap = new Heap([], null, (a, b) => b - a);
    this.maxHeap = new Heap([], null, (a, b) => a - b);
  }

  rebalance_heaps() {
    if (this.maxHeap.length > this.minHeap.length + 1) {
      this.minHeap.push(this.maxHeap.pop());
    } else if (this.maxHeap.length < this.minHeap.length) {
      this.maxHeap.push(this.minHeap.pop());
    }
  }

  insert_num(num) {
    if (this.maxHeap.length === 0 || this.maxHeap.peek() >= num) {
      this.maxHeap.push(num);
    } else {
      this.minHeap.push(num);
    }

    this.rebalance_heaps();
  }

  remove_num(num) {
    if (num <= this.maxHeap.peek()) {
      this.maxHeap.delete(num);
    } else {
      this.minHeap.delete(num);
    }

    this.rebalance_heaps();
  }

  get_median() {
    if (this.maxHeap.length === this.minHeap.length) {
      return this.maxHeap.peek() / 2.0 + this.minHeap.peek() / 2.0;
    } else {
      return this.maxHeap.peek();
    }
  }

  find_sliding_window_median(nums, k) {
    result = [];
    for (let i = 0; i < nums.length; i++) {
      this.insert_num(nums[i]);

      if (i - k + 1 >= 0) {
        result.push(this.get_median());
        const firstNumberFromTheWindow = nums[i - k + 1];
        this.remove_num(firstNumberFromTheWindow);
      }
    }
    return result;
  }
}

var slidingWindowMedian = new SlidingWindowMedian();
result = slidingWindowMedian.find_sliding_window_median([1, 2, -1, 3, 5], 2);

console.log(`Sliding window medians are: ${result}`);

slidingWindowMedian = new SlidingWindowMedian();
result = slidingWindowMedian.find_sliding_window_median([1, 2, -1, 3, 5], 3);
console.log(`Sliding window medians are: ${result}`);
