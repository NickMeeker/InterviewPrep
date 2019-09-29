/*
    
   it's like a recursive descent parser
*/

class Solution {
  int endIndex = -1;
  Stack<Integer> closeBracketIndex = new Stack<>();

  public String buildString(String s, int index, String soFar) {
    if (index >= s.length())
      return soFar;

    char c = s.charAt(index);
    // a number
    if (Character.isDigit(c)) {
      String numString = "";
      while (Character.isDigit(c)) {
        c = s.charAt(index);
        numString += c;
        if (Character.isDigit(s.charAt(index + 1))) {
          index++;
        } else {
          break;
        }
      }
      int num = Integer.parseInt(numString);
      index += 2;
      String toAppend = buildString(s, index, "");
      for (int i = 0; i < num; i++)
        soFar += toAppend;
      index = closeBracketIndex.pop() + 1;
      return buildString(s, index, soFar);
    }

    if (c == ']') {
      closeBracketIndex.push(index);
      return soFar;
    }

    soFar += c;
    return buildString(s, index + 1, soFar);
  }

  public String decodeString(String s) {
    return buildString(s, 0, "");
  }
}