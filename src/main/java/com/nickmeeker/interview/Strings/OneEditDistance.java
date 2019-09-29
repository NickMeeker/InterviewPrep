/*
    iterate over the strings, check for each character
    if different:
        replace -> check if the substringd after that are the same
        delete/insert -> check if the substring of the shorter string after that
            is the same as the substring of the longer string from i+1

*/
class Solution {
  public boolean isOneEditDistance(String s, String t) {
    if (s.length() > t.length()) {
      String temp = s;
      s = t;
      t = temp;
    }

    int n = s.length(), m = t.length();

    if (Math.abs(n - m) > 1)
      return false;

    for (int i = 0; i < n; i++) {
      if (s.charAt(i) != t.charAt(i)) {
        // replace
        if (n == m) {
          return s.substring(i + 1).equals(t.substring(i + 1));
        } else {
          return s.substring(i).equals(t.substring(i + 1));
        }
      }
    }

    return m - n == 1;
  }
}