package com.nickmeeker.interview.RecursionDP;
import java.util.*;

class Solution {
  // goal is to generate all valid sets of parentheses using backtracking
  // this way, we don't have to generate all permutations and then validate each one
  
  // what is a valid set of parentheses:
      // one closing for each opening --> ()(), (())
      // numOpening can't exceed n
      // numClosing can't exceed numOpening --> ()) --> will never be valid
  
  
  // recursively generate each set of parentheses, but only ever allow numClosing to be <= numOpening
  
  // build the string by adding parentheses
  // there are only two choises -> ( or )
  
  // at each call, if i already have 2 parentheses, then i can only add 1 more
  // first recursion probably has to be ( since every string needs to start with (
  
  /*
      n = number of well-formed parentheses
      string = output string
      numOpening = number of opening parentheses
      numClosing = number of closing parentheses <= numOpening
      
      recurse(n, string, numOpening, numClosing)
          if(numOpening = numClosing = n)
              add string to list
              

          if(numOpening < n)
              recurse(n, string+"(", numOpening + 1, numClosing)

          if(numClosing < numOpening)
              recurse(n, string+")", numOpening, numClosing + 1)
          
      Running Time: O((4^n)/sqrt(n))
  */
  public List<String> generateParenthesis(int n) {
      ArrayList<String> output = new ArrayList<String>();
      recurse(n, output, "", 0, 0);
      return output;
  }
  
  public void recurse(int n, ArrayList<String> output, String string, int numOpening, int numClosing) {
      if(numOpening == numClosing && numClosing == n){
          output.add(string);
          return;
      }

      if(numOpening < n)
          recurse(n, output, string+"(", numOpening + 1, numClosing);
      if(numClosing < numOpening)
          recurse(n, output, string+")", numOpening, numClosing + 1);
  }
}