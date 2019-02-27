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
    start at the root of both trees 
    if both roots are null, then just return null
    
    if both are not null, add the elements, go left, go right, and then return this node
    
    handle base cases
    make node
    go left
    go right
    return node
*/
class Solution {
  public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
      return mergedTree(t1, t2);
  }
  
  TreeNode mergedTree(TreeNode t1, TreeNode t2) {
      // if both are null, return null
      TreeNode thisNode;
      if(t1 == null && t2 == null)
          return null;
      else if(t1 != null && t2 != null) {
          thisNode = new TreeNode(t1.val + t2.val);
          thisNode.left = mergedTree(t1.left, t2.left);
          thisNode.right = mergedTree(t1.right, t2.right);
          return thisNode;
      } else if(t1 != null && t2 == null) {
          thisNode = new TreeNode(t1.val);
          thisNode.left = mergedTree(t1.left, null);
          thisNode.right = mergedTree(t1.right, null);
          return thisNode;
      } else {
          thisNode = new TreeNode(t2.val);
          thisNode.left = mergedTree(null, t2.left);
          thisNode.right = mergedTree(null, t2.right);
          return thisNode;
      }
  }
}