package com.nickmeeker.interview.Greedy;

/*
    Classic greedy algorithm. At each position, look for the position that
    lets you go the furthest. This is pretty obvious, since jumping to 
    each point that lets you go the furthest will also always include the 
    points that you could've reached by jumping to the other spots.
    
    [2,3,1,1,4] -> jump from 2 to 3
        we could've also jumped from 2->1, but that would only let us jump to the next 1:
            2->1->1->4
        notice that this path is also "covered" by jumping to 3:
            2->3->4
        So jumping to the point that lets you go furthest is always better
        
    Note we can't just always jump to the largest value:
        [10,9,8,7,6,5,4,3,2,1,1,0]
        
        If we always jump to the largest value, this will take 10 jumps.
        Jumping from 10->last 1->0 only takes 2 jumps. So, if we're looking
        at index i, we need to account for the total distance it lets us travel,
        i + nums[i], instead of just its value, nums[i].
*/


class Solution {
  public int jump(int[] nums) {
      if(nums.length == 1 || nums.length == 0) return 0;
      int left = 0;
      int right = nums[0];
      int jumps = 1;
      while(left <= right) {
          // we jumped at or over the edge
          if(right >= nums.length - 1)
              return jumps;
          
          // we want to find the max distance we can go from this position
          int max = Integer.MIN_VALUE;
          while(left <= right) {
              // try all the distances:
                  // we can jump anywhere is the range of left-right
                  // the "max" distance is the position in that range
                  // that lets us travel the furthest. that's why we 
                  // add the distance from current to that inded
                  // and the value at that index (left + nums[left])
              max = Math.max(max, left + nums[left]);
              left++;
          }
          
          // update our bounds:
          // left becomes the old right
          // right becomes the max
          left = right;
          right = max;
          jumps++;
      }
      // we actually shouldn't ever make it here
      return -1;
  }
}