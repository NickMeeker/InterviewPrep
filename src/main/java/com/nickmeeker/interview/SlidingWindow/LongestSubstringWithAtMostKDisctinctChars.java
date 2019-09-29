class Solution {
  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    if (s == null || s.length() == 0 || (k == 0 && s.length() > 0))
      return 0;
    HashMap<Character, Integer> freq = new HashMap<>();
    int n = s.length();
    int count = 0, start = 0, end = 0, max = 0;

    while (end < n) {
      char c = s.charAt(end);
      freq.putIfAbsent(c, 0);
      int f = freq.get(c);
      // increment freq
      freq.put(c, freq.get(c) + 1);
      // if freq was 0 and is no longer, then i have a new char in substring
      if (f == 0) {
        count++;
      }

      // i just added too many characters - need to move left ptr
      while (start <= end && count > k) {
        // move left ptr and decrement count as needed
        c = s.charAt(start);
        freq.put(c, freq.get(c) - 1);
        // freq was > 0, and now is not - we removed a character
        if (freq.get(c) == 0)
          count--;

        start++;
      }

      if (count <= k) {
        max = Math.max(end - start + 1, max);
      }
      end++;
    }
    return max;
  }
}