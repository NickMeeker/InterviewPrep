/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  public int maxDepth(TreeNode root) {
      return getMaxDepth(root, 0);
  }
  
  int getMaxDepth(TreeNode root, int depth){
      if(root == null)
          return depth;
      
      return Math.max(getMaxDepth(root.left, depth+1), getMaxDepth(root.right, depth+1));
  }
}