/*
    word1 = "horse"
    word2 = "ros"
    
    _____________________
    | E | 5 | 4 | 4 | 3 |
    |---|---|---|---|---|         Basic idea is to build this table up in a bottom-up manner.
    | S | 4 | 3 | 3 | 2 |         We know the available operations are:
    |---|---|---|---|---|           1) Removal, represented by going left (i-1)
    | R | 3 | 2 | 2 | 2 |           2) Insertion, represented by going down (j-1)
    |---|---|---|---|---|           3) And replacement, represented by going down/left (i-1)(j-1)
    | O | 2 | 2 | 1 | 2 |        
    |---|---|---|---|---|         Basically, we use the min cost for the subproblems in the table
    | H | 1 | 1 | 2 | 3 |           and add 1, unless we're looking at replacement and the 
    |---|---|---|---|---|           characters are the same (since this operation is "free")
    | # | 0 | 1 | 2 | 3 |
    |---|---|---|---|---|         The base cases are the empty strings.
    |   | # | R | O | S |
    |---|---|---|---|---|


*/

class Solution {
  public int minDistance(String word1, String word2) {
      int[][] dp = new int[word1.length()+1][word2.length()+1];
      int n = word1.length(), m = word2.length();
      if(n == 0)
          return m;
      if(m == 0)
          return n;
      
      // base case 1: edit distance from "" to word1
      for(int i = 0; i <= n; i++) {
          dp[i][0] = i;
      }
      
      // edit distance from "" to word2
      for(int j = 0; j <= m; j++) {
          dp[0][j] = j;
      }
      
      for(int i = 1; i <= n; i++) {
          for(int j = 1; j <= m; j++) {
              int remove = dp[i-1][j] + 1;
              int insert = dp[i][j-1] + 1;
              int replace = dp[i-1][j-1];
              if(word1.charAt(i-1) != word2.charAt(j-1))
                  replace++;
              dp[i][j] = Math.min(remove, Math.min(insert, replace));
          }
      }
      
      return dp[n][m];
  }
  
}