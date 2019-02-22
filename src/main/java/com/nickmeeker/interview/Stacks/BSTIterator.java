package com.nickmeeker.interview.Stacks;
import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {
  ArrayList<TreeNode> inorder;
  int index;
  void inorderTraversal(TreeNode root) {
      if(root == null) return;
      if(root.left != null) inorderTraversal(root.left);
      inorder.add(root);
      if(root.right != null) inorderTraversal(root.right);
  }
  public BSTIterator(TreeNode root) {
      inorder = new ArrayList<>();
      inorderTraversal(root);
      index = 0;
  }
  
  /** @return the next smallest number */
  public int next() {
      return inorder.get(index++).val;
  }
  
  /** @return whether we have a next smallest number */
  public boolean hasNext() {
      return index + 1 <= inorder.size();
  }
}

/**
* Your BSTIterator object will be instantiated and called as such:
* BSTIterator obj = new BSTIterator(root);
* int param_1 = obj.next();
* boolean param_2 = obj.hasNext();
*/