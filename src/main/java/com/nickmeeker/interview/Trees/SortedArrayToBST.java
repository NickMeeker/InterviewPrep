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
  public TreeNode sortedArrayToBST(int[] nums) {
      return recurse(0, nums.length, nums);
  }
  
  public TreeNode recurse(int low, int high, int[] nums) {
      if(low == high){
          return null;
      }
      int mid = (low + high)/2;
      TreeNode root = new TreeNode(nums[mid]);

      root.left = recurse(low, mid, nums);
      root.right = recurse(mid + 1, high, nums);
      return root;
  }
}