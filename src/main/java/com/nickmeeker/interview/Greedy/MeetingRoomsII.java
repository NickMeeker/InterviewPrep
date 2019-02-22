package com.nickmeeker.interview.Greedy;
import java.util.*;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */


/*
    Greedy Approach:
        Use PriorityQueues to track start/end times.
        Track number of rooms currently in use and number of rooms needed.
        
        For every start of meeting:
            1) increment number of rooms in use
            2) decrement it for every meeting that's finished
            3) if we're still using more rooms than we previously needed,
                it means we need to add another room (needed++).
*/

class Solution {
  public int minMeetingRooms(Interval[] intervals) {
      PriorityQueue<Integer> startTimes = new PriorityQueue<>();
      PriorityQueue<Integer> endTimes = new PriorityQueue<>();
      int needed = 0;
      int using = 0;
      for(Interval i : intervals) {
          startTimes.add(i.start);
          endTimes.add(i.end);
      }
      
      while(!startTimes.isEmpty() && !endTimes.isEmpty()) {
          int s = startTimes.poll();
          using++;
          while(!endTimes.isEmpty() && endTimes.peek() <= s) {
              endTimes.poll();
              using--;
          }
          if(using > needed) {
              needed++;
          }
      }
      return needed;
  }
}