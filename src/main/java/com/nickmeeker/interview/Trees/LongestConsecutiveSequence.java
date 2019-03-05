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
    if current node != previous + 1, reset the streak
    
    then just traverse the tree, getting the max of left, right, or current streak

*/
class Solution {
  public int longestConsecutive(TreeNode root) {
      if(root == null) return 0;
      return getLCS(root, root.val, 1);
  }
  
  int getLCS(TreeNode root, int previous, int streak) {
      if(root == null)
          return streak;
      
      if(root.val == previous + 1)
          streak++;
      else
          streak = 1;
      
      return Math.max(Math.max(streak, getLCS(root.left, root.val, streak)),
                      getLCS(root.right, root.val, streak));
  }
}
}