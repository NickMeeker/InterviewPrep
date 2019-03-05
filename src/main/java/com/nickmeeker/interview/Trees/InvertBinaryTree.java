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
  public TreeNode invertTree(TreeNode root) {
      invert(root);
      return root;
  }
  
  void invert(TreeNode root){
      if(root == null)
          return;
      
      TreeNode t = root.left;
      root.left = root.right;
      root.right = t;
      
      invert(root.left);
      invert(root.right);
  } 
}