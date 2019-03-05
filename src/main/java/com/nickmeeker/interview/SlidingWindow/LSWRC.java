class Solution {
  public int lengthOfLongestSubstring(String s) {
      int max = 0;
      HashMap<Character, Integer> map = new HashMap<>();
      
      int count = 0;
      int begin = 0, end = 0;
      while(end < s.length()) {
          char c = s.charAt(end);
          map.put(c, map.getOrDefault(c, 0) + 1);
          if(map.get(c) > 1)
              count++;
          end++;
          while(count > 0) {
              c = s.charAt(begin);
              if(map.get(c) > 1)
                  count--;
              map.put(c, map.get(c) - 1);
              begin++;
          }
          max = Math.max(max, end-begin);
      }
      return max;
  }
}