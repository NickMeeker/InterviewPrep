/**
 * LC17. Letter Combinations of a Phone Number
 */

 /*
    at each recursive call, get the mapping as a string, iterate over the mapping,
    and build the string that way
    
    recurse(List<String> strings, digits, n, mappings, currentString, index) {
        if(index == digits.length() - 1)
            strings.add(currentString)
            
        String mapping = mappings[digits.charAt(index)-'0'-2];
        for(char c : mapping) {
            recurse(strings, digits, n, mappings, currentString+c, index+1);
        }
    }

*/

class Solution {
  public List<String> letterCombinations(String digits) {
      if(digits == null || digits.equals("")) return new ArrayList<>();
      List<String> strings = new ArrayList<>();
      int n = digits.length();
      String[] mappings = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
      recurse(strings, digits, n, mappings, "", 0);
      return strings;
  }
  
  void recurse(List<String> strings, String digits, 
               int n, String[] mappings, String currentString, int index) {
      if(index == n) {
          strings.add(currentString);
          return;
      }
      
      String mapping = mappings[digits.charAt(index)-'0'-2];
      for(char c : mapping.toCharArray()) {
          recurse(strings, digits, n, mappings, currentString+c, index+1);
      }
  }
}