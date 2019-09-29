class Solution {
  HashMap<Integer, Set<String>> strings = new HashMap<>();

  boolean isValidString(StringBuilder input, int n) {
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < n; i++) {
      char c = input.charAt(i);

      if (c == '(') {
        stack.push(1);
      } else {
        if (c != ')')
          continue;
        if (stack.isEmpty())
          return false;
        stack.pop();
      }
    }
    return stack.isEmpty();
  }

  void recurse(StringBuilder string, int n, int index) {
    // handle validating this string here
    if (isValidString(string, n)) {
      if (!strings.containsKey(n)) {
        strings.put(n, new HashSet<>());
      }
      strings.get(n).add(string.toString());
    }

    if (index == n) {
      return;
    }

    recurse(string, n, index + 1);
    // remove current char if it's a paren
    if (string.charAt(index) == '(' || string.charAt(index) == ')') {
      StringBuilder copyString = new StringBuilder(string);
      copyString.delete(index, index + 1);
      recurse(copyString, copyString.length(), index);
    }

  }

  public List<String> removeInvalidParentheses(String s) {
    int n = s.length();
    StringBuilder string = new StringBuilder(s);
    recurse(string, n, 0);

    int max = Integer.MIN_VALUE;
    for (int key : strings.keySet()) {
      max = Math.max(max, key);
    }

    List<String> answer = new ArrayList<>();
    // no solution - we need to remove all paren
    if (max == Integer.MIN_VALUE) {
      StringBuilder out = new StringBuilder();
      for (int i = 0; i < n; i++) {
        if (string.charAt(i) != '(' && string.charAt(i) != ')')
          out.append(string.charAt(i));
      }
      answer.add(out.toString());
      return answer;
    }

    for (String str : strings.get(max)) {
      answer.add(str);
    }
    return answer;
  }
}