class Solution {
  public boolean isPalindrome(String s) {
    int start = 0, end = s.length() - 1;
    while (start < end) {
      while (start < end && !Character.isLetter(s.charAt(start)) && !Character.isDigit(s.charAt(start)))
        start++;
      while (end >= start && !Character.isLetter(s.charAt(end)) && !Character.isDigit(s.charAt(end)))
        end--;

      if (start >= end)
        break;

      char a = Character.toLowerCase(s.charAt(start));
      char b = Character.toLowerCase(s.charAt(end));

      if (a != b)
        return false;

      start++;
      end--;
    }

    return true;
  }
}