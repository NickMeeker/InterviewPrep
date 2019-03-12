/*
    String secret, String guess
    "bAcB" --> b = bulls, c = cows
    
    
    1807
    7810
    
    1) iterate over the guess and secret, and check for bulls
        8 --> is a bull
    2) iterate again and check for cows
        7 -> cow 
        8 -> cow --> recognize that i've already marked this as a bull
        1 -> cow
        0 -> cow
        
    1123
    0111
        
    bulls:
        1 --> bull
        1 -> cow
        
    array of size 10 (0-9) to "map" digits to freq in secret
    
    What I need:
        some way to mark bulls
            use array of booleans --> if guess[i] is a bull, then bulls[i] = true
        some way to not "overcount" cows
            every time something is marked as bull or cow, then i can just decrement this
            if the freq is 0, then i don't add to my cow count
            
            
    Time: O(n)
    Space: O(n)
*/


class Solution {
  public String getHint(String secret, String guess) {
      int[] freqs = new int[10];
      boolean[] bulls = new boolean[secret.length()];
      int bullsCount = 0, cowsCount = 0;
      // map the frequency
      for(char c : secret.toCharArray()) {
          freqs[(int)c-'0']++;
      }
      
      // mark bulls
      for(int i = 0; i < secret.length(); i++) {
          char s = secret.charAt(i);
          char g = guess.charAt(i);
          if(s == g) {
              bulls[i] = true;
              freqs[(int)s-'0']--;
              bullsCount++;
          }
      }
      
      // mark cows
      for(int i = 0; i < guess.length(); i++) {
          char g = guess.charAt(i);
          if(freqs[(int)g-'0'] > 0 && !bulls[i]) {
              freqs[(int)g-'0']--;
              cowsCount++;
          }
      }
      
      return ("" + bullsCount + "A" + cowsCount + "B");
  }
}