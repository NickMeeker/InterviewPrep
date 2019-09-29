/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

/*
 * can just bfs the tree to get the answer map a col to its list of ints at each
 * iteration of the bfs, put the new node in the right list at the end, jsut
 * sort the lists (may not need to do this idk)
 * 
 */
class Solution {
  HashMap<Integer, List<Integer>> map = new HashMap<>();

  public List<List<Integer>> verticalOrder(TreeNode root) {
    if (root == null)
      return new ArrayList<>();

    int col = 0;
    bfs(root);

    ArrayList<Integer> columns = new ArrayList<>();
    List<List<Integer>> output = new ArrayList<>();

    for (int key : map.keySet()) {
      columns.add(key);
    }

    Collections.sort(columns);

    for (int column : columns)
      output.add(map.get(column));

    return output;
  }

  void bfs(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    Queue<Integer> columns = new LinkedList<>();
    int col = 0;
    queue.add(root);
    columns.add(col);
    while (!queue.isEmpty()) {
      root = queue.poll();
      col = columns.poll();

      if (!map.containsKey(col))
        map.put(col, new ArrayList<>());

      map.get(col).add(root.val);

      if (root.left != null) {
        queue.add(root.left);
        columns.add(col - 1);
      }

      if (root.right != null) {
        queue.add(root.right);
        columns.add(col + 1);
      }
    }
  }
}