/*
    S = "heeellooo"
    words = ["hello", "hi", "helo"]
    
    
    I can only extend into groups of 3+, counting original letter
    
    "heeellooo"
         ^     
          ^     
    "hello"
       ^
        ^
         

    Two pointers on S, two pointers on words
    
    for each letter
        start with S
        advance bottom pointer until it hits a new letter -> this tells me how many
        of the current letter i need
        
        check word
        advance bottom pointer until it hits a new letter -> this tells me how many
        of the current letter i have
        
        if(have == need || (have > 0 && need >= 3))
            then this is good
            
        if the whole string is good, then increment output counter
*/

class Solution {
  public int expressiveWords(String S, String[] words) {
      int counter = 0;
      for(String word : words) {
          int stringPtr = 0, wordPtr = 0;
          boolean worked = true;
          while(stringPtr < S.length() || wordPtr < word.length()) {
              char c = S.charAt(stringPtr);
              int need = 0, have = 0;
              while(stringPtr < S.length() && S.charAt(stringPtr) == c) {
                  need++;
                  stringPtr++;
              }

              while(wordPtr < word.length() && word.charAt(wordPtr) == c) {
                  have++;
                  wordPtr++;
              }

              if(!(have == need || (have > 0 && need >= 3 && have <= need))) {
                  worked = false;
                  break;
              }   
          }
          if(worked)
              counter++;
      }
      return counter;
  }
}