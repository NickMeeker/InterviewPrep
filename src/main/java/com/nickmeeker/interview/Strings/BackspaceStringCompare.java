/*
    S = "ab#c", T = "ad#c"
    
    Since I'm literally typing this into a keyboard, "simulate" typing by building a string
    
    s, t

    s = "a"
    s = s.substring(0, s.length() - 1);
    "ab#c"
        ^

    1) iterate over s, doing ^
    2) iterate over t, doing ^
    3) return s.equals(t)
    
    Time: O(n)
    Space: O(n)
*/


class Solution {
  /*
      ab#c     ad#c
      
      s=ac
      t=ac
  */
  public boolean backspaceCompare(String S, String T) {
      if(S == null || T == null) return false;
      String s = "", t = "";
      
      for(char c : S.toCharArray()) {
          if(c != '#')
              s += c;
          else
              if(s.length() > 0)
                  s = s.substring(0, s.length() - 1);
      }
      
      for(char c : T.toCharArray()) {
          if(c != '#')
              t += c;
          else
              if(t.length() > 0)
                  t = t.substring(0, t.length() - 1);
      }
      
      return s.equals(t);
  }
}