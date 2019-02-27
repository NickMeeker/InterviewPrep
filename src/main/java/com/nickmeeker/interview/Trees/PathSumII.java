/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 /**
  * PathSum but this time you keep a list representing the current path
  * after you've finished examining a node, remove it from the path
  */
class Solution {
  List<List<Integer>> output;
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
      output = new ArrayList<>();
      recurse(root, sum, 0, new ArrayList<>());
      return output;
  }
  
  void recurse(TreeNode root, int target, int sum, ArrayList<Integer> pathSoFar) {
      if(root == null) return;
      
      sum += root.val;
      pathSoFar.add(root.val);
      if(sum == target && root.left == null && root.right == null){
          output.add(new ArrayList<>(pathSoFar));
          pathSoFar.remove(pathSoFar.size() - 1);
          return;
      }
      recurse(root.left, target, sum, pathSoFar);
      recurse(root.right, target, sum, pathSoFar);
      pathSoFar.remove(pathSoFar.size() - 1);
      
  }
}