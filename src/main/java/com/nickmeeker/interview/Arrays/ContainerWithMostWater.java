package com.nickmeeker.interview.Arrays;

/*
    Basically a two pointer ad hoc problem.
    
    We have a left pointer and a right pointer.
    While they don't overlap (i.e., there's more points to look at),
    get the area at the current points (this is bounded by the shorter
    index, so min(leftHeight, rightHeight) * (right-left)). Then,
    if it's greater than maxarea, update max area. Move the pointer
    pointing at the shorter index inward, since it'll never be able
    to contribute to a bigger area. 
*/

class Solution {
  public int maxArea(int[] height) {
      int left = 0, right = height.length-1;
      int maxArea = 0;
      while(left < right) {
          int leftHeight = height[left], rightHeight = height[right];
          int area = Math.min(leftHeight, rightHeight) * (right-left);
          maxArea = Math.max(maxArea, area);
          if(height[left] < height[right])
              left++;
          else
              right--;
      }
      return maxArea;
  }
}