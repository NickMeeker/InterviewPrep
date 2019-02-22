package com.nickmeeker.interview.Heaps;
import java.util.*;



/**
 * Two Heaps!
 * 
 * minHeap --> stores the greater half of the stream
 * maxHeap --> stores the smaller half of the stream
 * 
 * Just balance the heaps as you add numbers, and then return the median as necessary
 * 
 */
class MedianFinder {
  int size;
  double median;
  PriorityQueue<Integer> minHeap;
  PriorityQueue<Integer> maxHeap;
  /** initialize your data structure here. */
  public MedianFinder() {
      this.size = 0;
      this.median = 0;
      this.minHeap = new PriorityQueue<>();
      this.maxHeap = new PriorityQueue<>(5, Collections.reverseOrder());
  }
  
  public void addNum(int num) {
      if(size == 0) {
          minHeap.add(num);
          median = num;
          size++;
      } else {
          if(num < minHeap.peek()) {
              maxHeap.add(num);
          } else {
              minHeap.add(num);
          }
          
          if(minHeap.size() > maxHeap.size() + 1) {
              maxHeap.add(minHeap.poll());
          }
          
          if(maxHeap.size() > minHeap.size() + 1) {
              minHeap.add(maxHeap.poll());
          }
      }
  }
  
  public double findMedian() {
      if(minHeap.size() > maxHeap.size()) {
          median = minHeap.peek();
      } else if(maxHeap.size() > minHeap.size()) {
          median = maxHeap.peek();
      } else {
          median = (minHeap.peek() + maxHeap.peek())/2.0;
      }
      return median;
  }
}

/**
* Your MedianFinder object will be instantiated and called as such:
* MedianFinder obj = new MedianFinder();
* obj.addNum(num);
* double param_2 = obj.findMedian();
*/