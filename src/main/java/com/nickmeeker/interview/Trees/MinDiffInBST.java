/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


/*
    Just inorder traverse the tree, tracking the previous value at each recursive call.
    This way we can test all the possible differences in a "sorted" bst.
*/
class Solution {
  Integer prev = null;
  int min = Integer.MAX_VALUE;
  public int minDiffInBST(TreeNode root) {
      inOrder(root);
      return min;
  }
  
  void inOrder(TreeNode root) {
      if(root == null)
          return;
      
      inOrder(root.left);
      if(prev != null)
          min = Math.min(min, root.val - prev);
      prev = root.val;
      inOrder(root.right);
  }
}