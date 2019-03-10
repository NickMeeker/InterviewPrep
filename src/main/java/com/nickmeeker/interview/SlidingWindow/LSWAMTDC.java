class Solution {
  public int lengthOfLongestSubstringTwoDistinct(String s) {
      int n = s.length();
      int start = 0, end = 0, max = 0, count = 0;
      if(n == 0 || n == 1) return n;
      HashMap<Character, Integer> map = new HashMap<>();
      while(end < n) {
          char c = s.charAt(end);
          map.put(c, map.getOrDefault(c, 0) + 1);
          if(map.get(c) == 1)
              count++;
          end++;
          
          while (count > 2) {
              c = s.charAt(start);
              map.put(c, map.get(c) - 1);
              if(map.get(c) == 0) {
                  count--;
              }
              start++;
          }    
          max = Math.max(max, end - start);
      }
      return max;
  }
}