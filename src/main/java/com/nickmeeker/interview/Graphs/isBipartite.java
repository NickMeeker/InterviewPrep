class Solution {
  public boolean isBipartite(int[][] graph) {
    if (graph.length == 0)
      return true;
    int n = graph.length;
    int[] colors = new int[n];
    Arrays.fill(colors, -1);

    for (int i = 0; i < n; i++) {
      if (colors[i] == -1) {
        colors[i] = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(i);

        while (!stack.isEmpty()) {
          int node = stack.pop();
          for (int adj : graph[node]) {
            if (colors[adj] == -1) {
              stack.push(adj);
              colors[adj] = colors[node] ^ 1;
            } else {
              if (colors[node] == colors[adj])
                return false;
            }
          }
        }
      }
    }
    return true;
  }
}