/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
  Node head = null;
  Node tail = null;

  void recurse(Node root) {
    if (root == null)
      return;

    if (tail != null) {
      tail.right = root;
      root.left = tail;
    } else {
      head = root;
    }

    tail = root;
    recurse(root.right);
  }

  public Node treeToDoublyList(Node root) {
    if (root == null)
      return root;

    recurse(root);
    head.left = tail;
    tail.right = head;
    return head;

  }
}