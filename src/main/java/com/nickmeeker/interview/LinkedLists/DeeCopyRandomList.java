/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
  public Node copyRandomList(Node head) {
      if(head == null) return null;
      Node dummyHead = new Node(-1), 
          newTemp = dummyHead, oldTemp = head;
      HashMap<Node, Node> map = new HashMap<>();
      
      while(oldTemp != null) {
          newTemp.next = new Node(oldTemp.val);
          map.put(oldTemp, newTemp.next);
          oldTemp = oldTemp.next;
          newTemp = newTemp.next;
      }
      
      oldTemp = head; 
      newTemp = dummyHead.next;
      while(oldTemp != null) {
          newTemp.random = map.get(oldTemp.random);
          newTemp = newTemp.next;
          oldTemp = oldTemp.next;
      }
      return dummyHead.next;
  }
}

