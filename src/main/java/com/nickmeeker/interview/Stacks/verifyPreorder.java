package com.nickmeeker.interview.Stacks;
import java.util.*;

/*
    It's helpful here to remember that each leaf node of a BST must have two null pointers. 
    The idea is to check if a leaf node is valid (i.e., has two null pointers), and, if it 
    is, mark it itself as null. Then, we can check if its parent has two null pointers (because
    its two children were marked null), and, if it is, mark it as null. Do this for the whole tree:
    
                1                       1                     #
               / \                     / \
              /   \                   /   \
             2     3        -->      #     #        --> 
            / \   / \
           #   # #   #

    We can do this with a stack:
        for each element
            if its a #
                while(the stack isn't empty && the top element == #)
                    pop
                    if(empty) return false // we broke the stack
                    pop
            push(element)
            
        return stack size == 1 && top element == #
*/

class Solution {
  public boolean isValidSerialization(String preorder) {
      Stack<String> stack = new Stack<>();
      String[] strings = preorder.split(",");
      for(String string : strings) {
          if(string.equals("#")) {
              while(!stack.isEmpty() && stack.peek().equals("#")) {
                  stack.pop();
                  if(stack.isEmpty()) return false;
                  stack.pop();
              }
          } 
          stack.push(string);
      }
      return stack.size() == 1 && stack.peek().equals("#");
  }
}
                     