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
    Since this is just returning a boolean, all i need to do is traverse the tree
    using any order traversal and pass the sum so far into each invocation of the function
    
    if the sum ever equals the target, return true, else return false


*/
class Solution {
  public boolean hasPathSum(TreeNode root, int sum) {
      return recurse(root, sum, 0);
  }
  
  boolean recurse(TreeNode root, int target, int sum) {
      if(root == null) return false;
      
      sum += root.val;
      if(sum == target && root.left == null && root.right == null)
          return true;
      return recurse(root.left, target, sum) || recurse(root.right, target, sum);
  }
}   