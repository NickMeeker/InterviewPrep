package com.nickmeeker.interview.Stacks;
import java.util.*;

class ValidParentheses {
  public boolean isValid(String s) {
      Stack<Character> stack = new Stack<>();
      for(char c : s.toCharArray()) {
          if(c == '(' || c == '{' || c == '[') {
              stack.push(c);
              continue;
          } else if(c == ')') {
              if(!stack.isEmpty() && stack.pop() == '(') continue;
              else return false;
          } else if(c == '}') {
              if(!stack.isEmpty() && stack.pop() == '{') continue;
              else return false;
          } else if(c == ']'){
              if(!stack.isEmpty() && stack.pop() == '[') continue;
              else return false;
          } else
              return false;
      }
      
      return stack.isEmpty();
  }
}