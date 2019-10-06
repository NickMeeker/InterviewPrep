/*
    "cbaebabacd"
        ^
      ^
    "abc"
    
    freq: [
        "a": 1
        "b": 0
        "c": 0
    ]
    
    count starts at 0, ++ everytime a letter freq hits 0
    when count is 0 i found a anagram
    move the s ptr till it's not a anagram anymore  
    also move s ptr when the word is too big to be an anagram

*/

class Solution {
  public List<Integer> findAnagrams(String s, String p) {
    HashMap<Character, Integer> freq = new HashMap<>();
    List<Integer> ans = new ArrayList<>();
    int start = 0, end = 0, count = 0, lengthSoFar = 0, n = s.length();

    for (char c : p.toCharArray()) {
      freq.putIfAbsent(c, 0);
      freq.put(c, freq.get(c) + 1);
    }

    count = freq.size();

    while (end < n) {
      char c = s.charAt(end);
      if (freq.containsKey(c)) {
        freq.put(c, freq.get(c) - 1);
        if (freq.get(c) == 0) {
          count--;
        }
      }
      end++;
      lengthSoFar++;
      while (count == 0) {
        if (lengthSoFar == p.length()) {
          ans.add(start);
        }
        c = s.charAt(start);
        if (freq.containsKey(c)) {
          freq.put(c, freq.get(c) + 1);
          if (freq.get(c) > 0)
            count++;
        }
        start++;
        lengthSoFar--;
      }
    }

    return ans;
  }
}