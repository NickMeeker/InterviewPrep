/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/*
    Just use heaps.
*/
class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
      if(lists == null) return null;
      if(lists.length == 0) return null;
      PriorityQueue<ListNode> heap = new PriorityQueue<>(lists.length, (a,b) -> a.val - b.val);
      for(ListNode list : lists) {
          if(list != null)
              heap.add(list);
      }
      ListNode head = new ListNode(-1), temp = head;
      while(!heap.isEmpty()) {
          temp.next = heap.poll();
          temp = temp.next;
          if(temp.next != null) {
              heap.add(temp.next);
          }
      }
      return head.next;
  }
}