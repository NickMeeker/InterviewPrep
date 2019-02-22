package com.nickmeeker.interview.Stacks;
import java.util.*;

/*
  The idea here is that there are really only 5 cases we need to consider:
    1) digit
      for this case, build the current number while we're still looking at a digit
      once we've finished parsing the digit, add it times the sign to our running total
    2) +
      set the sign to positive
    3) -
      set the sign to negative
    4) (
      push our current result and sign so we can store it for later
      reset result and sign --> it's like we're treating what's inside the parentheses as its own expression
      note we want to push result then sign
    5) )
      our current result is what's inside the parentheses. the stack is storing the result we were tracking
      before opening the parentheses. we want to add that current result (inside paren) times sign to the running result:
      result = result * stack.pop() + stack.pop() -> the first pop is the sign and the second pop is the old result
    

*/

class Solution {
  public int calculate(String s) {
      Stack<Integer> stack = new Stack<>();
      int result = 0, length = s.length(), sign = 1;
      for(int i = 0; i < length; i++) {
          if(Character.isDigit(s.charAt(i))) {
              int number = (int)s.charAt(i) - '0';
              while(i + 1 < length && Character.isDigit(s.charAt(i+1))) {
                  number = 10 * number + s.charAt(i + 1) - '0';
                  i++;
              }
              result += number * sign;
          } else if(s.charAt(i) == '+') {
              sign = 1;
          } else if(s.charAt(i) == '-') {
              sign = -1;
          } else if(s.charAt(i) == '(') {
              stack.push(result);
              stack.push(sign);
              result = 0; 
              sign = 1;
          } else if(s.charAt(i) == ')') {
              result = result * stack.pop() + stack.pop();
          }
      }
      return result;
  }
}