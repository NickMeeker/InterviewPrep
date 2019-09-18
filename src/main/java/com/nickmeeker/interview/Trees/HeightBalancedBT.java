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
    Recurse down the binary tree, checking that the node.left height == node.right height
    for every node.
*/
class Solution {
  public boolean result = true;
  public boolean isBalanced(TreeNode root) {
      checkMaxHeight(root);
      return result;
  }
  
  public int checkMaxHeight(TreeNode root) {
      if(root == null)
          return 0;
      
      int leftHeight = checkMaxHeight(root.left) + 1;
      int rightHeight = checkMaxHeight(root.right) + 1;
      if(Math.abs(rightHeight-leftHeight) > 1) 
          result = false;
      
      return Math.max(leftHeight, rightHeight);    
  }
}