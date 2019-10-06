/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */

/*
 * 
 * dummyHead->1->2->3->4->null ^
 * 
 */
class Solution {
  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null)
      return head;

    ListNode dummyHead = new ListNode(-1);
    // keep a reference to the second node in the list
    dummyHead.next = head;
    ListNode current = dummyHead;
    while (current.next != null && current.next.next != null) {
      ListNode t1 = current.next;
      ListNode t2 = current.next.next;
      t1.next = t2.next;
      current.next = t2;
      current.next.next = t1;
      current = current.next.next;
    }

    return dummyHead.next;

  }
}