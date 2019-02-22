package com.nickmeeker.interview.Stacks;
import java.util.*;

/*
    The idea here is a bit complicated. 
    
    As we iterate over the array, we want to push the indeces to a stack.
    Then, while the stack isn't empty and current height > height at the top of the stack:
        get the index of the top of the stack, popping it
        break if empty stack (there's nothing smaller than this, like we're all the way
            to the left)
        get the distance from the current element to the element on top of the stack
        get the bound, the min of height[current] and height[top of stack] - the previous top
        add distance * bound to running total
    push current to stack and increment it
    
    the whole region "fills up" from left to right, and then each "subregion"
    fills from bottom to top

*/

class Solution {
  public int trap(int[] height) {
      Stack<Integer> stack = new Stack<>();
      int total = 0, current = 0;
      while(current < height.length) {
          while(!stack.isEmpty() && height[current] > height[stack.peek()]) {
              int top = stack.pop();
              if(stack.isEmpty())
                  break;
              int distance = current - stack.peek() - 1;
              int bound = Math.min(height[current], height[stack.peek()]) - height[top];
              total += distance * bound;
          }
          stack.push(current);
          current++;
      }
      return total;
  }
}