class Solution {
  public boolean checkSkipLetter(String s, int start, int end) {
    while (start < end) {
      if (start >= end)
        break;

      char a = s.charAt(start);
      char b = s.charAt(end);

      if (a != b)
        return false;

      start++;
      end--;
    }

    return true;
  }

  public boolean validPalindrome(String s) {
    int start = 0, end = s.length() - 1;
    while (start < end) {
      if (start >= end)
        break;

      char a = s.charAt(start);
      char b = s.charAt(end);

      if (a != b)
        return checkSkipLetter(s, start + 1, end) || checkSkipLetter(s, start, end - 1);

      start++;
      end--;
    }

    return true;
  }
}