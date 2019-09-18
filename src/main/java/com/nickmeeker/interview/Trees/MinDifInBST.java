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
    Inorder traversal problem

*/
class Solution {
  public int globalMin;
  public TreeNode prev;
  public int getMinimumDifference(TreeNode root) {
      globalMin = Integer.MAX_VALUE;
      if(root == null) 
          return 0;
      recurse(root);
      return globalMin;
  }
  
  public void recurse(TreeNode root) {
      if(root == null)
          return;
      
      recurse(root.left);
      if(prev != null)
          globalMin = Math.min(globalMin, Math.abs(root.val - prev.val));
      prev = root; 
      recurse(root.right);
  }
}