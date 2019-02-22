package com.nickmeeker.interview.Queues;
import java.util.*;

/*
  Not much to this one. Keep a queue of elements. If we add and element, check if the queue is too big.
  If it is, poll the first value and subtract it from the sum. Then just update the average.
*/

class MovingAverage {
  int size;
  int sum;
  double avg;
  Queue<Integer> queue;
  /** Initialize your data structure here. */
  public MovingAverage(int size) {
      this.size = size;
      this.sum = 0;
      this.avg = 0.0;
      queue = new LinkedList<>();
  }
  
  public double next(int val) {
      queue.add(val);
      if(queue.size() > this.size){
          int out = queue.poll();
          sum -= out;
      }
      sum += val;
      avg = (double)sum/queue.size();
      return avg;
  }
}

/**
* Your MovingAverage object will be instantiated and called as such:
* MovingAverage obj = new MovingAverage(size);
* double param_1 = obj.next(val);
*/