/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  int max = 0;

  int solve(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int maxHeightLeft = solve(root.left);
    int maxHeightRight = solve(root.right);

    max = Math.max(max, maxHeightLeft + maxHeightRight);
    return Math.max(maxHeightLeft, maxHeightRight) + 1;
  }

  public int diameterOfBinaryTree(TreeNode root) {
    if (root == null) {
      return 0;
    }
    solve(root);
    return max;
  }
}