package com.nickmeeker.interview.Stacks;
import java.util.*;

/*
    The basic idea here is:
        for each token
            if the token is an operation
                operandOne = stack.pop()
                operandTwo = stack.pop()
                calculate intermediate result
                stack.push(intermediate result)
                continue
            else
                stack.push(token as integer)
                
        return stack.pop()

*/

class Solution {
  public int evalRPN(String[] tokens) {
      Stack<Integer> stack = new Stack<>();
      int operandOne, operandTwo, intermediate = 0, result = 0;
      for(String token : tokens) {
          // this might be an operation
          if(token.length() == 1) {
              char c = token.charAt(0);
              // check if it is
              if(c == '+' || c == '-' || c == '*' || c == '/') {
                  operandOne = stack.pop();
                  operandTwo = stack.pop();
                  switch(c) {
                      case '+':
                          intermediate = operandOne + operandTwo;
                          break;
                      case '-':
                          intermediate = operandTwo - operandOne;
                          break;
                      case '*':
                          intermediate = operandOne * operandTwo;
                          break;
                      case '/':
                          intermediate = operandTwo / operandOne;
                          break;
                      default:
                          break;
                  }
                  stack.push(intermediate);
                  continue;
              }
          }
          stack.push(Integer.parseInt(token));
      }
      result = stack.pop();
      return result;
  }
}