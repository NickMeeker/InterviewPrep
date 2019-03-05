/*
    Follows the sliding window template.

*/

class Solution {
  public String minWindow(String s, String t) {
      if(s.equals("") || t.equals("")) return "";
      if(s.equals(t)) return s;
      int resEnd = s.length()+1, resStart = -1;
      HashMap<Character, Integer> map = new HashMap<Character, Integer>();
      for(char c: t.toCharArray())
          map.put(c, map.getOrDefault(c, 0) + 1);
      
      int count = map.size();
      int begin = 0, end = 0, length = Integer.MAX_VALUE;
      while(end < s.length()) {
          char c = s.charAt(end);
          if(map.containsKey(c)) {
              map.put(c, map.get(c) - 1);
              if(map.get(c) == 0) {
                  count--;
              }
          }
          end++;
          while(count == 0) {
              c = s.charAt(begin);
              if(map.containsKey(c)) {
                  map.put(c, map.get(c) + 1);
                  if(map.get(c) > 0)
                      count++;
              }
              if(resEnd - resStart > end - begin) {
                  resEnd = end;
                  resStart = begin;
              }
              begin++;
          }
      }
      if(resEnd==s.length() + 1) return "";
      else return s.substring(resStart, resEnd);
  }
}