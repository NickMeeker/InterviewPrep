/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

/*
 * map each node back to its parents, then bfs the tree like a graph. each node
 * we visit will be one further away from the target
 * 
 * 
 */

class Solution {
  HashMap<TreeNode, TreeNode> parents = new HashMap<>();

  void getParents(TreeNode root, TreeNode prev) {
    if (root == null)
      return;

    if (prev != null) {
      parents.put(root, prev);
    }

    getParents(root.left, root);
    getParents(root.right, root);
  }

  public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
    getParents(root, null);
    Queue<TreeNode> queue = new LinkedList<>();
    HashMap<TreeNode, Integer> distanceFromTarget = new HashMap<>();
    HashSet<TreeNode> visited = new HashSet<>();
    List<Integer> output = new ArrayList<>();
    int distance = 0;

    queue.add(target);
    visited.add(target);
    distanceFromTarget.put(target, 0);
    while (!queue.isEmpty()) {
      TreeNode s = queue.poll();
      if (distanceFromTarget.containsKey(s)) {
        if (distanceFromTarget.get(s) == K) {
          output.add(s.val);
        }
      }

      // left
      if (s.left != null && !visited.contains(s.left)) {
        queue.add(s.left);
        visited.add(s.left);
        distanceFromTarget.put(s.left, distanceFromTarget.get(s) + 1);
      }
      // right
      if (s.right != null && !visited.contains(s.right)) {
        queue.add(s.right);
        visited.add(s.right);
        distanceFromTarget.put(s.right, distanceFromTarget.get(s) + 1);
      }
      // up
      if (parents.containsKey(s) && !visited.contains(parents.get(s))) {
        queue.add(parents.get(s));
        visited.add(parents.get(s));
        distanceFromTarget.put(parents.get(s), distanceFromTarget.get(s) + 1);
      }
    }

    return output;
  }
}