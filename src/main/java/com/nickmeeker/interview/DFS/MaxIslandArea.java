/*
    Idea is the DFS out from every node in the grid, and "flip" all island
    points from 1 to 0, returning number of flipped points. 
    
    
    1 1 0     0 0 0
    0 1 0 --> 0 0 0 --> return 3
    0 0 1     0 0 1
*/

class Solution {
  public int maxAreaOfIsland(int[][] grid) {
      if(grid.length == 0) return 0;
      if(grid[0].length == 0) return 0;
      
      int n = grid.length, m = grid[0].length;
      int max = 0;
      for(int i = 0; i < n; i++) {
          for(int j = 0; j < m; j++) {
              max = Math.max(max, dfs(grid, n, m, i, j));
          }
      }
      return max;
  }
  
  int dfs(int[][] grid, int n, int m, int r, int c) {
      if(r >= n || r < 0 || c >= m || c < 0 || grid[r][c] == 0)
          return 0;
      
      grid[r][c] = 0;
      return 1 + dfs(grid, n, m, r + 1, c) +
          dfs(grid, n, m, r - 1, c) + 
          dfs(grid, n, m, r, c + 1) + 
          dfs(grid, n, m, r, c - 1);
  }
}