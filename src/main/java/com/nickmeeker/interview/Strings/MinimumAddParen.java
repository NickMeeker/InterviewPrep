class Solution {
  public int minAddToMakeValid(String S) {
    int parenLeftOpen = 0;
    int total = 0;
    for (char c : S.toCharArray()) {
      if (c == '(') {
        parenLeftOpen++;
      }
      if (c == ')') {
        if (parenLeftOpen > 0) {
          parenLeftOpen--;
        } else {
          total++;
        }
      }
    }

    return total += parenLeftOpen;
  }
}