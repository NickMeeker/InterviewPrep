class Solution {
  static class Point {
    int r;
    int c;

    Point(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }

  public int numDistinctIslands(int[][] grid) {
    HashSet<String> islands = new HashSet<>();
    int n = grid.length, m = grid[0].length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 1) {
          // dfs from here
          Stack<Point> stack = new Stack<>();
          StringBuilder path = new StringBuilder();
          path.append("s");
          Point p = new Point(i, j);
          stack.push(p);

          while (!stack.isEmpty()) {
            p = stack.pop();
            grid[p.r][p.c] = 0;
            // up
            if (p.r > 0 && grid[p.r - 1][p.c] != 0) {
              stack.push(new Point(p.r - 1, p.c));
              path.append("u");
            }
            // down
            if (p.r < n - 1 && grid[p.r + 1][p.c] != 0) {
              stack.push(new Point(p.r + 1, p.c));
              path.append("d");
            }
            // left
            if (p.c > 0 && grid[p.r][p.c - 1] != 0) {
              stack.push(new Point(p.r, p.c - 1));
              path.append("l");
            }
            // right
            if (p.c < m - 1 && grid[p.r][p.c + 1] != 0) {
              stack.push(new Point(p.r, p.c + 1));
              path.append("r");
            }
            path.append("t");
          }
          islands.add(path.toString());
        }

      }
    }
    return islands.size();
  }
}