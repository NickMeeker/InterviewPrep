class Solution {
  public String simplifyPath(String path) {
    Stack<String> stack = new Stack<>();

    String[] ar = path.split("/");
    for (String s : ar) {
      if (s.length() == 0) {
        continue;
      }
      // .
      if (s.equals(".")) {
        continue;
      }
      // ..
      if (s.equals("..")) {
        if (!stack.isEmpty()) {
          stack.pop();
        }
        continue;
      }

      stack.push(s);
    }

    Collections.reverse(stack);

    StringBuilder output = new StringBuilder();
    output.append("/");
    while (!stack.isEmpty()) {
      output.append(stack.pop());
      output.append("/");
    }
    return output.length() > 1 ? output.substring(0, output.length() - 1) : output.toString();
  }
}