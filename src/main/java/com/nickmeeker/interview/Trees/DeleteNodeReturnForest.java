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
    map every node to its parents
    put the nodes to delete in a set
    recurse over the tree
        if i hit a node to delete, then i'm starting a new list with its children

*/
class Solution {
  List<TreeNode> forestNodes = new ArrayList<>();
  Set<TreeNode> toDeleteSet = new HashSet<>();
  Set<Integer> toDeleteVals = new HashSet<>();
  
  TreeNode buildForestNodesList(TreeNode root) {
      if(root == null)
          return null;
      
      // we need to delete this val
      if(toDeleteVals.contains(root.val)) {
          if(root.left != null && !toDeleteVals.contains(root.left.val)) 
              forestNodes.add(root.left);
          
          if(root.right != null && !toDeleteVals.contains(root.right.val))
              forestNodes.add(root.right);
          
          root.left = buildForestNodesList(root.left);
          root.right = buildForestNodesList(root.right);
          return null;
      }
      
      root.left = buildForestNodesList(root.left);
      root.right = buildForestNodesList(root.right);
      return root;
 
  }
  
  public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
      if(to_delete == null || to_delete.length == 0){
          forestNodes.add(root);
          return forestNodes;
      }
      if(root == null) return new ArrayList<>();
      
      // populate toDeleteVals - the set of vals to delete
      for(int t : to_delete)
          toDeleteVals.add(t);
      
      root = buildForestNodesList(root);
      if(root != null &&!toDeleteVals.contains(root.val))
          forestNodes.add(root);
      
      return forestNodes;
  }
}