/*
     s = "leetcode"
     wordDict = ["leet", "code"]
     
     s = "applepenapple"
     wordDict = ["apple", "pen"]
     
     
     Boolean dp[s.length()+1] --> dp[s.length()] -> answer
     dp[0] --> "" = True
     
     every index in dp represents the word being broken up at that index
     dp[1] = l--> false
     dp[2] = le -> F
     dp[3] = lee -> F
     dp[4] = leet -> T
     dp[5] = leetc -> F
     dp[6] = leetco -> F
     dp[7] = leetcod -> F
     dp[8] = leetcode -> T
     
     "leet", "code"
     
     at each iteration, start checking backwards 
     if (dp[j] is true && s.substring(j,i) is in dictionary)
        then dp[i] = true
    else
        dp[i] = false
     
     for(int i = 1; i <= s.length(); i++) {
        for(int j = i; j >= 0; j--) {
        
        }
     }
     O(n^2)

*/

class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {
      HashSet<String> dictionary = new HashSet<>(wordDict);
      boolean[] dp = new boolean[s.length() + 1];
      dp[0] = true;
      /*
          leetcode
              
          dp[0] = t
          dp[1] = f
          dp[2] = f
          dp[3] = f
          dp[4] = t
          dp[5] = f
          dp[6] = f
          dp[7] = f
          dp[8] = 
      */
      for(int i = 1; i <= s.length(); i++) {
          for(int j = i; j >= 0; j--) {
              if(dp[j] && dictionary.contains(s.substring(j, i)))
                  dp[i] = true;
          }
      }
      return dp[s.length()];
  }
//     public boolean wordBreak(String s, List<String> wordDict) {
//         HashSet<String> dictionary = new HashSet<>();
//         for(String word : wordDict)
//             dictionary.add(word);
      
//         return recurse(s, dictionary, 0, new Boolean[s.length()]);
//     }
  
//     boolean recurse(String s, HashSet<String> dictionary, int start, Boolean[] dp) {
//         if(start == s.length())
//             return true;
      
//         if(dp[start] != null) 
//             return dp[start];
      
//         for(int i = start+1; i <= s.length(); i++) {
//             if(dictionary.contains(s.substring(start, i)) && recurse(s, dictionary, i, dp)) {
//                 dp[start] = true;
//                 return true;
//             }
//         }
//         dp[start] = false;
//         return false;
//     }
}