/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  long closest;

  void solve(TreeNode root, double target) {
    if (root == null) {
      return;
    }

    if (Math.abs(root.val - target) < Math.abs(closest - target)) {
      closest = root.val;
    }

    if (root.val > target) {
      solve(root.left, target);
    } else {
      solve(root.right, target);
    }
  }

  public int closestValue(TreeNode root, double target) {
    if (root == null)
      return 0;

    closest = root.val;
    solve(root, target);
    return (int) closest;
  }
}