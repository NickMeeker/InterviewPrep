// a string of length one is a palindrome

class Solution {
  public String longestPalindrome(String s) {
      if(s == null || s.equals("")) return "";
      String lps = "";
      boolean[][] dp = new boolean[s.length()][s.length()];
      int maxLen = 1;
      lps = s.substring(0, 1);
      for(int i = 0; i < s.length(); i++) {
          dp[i][i] = true;
      }
      if(s.length() == 1) return s;
      for(int i = 0; i < s.length()-1; i++) {
          if(s.charAt(i) == s.charAt(i+1)) {
              maxLen = 2;
              lps = s.substring(i, i+2);
              dp[i][i+1] = true;
          }
      }
      
      for(int k = 2; k < s.length(); k++) {
          for(int i = 0; i < s.length()-k; i++) {
              int j = i + k;
              int length = 0;
              if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
                  dp[i][j] = true;
                  length = s.substring(i, j+1).length();
                  if(length > maxLen) {
                      maxLen = length;
                      lps = s.substring(i, j+1);
                  }
              } 
          }
      }
      return lps;
  }

}