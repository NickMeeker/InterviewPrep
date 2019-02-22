package com.nickmeeker.interview.Heaps;
import java.util.*;

/**
 * The basic idea here is to use a heap to track the highest priority remaining tasks. 
 * First put the frequency of all tasks into the heap.
 * While the heap still has elements, we want to iterate over one full period (inclusive).
 * This is what 'i' is used for. Iterating over the heap, we poll the top value, decrement it (indicating we've processed one task)
 * and then add it to a temporary list. Total time elapsed gets incrememnted. If the heap and temp list aren't empty (i.e., we aren't done),
 * then re-heapify the list elements and repeat till done. 
 */

class Solution {
  public int leastInterval(char[] tasks, int n) {
      PriorityQueue<Integer> heap = new PriorityQueue<Integer>(26, Collections.reverseOrder());
      HashMap<Character, Integer> freq = new HashMap<>();
      for(char c : tasks)
          freq.put(c, freq.getOrDefault(c, 0) + 1);
      
      for(char key : freq.keySet()) 
          heap.add(freq.get(key));
      
      
      int timeElapsed = 0;
      while(!heap.isEmpty()) {
          int i = 0;
          ArrayList<Integer> temp = new ArrayList<>();
          while(i <= n) {
              if(!heap.isEmpty()) {
                  int t = heap.poll();
                  t--;
                  if(t > 0)
                      temp.add(t);
              }
              timeElapsed++;
              if(heap.isEmpty() && temp.size() == 0)
                  break;
              i++;
          }
          for(int t : temp) {
              heap.add(t);
          }
      }
     
      return timeElapsed;
  }
  
}